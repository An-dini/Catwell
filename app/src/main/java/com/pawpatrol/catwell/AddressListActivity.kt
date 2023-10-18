package com.pawpatrol.catwell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pawpatrol.catwell.adapter.AddressListAdapter
import com.pawpatrol.catwell.data.Address
import com.pawpatrol.catwell.data.addressList
import com.pawpatrol.catwell.databinding.ActivityAddressListBinding

class AddressListActivity : AppCompatActivity(), AddressClickListener {

    private lateinit var binding: ActivityAddressListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddressListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvTitle: TextView = findViewById(R.id.tvTitle)
        val tvSubtitle: TextView = findViewById(R.id.tvSubtitle)

        tvTitle.text = "Alamat Rumah"
        tvSubtitle.text = "Daftar alamat rumah"

        addresses()
        setupRecyclerView()

        var btAdd = findViewById<FloatingActionButton>(R.id.btAdd)

        btAdd.setOnClickListener {
            var intent = Intent(this, EditAddressActivity::class.java)
            startActivity(intent)
        }

        val backButton = findViewById(R.id.btPrev) as ImageView
        backButton.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onClick(address: Address) {
        val intent = Intent(this, EditAddressActivity::class.java)
        intent.putExtra("addressId", address.id)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        addresses()

        binding.rvAddress.apply {
            layoutManager = LinearLayoutManager(this@AddressListActivity)
            adapter = AddressListAdapter(addressList, this@AddressListActivity)
        }
    }


    private fun addresses() {
        val namePerson = resources.getStringArray(R.array.name_person)
        val namePlace = resources.getStringArray(R.array.place_name)
        val numberPhone = resources.getStringArray(R.array.phone_number)
        val nameProvince = resources.getStringArray(R.array.province)
        val nameCity = resources.getStringArray(R.array.city)
        val nameStreet = resources.getStringArray(R.array.street)
        val settingDefaultStrings = resources.getStringArray(R.array.setting_default)

        for (i in namePerson.indices) {
            val settingDefaultString = settingDefaultStrings[i] // Retrieve the settingDefault string

            val settingDefault: Boolean = when (settingDefaultString) {
                "true" -> true
                "false" -> false
                else -> false
            }

            val address = Address(
                namePlace[i],
                namePerson[i],
                numberPhone[i],
                nameProvince[i],
                nameCity[i],
                nameStreet[i],
                settingDefault
            )
            addressList.add(address)
        }
    }
}
