package com.uls.practica_3

import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar

class ImagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_images)

        val toolbar = findViewById<Toolbar>(R.id.materialToolbar)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val inputText = findViewById<EditText>(R.id.inputText)

        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        imageView.setOnClickListener {
            val text = inputText.text ?: "No hay texto"
            Toast.makeText(this, text , Toast.LENGTH_SHORT).show()
        }

    }
}
