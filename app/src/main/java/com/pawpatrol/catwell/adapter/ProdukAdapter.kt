package com.pawpatrol.catwell.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.pawpatrol.catwell.R
import com.pawpatrol.catwell.RekomendasiProduk

class ProdukAdapter(private val context: Context, private val gambarList: List<Int>, private val urlList: List<String>, private val clickListener: RekomendasiProduk) :
    RecyclerView.Adapter<ProdukAdapter.ProdukViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdukViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.produk_item, parent, false)
        return ProdukViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdukViewHolder, position: Int) {
        val gambarResource = gambarList[position]
        holder.imageView.setImageResource(gambarResource)

        holder.imageView.setOnClickListener {
            val url = urlList[position]
            clickListener.onProdukClicked(url)
        }
    }

    override fun getItemCount(): Int {
        return gambarList.size
    }

    inner class ProdukViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}
