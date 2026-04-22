package com.uls.practica_4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var inputName: TextInputLayout
    private lateinit var inputAge: TextInputLayout
    private lateinit var inputCity: TextInputLayout
    private lateinit var inputEmail: TextInputLayout

    private val resumenLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            Toast.makeText(this, "Perfil guardado correctamente", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inputName = findViewById(R.id.text_input_name)
        inputAge = findViewById(R.id.text_input_age)
        inputCity = findViewById(R.id.text_input_city)
        inputEmail = findViewById(R.id.text_input_email)

        val btnSubmit: Button = findViewById(R.id.btn_send_form)
        btnSubmit.setOnClickListener { onSubmit() }
    }

    fun onSubmit() {
        val name = inputName.editText?.text.toString().trim()
        val age = inputAge.editText?.text.toString().trim()
        val city = inputCity.editText?.text.toString().trim()
        val email = inputEmail.editText?.text.toString().trim()

        val intent = Intent(this, ResumeActivity::class.java).apply {
                putExtra(UserSerializer.NAME, name)
                putExtra(UserSerializer.AGE, age)
                putExtra(UserSerializer.CITY, city)
                putExtra(UserSerializer.EMAIL, email)
        }

        Log.d("MainActivity", "Creating intent to start ResumeActivity with data: name=$name, age=$age, city=$city, email=$email")
        resumenLauncher.launch(intent)

    }

    override fun onSaveInstanceState(outState: Bundle) {

        super.onSaveInstanceState(outState)

        val name = inputName.editText?.text.toString().trim()
        val age = inputAge.editText?.text.toString().trim()
        val city = inputCity.editText?.text.toString().trim()
        val email = inputEmail.editText?.text.toString().trim()

        outState.putString("name", name)
        outState.putString("age", age)
        outState.putString("city", city)
        outState.putString("email", email)
    }
}