package com.uls.practica_4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSubmit = findViewById<Button>(R.id.btn_send_form)
        btnSubmit.setOnClickListener { onSubmit() }
    }

    fun onSubmit() {
        val name = findViewById<TextInputLayout>(R.id.text_input_name).editText!!.text.toString()
        val age = findViewById<TextInputLayout>(R.id.text_input_age).editText!!.text.toString()
        val city = findViewById<TextInputLayout>(R.id.text_input_city).editText!!.text.toString()
        val email = findViewById<TextInputLayout>(R.id.text_input_email).editText!!.text.toString()

        val intent = Intent(this, ResumeActivity::class.java)
        Log.d("MainActivity", "Creating intent to start ResumeActivity with data: name=$name, age=$age, city=$city, email=$email")
        intent.putExtra(FormSerializer.NAME, name)
        intent.putExtra(FormSerializer.AGE, age)
        intent.putExtra(FormSerializer.CITY, city)
        intent.putExtra(FormSerializer.EMAIL, email)

        startActivity(intent)
    }
}