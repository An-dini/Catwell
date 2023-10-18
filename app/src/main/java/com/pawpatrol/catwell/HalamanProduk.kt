package com.pawpatrol.catwell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pawpatrol.catwell.adapter.ListProdukAdapter

class HalamanProduk : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var recyclerListProdukAdapter: ListProdukAdapter? = null
    private var produkList = mutableListOf<ListProduk>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_produk)

        produkList = ArrayList()

        recyclerView = findViewById<View>(R.id.rvListProduk) as RecyclerView
        recyclerListProdukAdapter = ListProdukAdapter(this@HalamanProduk, produkList)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerListProdukAdapter

        prepareDataProduk()
    }

    private fun prepareDataProduk() {
        var produk = ListProduk(R.drawable.listproduk1)
        produkList.add(produk)
        produk = ListProduk(R.drawable.listproduk2)
        produkList.add(produk)
        produk = ListProduk(R.drawable.listproduk3)
        produkList.add(produk)
        produk = ListProduk(R.drawable.listproduk4)
        produkList.add(produk)
        produk = ListProduk(R.drawable.listproduk5)
        produkList.add(produk)
        produk = ListProduk(R.drawable.listproduk6)
        produkList.add(produk)

        recyclerListProdukAdapter!!.notifyDataSetChanged()
    }
}