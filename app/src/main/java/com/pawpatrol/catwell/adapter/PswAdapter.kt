package com.pawpatrol.catwell.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.infopswvet.Data.PswData
import com.pawpatrol.catwell.VetAdapter
import com.pawpatrol.catwell.data.VetData
import com.pawpatrol.catwell.databinding.ListPswBinding
import java.util.ArrayList

class PswAdapter(private val pswlist:List<PswData>, private val clickListener: VetClickListener) :
    RecyclerView.Adapter<PswAdapter.ViewHolder>()
{
    class ViewHolder(val binding: ListPswBinding) : RecyclerView.ViewHolder(binding.root)

    private lateinit var adapter: VetAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var vetdata: ArrayList<VetData>

    lateinit var image: List<Int>
    lateinit var namavet: List<String>
    lateinit var deskripsi: List<String>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListPswBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = pswlist.size
    override fun onBindViewHolder(holder: PswAdapter.ViewHolder, position: Int)

    {
        with(holder){
            with(pswlist[position]){
                binding.imgPsw1.setImageResource(this.image)
                binding.namaVet.text= this.namapsw
                binding.deskripsiVet.text= this.deskripsi

                binding.cardView.setOnClickListener{
                    clickListener.onClick(this)
                }
            }
        }
    }interface VetClickListener
{
    fun onClick(pswdata: PswData)
}

    private fun dataInitialize(){
        vetdata = arrayListOf<VetData>()
    }
}
