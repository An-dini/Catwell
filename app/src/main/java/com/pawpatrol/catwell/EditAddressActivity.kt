package com.pawpatrol.catwell

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pawpatrol.catwell.data.Address
import com.pawpatrol.catwell.data.addressList
import com.pawpatrol.catwell.databinding.ActivityDoctorDetailBinding
import com.pawpatrol.catwell.databinding.ActivityEditAddressBinding

class EditAddressActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditAddressBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvTitle: TextView = findViewById(R.id.tvTitle)
        val tvSubtitle: TextView = findViewById(R.id.tvSubtitle)

        tvTitle.text = "Alamat Rumah"
        tvSubtitle.text = "Daftar alamat rumah"

        val addressId = intent.getIntExtra("addressId", -1)
        val address = addressFromID(addressId)

        if (address != null) {
            binding.etName.text = Editable.Factory.getInstance().newEditable(address.name)
            binding.etPhone.text = Editable.Factory.getInstance().newEditable(address.phone)
            binding.etProvince.text = Editable.Factory.getInstance().newEditable(address.province)
            binding.etCity.text = Editable.Factory.getInstance().newEditable(address.city)
            binding.etStreet.text = Editable.Factory.getInstance().newEditable(address.street)
            binding.switchDefault.isChecked = address.settingDefault
        }

        val btnSimpan = findViewById(R.id.btnSimpan) as Button
        btnSimpan.setOnClickListener {
            val intent = Intent(this, AddressListActivity::class.java)
            startActivity(intent)
        }

        val backButton = findViewById(R.id.btPrev) as ImageView
        backButton.setOnClickListener {
            onBackPressed()
        }
    }

    private fun addressFromID(addressId: Int): Address? {
        for (address in addressList) {
            if (address.id == addressId) return address
        }
        return null
    }
}
