package com.uls.practica_4

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class ResumeActivity : AppCompatActivity() {
    private lateinit var btnConfirm: MaterialButton
    private lateinit var btnBack: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_resume)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra(UserSerializer.NAME)
        val age = intent.getStringExtra(UserSerializer.AGE)
        val city = intent.getStringExtra(UserSerializer.CITY)
        val email = intent.getStringExtra(UserSerializer.EMAIL)

        Log.d("ResumeActivity", "Received data from intent: name=$name, age=$age, city=$city, email=$email")

        val nameTextView = findViewById<MaterialTextView>(R.id.text_view_name)
        val ageTextView = findViewById<MaterialTextView>(R.id.text_view_age)
        val cityTextView = findViewById<MaterialTextView>(R.id.text_view_city)
        val emailTextView = findViewById<MaterialTextView>(R.id.text_view_email)

        nameTextView.text = "$name"
        ageTextView.text = "$age"
        cityTextView.text = "$city"
        emailTextView.text = "$email"

        btnConfirm = findViewById(R.id.confirm_button)
        btnBack = findViewById(R.id.back_button)

        btnConfirm.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
        btnBack.setOnClickListener {
            finish()
        }
    }
}