package com.pawpatrol.catwell.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.pawpatrol.catwell.HalamanProduk
import com.pawpatrol.catwell.ListProduk
import com.pawpatrol.catwell.R

class ListProdukAdapter constructor(
    private val getActivity: HalamanProduk,
    private val produkList: List<ListProduk>
):
    RecyclerView.Adapter<ListProdukAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rekomen_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.ivProduk.setImageResource(produkList[position].image)

    }

    override fun getItemCount(): Int {
        return produkList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProduk: ImageView = itemView.findViewById(R.id.ivproduk)
        val cardView: CardView = itemView.findViewById(R.id.cardView1)
    }


}