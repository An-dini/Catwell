package com.pawpatrol.catwell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.pawpatrol.catwell.data.TRANSACTION_ID_EXTRA
import com.pawpatrol.catwell.data.Transaction
import com.pawpatrol.catwell.data.transactionList
import com.pawpatrol.catwell.databinding.HistoryConsultationDetailBinding

class HistoryConsultationDetailActivity : AppCompatActivity() {
    private lateinit var binding: HistoryConsultationDetailBinding
    private lateinit var btNewSchedule: Button
    private lateinit var btConsultationHistory: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HistoryConsultationDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btNewSchedule = findViewById(R.id.bt_newSchedule)
        btConsultationHistory = findViewById(R.id.bt_consultationHistory)
        val tvTitle: TextView = findViewById(R.id.tvTitle)
        val tvSubtitle: TextView = findViewById(R.id.tvSubtitle)

        tvTitle.text = "Riwayat Konsultasi"
        tvSubtitle.text = "Detail konsultasi mu"

        val transactionID = intent.getIntExtra(TRANSACTION_ID_EXTRA, -1)
        val transaction = transactionFromID(transactionID)


        if (transaction != null) {
            binding.name.text = transaction.doctor
            binding.instance.text = transaction.instance
            binding.date.text = transaction.date
            binding.time.text = transaction.time
            binding.price.text = transaction.price.toString()
            binding.ratingBar.rating = transaction.rating
        }

        btNewSchedule.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("newSchedule", true) // Sinyal untuk kembali ke beranda
            startActivity(intent)
        }

        btConsultationHistory.setOnClickListener {
            val intent = Intent(this, ChatLogActivity::class.java)
            startActivity(intent)
        }

        val backButton = findViewById(R.id.btPrev) as ImageView

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("transactionData", true)
            startActivity(intent)
        }

    }

    private fun transactionFromID(transactionID: Int): Transaction? {
        for (transaction in transactionList) {
            if (transaction.id == transactionID) return transaction
        }
        return null
    }
}
