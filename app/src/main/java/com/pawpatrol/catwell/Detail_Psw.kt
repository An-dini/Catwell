package com.pawpatrol.catwell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Detail_Psw : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_vet_psw)

        val backButton = findViewById(R.id.btPrev) as ImageView
        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}