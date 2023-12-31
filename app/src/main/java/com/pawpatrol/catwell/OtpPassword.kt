package com.pawpatrol.catwell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class OtpPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_password)

        val btVerif = findViewById<Button>(R.id.btVerif)
        btVerif.setOnClickListener {
            var intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        val backButton = findViewById(R.id.btPrev) as ImageView

        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}