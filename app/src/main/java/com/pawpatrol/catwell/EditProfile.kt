package com.pawpatrol.catwell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class EditProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        var btn_edt_profil = findViewById<Button>(R.id.btn_edt_profil)
        btn_edt_profil.setOnClickListener {
            var intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        val backButton = findViewById(R.id.btPrev) as ImageButton

        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}