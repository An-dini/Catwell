package com.pawpatrol.catwell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Profile : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val txtviewalmt: TextView = findViewById(R.id.almt_rumah)
        txtviewalmt.setOnClickListener(this)
        val txtviedtpass: TextView = findViewById(R.id.edt_pass)
        txtviedtpass.setOnClickListener(this)
        val txtviedtlogout: TextView = findViewById(R.id.logout)
        txtviedtlogout.setOnClickListener(this)
        val txtviedtprofil: TextView = findViewById(R.id.edit_profile)
        txtviedtprofil.setOnClickListener(this)
        val txtvihapusakn: TextView = findViewById(R.id.hps_akn)
        txtvihapusakn.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.almt_rumah -> {
                val intent = Intent(this@Profile, AddressListActivity::class.java)
                startActivity(intent)
            }
        }
        when (v.id) {
            R.id.edt_pass-> {
                val intent = Intent(this@Profile, EditPassword::class.java)
                startActivity(intent)
            }
        }
        when (v.id) {
            R.id.logout-> {
                val intent = Intent(this@Profile, Logout::class.java)
                startActivity(intent)
            }
        }
        when (v.id) {
            R.id.edit_profile-> {
                val intent = Intent(this@Profile, EditProfile::class.java)
                startActivity(intent)
            }
        }
        when (v.id) {
            R.id.hps_akn-> {
                val intent = Intent(this@Profile, HapusAkun::class.java)
                startActivity(intent)
            }
        }
    }
}