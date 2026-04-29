package com.uls.practica_5.ui.screens

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.uls.practica_5.ui.componets.DialogResume
import com.uls.practica_5.ui.content.FormContent


@Composable
fun FormScreen(
    modifier: Modifier = Modifier
){

    var name  by remember { mutableStateOf("") }
    var age    by remember { mutableStateOf("") }
    var email  by remember { mutableStateOf("") }
    val genereOptions = listOf("Masculino", "Femenino", "Prefiero no decir")
    var genereSelected by remember { mutableStateOf(genereOptions[0]) }
    var terms by remember { mutableStateOf(false) }
    var notifications by remember { mutableStateOf(false) }
    var isSend by remember { mutableStateOf(false) }

    val openDialog = remember { mutableStateOf(false) }

    val nameError  = isSend && name.isBlank()
    val ageError    = isSend && (age.isBlank() || age.toIntOrNull() == null)
    val emailError  = isSend && !email.contains("@")
    val termsError = isSend && !terms

    val context = LocalContext.current

    FormContent(
        modifier = modifier,
        name = name,
        age = age,
        email = email,
        notifications = notifications,
        terms= terms,
        genereOptions = genereOptions,
        genereSelected = genereSelected,
        nameError = nameError,
        ageError = ageError,
        emailError = emailError,
        termsError = termsError,
        onNameChange = { name = it },
        onAgeChange = {
            if (it.length <= 3) age = it.filter { c -> c.isDigit() }
        },
        onEmailChange = { email = it },
        onGenereSelected = { genereSelected = it },
        onNotificationChange = { notifications = it },
        onTermsChange = { terms = it },
        onSendClick = {
            isSend = true
            val isValid = name.isNotBlank()
                    && age.toIntOrNull() != null
                    && email.contains("@")
                    && terms
            if (isValid) {
                openDialog.value = true

            }
        },
        onClearClick = {
            name = ""
            age = ""
            email = ""
            notifications = false
            terms = false
            isSend = false
        }
    )

    when{
        openDialog.value -> {
            DialogResume(
                dialogText = "Nombre: $name\nEdad: $age\nEmail: $email\nGénero: $genereSelected\nNotificaciones: ${if (notifications) "Sí" else "No"}\nTérminos aceptados: ${if (terms) "Sí" else "No"}",
                onDismissRequest = { openDialog.value = false },
                onConfirmation = {
                    openDialog.value = false
                    Toast.makeText(context, "Información confirmada", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}