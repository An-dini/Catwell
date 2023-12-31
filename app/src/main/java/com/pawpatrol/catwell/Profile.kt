package com.pawpatrol.catwell

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
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

        val backButton = findViewById(R.id.btPrev) as ImageView

        backButton.setOnClickListener {
            onBackPressed()
        }
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
                LogoutAccountDialog()
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
                deleteAccountDialog()
            }
        }
    }

    private  fun  deleteAccountDialog(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.popup_hapus_akun)

        val btYa: Button = dialog.findViewById(R.id.btYa)
        btYa.setOnClickListener {
            val intent = Intent(this@Profile, Login::class.java)
            startActivity(intent)
        }

        val btTidak: Button = dialog.findViewById(R.id.btTidak)
        btTidak.setOnClickListener {
            dialog.dismiss()
        }


        dialog.show()
    }

    private  fun  LogoutAccountDialog(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.popup_logout)

        val btYa: Button = dialog.findViewById(R.id.btYa)
        btYa.setOnClickListener {
            val intent = Intent(this@Profile, Login::class.java)
            startActivity(intent)
        }

        val btTidak: Button = dialog.findViewById(R.id.btTidak)
        btTidak.setOnClickListener {
            dialog.dismiss()
        }


        dialog.show()
    }

}