package com.pawpatrol.catwell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentManager
//import com.example.infopswvet.databinding.ActivityInfoVetPswBinding
//import com.example.infopswvet.databinding.ActivityMainBinding
import com.pawpatrol.catwell.databinding.ActivityInfoVetPswBinding


class Info_Vet_Psw : AppCompatActivity() {

    private lateinit var binding : ActivityInfoVetPswBinding
    private lateinit var imgbtn1:ImageButton
    private lateinit var imgbtn2:ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imgbtn1 = findViewById(R.id.img_evn1)
        imgbtn2 = findViewById(R.id.img_evn2)

        imgbtn1.setOnClickListener { val intent=Intent(this,Detail_Event::class.java)
        startActivity(intent)
        }
        imgbtn2.setOnClickListener {
            val intent = Intent(this, Detail_Event::class.java)
            startActivity(intent)
        }

        binding = ActivityInfoVetPswBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVet.setOnClickListener { replaceFragment(VetFragment()) }
        binding.btnPsw.setOnClickListener { replaceFragment(PswFragment()) }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(androidx.fragment.R.id.fragment_container_view_tag,fragment)
        fragmentTransaction.commit()

    }
}
