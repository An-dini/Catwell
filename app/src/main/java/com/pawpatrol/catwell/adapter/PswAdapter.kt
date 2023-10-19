package com.pawpatrol.catwell.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pawpatrol.catwell.data.PswData
import com.pawpatrol.catwell.databinding.ListPswBinding

class PswAdapter(private val pswlist: List<PswData>, private val clickListener: (PswData) -> Unit) :
    RecyclerView.Adapter<PswAdapter.ViewHolder>()
{
    class ViewHolder(val binding: ListPswBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListPswBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = pswlist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(pswlist[position]) {
                binding.imgPsw1.setImageResource(this.image)
                binding.namaVet.text = this.namapsw
                binding.deskripsiVet.text = this.deskripsi

                binding.layoutPsw.setOnClickListener {
                    clickListener(this)
                }
            }
        }
    }
}
