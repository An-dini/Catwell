package com.pawpatrol.catwell.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pawpatrol.catwell.TransactionClickListener
import com.pawpatrol.catwell.data.Transaction
import com.pawpatrol.catwell.databinding.HistoryConsultationListBinding
import java.text.NumberFormat
import java.util.Locale

class TransactionListAdapter(private val transaction: List<Transaction>, private val clickListener: TransactionClickListener) :
    RecyclerView.Adapter<TransactionListAdapter.ViewHolder>()
{
    class ViewHolder(val binding: HistoryConsultationListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val binding = HistoryConsultationListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = transaction.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        with(holder){
            with(transaction[position]){
                val formattedPrice = NumberFormat.getNumberInstance(Locale("id", "ID")).format(this.price)
                val transactionDescription = "Pembayaran via ${this.paymentMethod} sebesar Rp$formattedPrice"


                binding.tvDate.text = this.date
                binding.tvTime.text = this.time
                binding.tvPayment.text = transactionDescription

                binding.clTransaction.setOnClickListener {
                    clickListener.onClick(this)
                }
            }
        }
    }
}


