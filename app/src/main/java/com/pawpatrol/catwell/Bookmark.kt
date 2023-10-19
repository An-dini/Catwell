package com.pawpatrol.catwell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Bookmark : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        val backButton = findViewById(R.id.btPrev) as ImageView

        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}