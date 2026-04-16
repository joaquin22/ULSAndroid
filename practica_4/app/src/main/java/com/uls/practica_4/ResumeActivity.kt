package com.uls.practica_4

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textview.MaterialTextView

class ResumeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resume)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra(FormSerializer.NAME)
        val age = intent.getStringExtra(FormSerializer.AGE)
        val city = intent.getStringExtra(FormSerializer.CITY)
        val email = intent.getStringExtra(FormSerializer.EMAIL)
        Log.d("ResumeActivity", "Received data from intent: name=$name, age=$age, city=$city, email=$email")
        val nameTextView = findViewById<MaterialTextView>(R.id.text_view_name)
        val ageTextView = findViewById<MaterialTextView>(R.id.text_view_age)
        val cityTextView = findViewById<MaterialTextView>(R.id.text_view_city)
        val emailTextView = findViewById<MaterialTextView>(R.id.text_view_email)

        nameTextView.text = "$name"
        ageTextView.text = "$age"
        cityTextView.text = "$city"
        emailTextView.text = "$email"
    }
}