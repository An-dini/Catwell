package com.pawpatrol.catwell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class EditPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_password)

        var btnSimpan = findViewById<Button>(R.id.btnSimpan)
        btnSimpan.setOnClickListener {
            var intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        val backButton = findViewById(R.id.btPrev) as ImageView

        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}