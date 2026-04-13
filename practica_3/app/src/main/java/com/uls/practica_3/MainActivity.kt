package com.uls.practica_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val navigateImages = findViewById<Button>(R.id.navigate_to_images)
        val navigateMedia = findViewById<Button>(R.id.navigate_to_media)

        navigateImages.setOnClickListener {
            val intent = Intent(this, ImagesActivity::class.java)
            startActivity(intent)
        }

        navigateMedia.setOnClickListener {
            val intent = Intent(this, MediaActivity::class.java)
            startActivity(intent)
        }
    }
}