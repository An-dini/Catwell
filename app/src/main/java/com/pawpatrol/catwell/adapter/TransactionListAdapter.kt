package com.pawpatrol.catwell

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pawpatrol.catwell.databinding.DoctorListItemBinding
import com.pawpatrol.catwell.databinding.FragmentTransactionHistoryBinding
import com.pawpatrol.catwell.databinding.HistoryConsultationListBinding

class TransactionListAdapter(private val transactions: List<Transaction>, private val clickListener: TransactionClickListener)
: RecyclerView.Adapter<TransactionListAdapter.ViewHolder>()
{
    class ViewHolder(val binding: HistoryConsultationListBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val binding = HistoryConsultationListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        with(holder){
            with(transactions[position]){
                binding.tvDate.text = this.date
                binding.tvTime.text = this.time
                binding.tvPayment.text = this.paymentMethod

                binding.clTransaction.setOnClickListener{
                    clickListener.onClick(this)
                }
            }
        }
    }

    override fun getItemCount(): Int = transactions.size
}


