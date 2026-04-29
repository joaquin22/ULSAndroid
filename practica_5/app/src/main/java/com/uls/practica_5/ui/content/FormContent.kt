package com.uls.practica_5.ui.content

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uls.practica_5.ui.componets.FormField
import com.uls.practica_5.ui.componets.SectionLabel
import com.uls.practica_5.ui.theme.Error
import com.uls.practica_5.ui.theme.Practica_5Theme
import com.uls.practica_5.ui.theme.Purple40
import com.uls.practica_5.ui.theme.Slate

@Composable
fun FormContent(
    modifier: Modifier = Modifier,
    name: String = "",
    age: String = "",
    email: String = "",
    notifications: Boolean = false,
    terms: Boolean = false,
    genereOptions: List<String>,
    genereSelected: String,
    nameError: Boolean = false,
    ageError: Boolean = false,
    emailError: Boolean = false,
    termsError: Boolean = false,
    onNameChange : (String) -> Unit = {},
    onAgeChange : (String) -> Unit = {},
    onEmailChange : (String) -> Unit = {},
    onGenereSelected : (String) -> Unit = {},
    onNotificationChange : (Boolean) -> Unit = {},
    onTermsChange : (Boolean) -> Unit = {},
    onSendClick : () -> Unit = {},
    onClearClick : () -> Unit = {},
) {

    Box(
        modifier = modifier
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Column {
                Text(text = "Registro de usuario",
                    style = MaterialTheme.typography.headlineMedium)
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(15.dp),
                colors = CardDefaults.cardColors(contentColor = androidx.compose.ui.graphics.Color(Color.WHITE)),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ){
                    SectionLabel(icon = "👤", label = "Datos personales")

                    FormField(
                        value = name,
                        onValueChange = onNameChange,
                        label = "Nombre completo",
                        placeholder = "Ej. María García",
                        isError = nameError,
                        errorMessage = "El nombre es obligatorio",
                        keyboardType = KeyboardType.Text
                    )

                    FormField(
                        value = age,
                        onValueChange = onAgeChange,
                        label = "Edad",
                        placeholder = "Ej. 25",
                        isError = ageError,
                        errorMessage = "Ingresa una edad válida",
                        keyboardType = KeyboardType.Number
                    )

                    // Correo
                    FormField(
                        value = email,
                        onValueChange = onEmailChange,
                        label = "Correo electrónico",
                        placeholder = "Ej. maria@email.com",
                        isError = emailError,
                        errorMessage = "Ingresa un correo válido",
                        keyboardType = KeyboardType.Email
                    )
                }
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = androidx.compose.ui.graphics.Color(Color.WHITE)),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    SectionLabel(icon = "🙋", label = "Género")
                    genereOptions.forEach { option ->
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = genereSelected == option,
                                onClick = { onGenereSelected(option) },
                                colors = RadioButtonDefaults.colors(selectedColor = Purple40)
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(text = option, fontSize = 14.sp, color = Slate)
                        }
                    }
                }
            }

            Card(
                modifier  = Modifier.fillMaxWidth(),
                shape     = RoundedCornerShape(20.dp),
                colors    = CardDefaults.cardColors(containerColor = androidx.compose.ui.graphics.Color(Color.WHITE)),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier            = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    SectionLabel(icon = "⚙️", label = "Preferencias")

                    // Switch
                    Row(
                        modifier              = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment     = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text       = "Notificaciones",
                                fontSize   = 14.sp,
                                color      = Slate
                            )
                            Text(
                                text     = "Recibir actualizaciones por email",
                                fontSize = 12.sp,
                                color    = Slate
                            )
                        }
                        Switch(
                            checked         = notifications,
                            onCheckedChange = onNotificationChange,
                        )
                    }

                    HorizontalDivider(color = Slate)

                    // Checkbox
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier          = Modifier.fillMaxWidth()
                    ) {
                        Checkbox(
                            checked         = terms,
                            onCheckedChange = onTermsChange,
                        )
                        Spacer(Modifier.width(8.dp))
                        Column {
                            Text(
                                text     = "Acepto los términos y condiciones",
                                fontSize = 14.sp,
                                color    = Slate
                            )
                            if (termsError) {
                                Text(
                                    text     = "Debes aceptar para continuar",
                                    fontSize = 12.sp,
                                    color    = Error
                                )
                            }
                        }
                    }
                }
            }


            Button(
                onClick  = onSendClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape  = RoundedCornerShape(14.dp),
            ) {
                Text(
                    text          = "Enviar formulario",
                    fontSize      = 16.sp,
                )
            }

            Button(
                onClick  = onClearClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape  = RoundedCornerShape(14.dp),
            ) {
                Text(
                    text          = "Limpiar formulario",
                    fontSize      = 16.sp,
                )
            }

            Spacer(Modifier.height(8.dp))
        }


    }

}
