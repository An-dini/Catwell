package com.pawpatrol.catwell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        var edt_forpasswd = findViewById<Button>(R.id.edt_forpasswd)

        edt_forpasswd.setOnClickListener {
            var intent = Intent(this, OtpPassword::class.java)
            startActivity(intent)
        }
    }
}