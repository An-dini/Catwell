package com.pawpatrol.catwell

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class ChatLogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_log)

        setupDummyData()

        val backButton = findViewById(R.id.btPrev) as ImageView
        backButton.setOnClickListener {
            onBackPressed()
        }

        var tvTimer = findViewById<TextView>(R.id.tvTimer)
        var ivTimer = findViewById<ImageView>(R.id.ivTimer)
        val handler = Handler(Looper.getMainLooper())
        val tvTitle: TextView = findViewById(R.id.tvTitle)
        val tvSubtitle: TextView = findViewById(R.id.tvSubtitle)

        tvTitle.text = "Konsultasi"
        tvSubtitle.text = "Beritahu keluhan kucing kamu"

        if (intent.getBooleanExtra("startConsultation", false)) {
            handler.postDelayed({
                timesUpDialog()
            }, 5000)
        }else{
            tvTimer.visibility = View.GONE
            ivTimer.visibility = View.GONE
        }

    }

    private fun setupDummyData(){
        val rvChatLog = findViewById<RecyclerView>(R.id.rvChatLog)
        val adapter = GroupAdapter<GroupieViewHolder>()

        adapter.add(ChatFromItem("Halo! Dengan Drh. Aji disini, keluhan apa yang dapat saya bantu? Boleh disampaikan ya  "))
        adapter.add(ChatToItem("Halo Dokter, kucing saya sudah dua hari ini diare. Apa yang harus saya lakukan ya dok?"))
        adapter.add(ChatFromItem("Terima kasih atas informasinya. Saya akan bertanya beberapa pertanyaan terlebih dahulu. Apakah ada perubahan dalam nafsu makan kucing anda akhir-akhir ini?"))
        adapter.add(ChatToItem("Nafsu makannya normal tapi kucing saya lemas beberapa hari ini. kucingnya sempat muntah juga beberapa hari lalu."))

        rvChatLog.layoutManager = LinearLayoutManager(this) // Menambahkan layout manager jika belum ada
        rvChatLog.adapter = adapter
    }

    private  fun  timesUpDialog(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.dialog_times_up)

        val btKirim: Button = dialog.findViewById(R.id.btKirim)
        btKirim.setOnClickListener {
            val intent = Intent(this, HistoryConsultationDetailActivity::class.java)
            startActivity(intent)
        }
        dialog.show()
    }
}

class ChatFromItem(val text: String) : Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val textviewFromRow = viewHolder.itemView.findViewById<TextView>(R.id.tvFromRow)
        textviewFromRow.text = text
    }

    override fun getLayout(): Int {
        return R.layout.chat_from_row
    }
}

class ChatToItem(val text: String) : Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val textviewToRow = viewHolder.itemView.findViewById<TextView>(R.id.tvToRow)
        textviewToRow.text = text
    }

    override fun getLayout(): Int {
        return R.layout.chat_to_row
    }
}


