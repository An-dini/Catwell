package com.pawpatrol.catwell.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.pawpatrol.catwell.AddressListActivity
import com.pawpatrol.catwell.data.Address
import com.pawpatrol.catwell.AddressClickListener
import com.pawpatrol.catwell.databinding.AddressListBinding

class AddressListAdapter(private val address: List<Address>, private val clickListener: AddressClickListener) :
    RecyclerView.Adapter<AddressListAdapter.ViewHolder>() {

    class ViewHolder(val binding: AddressListBinding) : RecyclerView.ViewHolder(binding.root) {
        val imgEdit: ImageView = binding.imgEdit // Add this line to access imgEdit
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AddressListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = address.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentAddress = address[position]
        val detailAddress = "${currentAddress.province}, ${currentAddress.city}, ${currentAddress.street}"

        with(holder.binding) {
            tvTitle.text = currentAddress.place
            tvAddress.text = detailAddress

            holder.imgEdit.setOnClickListener {
                clickListener.onClick(currentAddress)
            }
        }
    }
}

