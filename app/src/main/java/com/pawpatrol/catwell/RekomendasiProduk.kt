package com.pawpatrol.catwell

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pawpatrol.catwell.adapter.ProdukAdapter

class RekomendasiProduk : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var produkAdapter: ProdukAdapter
    private val gambarList = listOf(
        R.drawable.det_produk_1,
        R.drawable.det_produk_2,
        R.drawable.det_produk_3,
        R.drawable.det_produk_4,
        R.drawable.det_produk_5,
        R.drawable.det_produk_6,
        R.drawable.det_produk_7,
        R.drawable.det_produk_8,
        R.drawable.det_produk_9,
        R.drawable.det_produk_10,
        R.drawable.det_produk_11,
        R.drawable.det_produk_12,
        R.drawable.det_produk_13,
        R.drawable.det_produk_14,
        R.drawable.det_produk_15,
        R.drawable.det_produk_16,
        R.drawable.det_produk_17,
        R.drawable.det_produk_18,
        R.drawable.det_produk_19,
        R.drawable.det_produk_20,
        R.drawable.det_produk_21,
        R.drawable.det_produk_22,
        R.drawable.det_produk_23,
        R.drawable.det_produk_24
    )

    private val urlList = listOf(
        "https://shopee.co.id/Royal-Canin-kitten-pouch-LOAF-85gr-makanan-basah-kucing-85gr-i.108031550.14771366690?sp_atk=36440427-a7d1-442f-94fe-dd1e349097e8&xptdk=36440427-a7d1-442f-94fe-dd1e349097e8",
        "https://shopee.co.id/Felibite-950gr-Bentuk-Donut-Ikan-Makanan-Kucing-Kering-i.159730716.2588903908?sp_atk=0b024efc-4b90-4c8a-8b84-e834863343a4&xptdk=0b024efc-4b90-4c8a-8b84-e834863343a4",
        "https://shopee.co.id/Snack-Kucing-Ciao-Chu-Ru-56gr-isi-4-i.29618259.778974129?sp_atk=2021674f-7ae0-40f4-ad94-5d2e4117dff4&xptdk=2021674f-7ae0-40f4-ad94-5d2e4117dff4",
        "https://shopee.co.id/Angola-Papan-Garuk-Kucing-Mainan-M12-M13-M15-Cat-Scratch-Board-Extra-Tebal-Garukan-Hewan-Peliharaan-i.166819866.18916974390?sp_atk=18d21268-252e-4962-9ba1-0cc02c67f234&xptdk=18d21268-252e-4962-9ba1-0cc02c67f234",
        "https://shopee.co.id/Meow-Cat-Shampoo-Anti-Rontok-Kutu-i.52969763.19512384699?sp_atk=624b96a6-64f5-4cb1-abb1-3fcaa527b379&xptdk=624b96a6-64f5-4cb1-abb1-3fcaa527b379",
        "https://shopee.co.id/Virbac-Nutri-Plus-Gel-120.5g-Nutriplus-Gel-Vitamin-Penambah-Nafsu-Makan-Kucing-Anjing-Nutri-Plus-Gel-i.757682635.11295728011?sp_atk=c73b64b7-89d0-48cf-9e02-286c94a09353&xptdk=c73b64b7-89d0-48cf-9e02-286c94a09353",
        "https://shopee.co.id/equilibrio-adult-kitten-makanan-kucing-dewasa-dan-anak-1kg-i.325523827.8470546075?sp_atk=585c961e-c7d2-4097-8f45-b86a0b691b30&xptdk=585c961e-c7d2-4097-8f45-b86a0b691b30",
        "https://shopee.co.id/PROPLAN-ADULT-CAT-CHICKEN-FRESHPACK-1.5-KG-i.12436935.8817855670?sp_atk=b38e1a75-78ba-4da2-a812-fc1348b86184&xptdk=b38e1a75-78ba-4da2-a812-fc1348b86184",
        "https://shopee.co.id/Whiskas-Makanan-Kucing-Kering-1.2-kg-i.76617760.1277560000?sp_atk=3a5b11d9-ca71-45a1-a902-4a2f58653f67&xptdk=3a5b11d9-ca71-45a1-a902-4a2f58653f67",
        "https://shopee.co.id/Me-O-Creamy-Treats-Sachet-Ecer-15gr-Snack-Kuci-Liquid-i.307707400.18622270837?sp_atk=d93d70c8-db7c-493c-86e5-06ffbb9f250f&xptdk=d93d70c8-db7c-493c-86e5-06ffbb9f250f",
        "https://shopee.co.id/KANDANG-KUCING-SANGKAR-KUCING-BESI-IMPORT-SIZE-JUMBO-BESAR-LARGE-PET-CARGO-UMBARAN-i.156309105.6219409808?sp_atk=11311e36-11c2-41d0-a28a-3b83c0532ec2&xptdk=11311e36-11c2-41d0-a28a-3b83c0532ec2",
        "https://shopee.co.id/Wellness-CORE-Kitten-Formula-Deboned-Turkey-Chicken-REPACK-250g-500g-i.86264969.14616270247?sp_atk=9a0e6bf8-b38a-42c4-a218-80ec239132e9&xptdk=9a0e6bf8-b38a-42c4-a218-80ec239132e9",
        "https://shopee.co.id/Rompi-Anjing-Harness-Baju-Kucing-Tali-Rompi-Vest-Hewan-Tali-Tuntun-Pet-Dog-Leash-Murah-i.243384813.12360252323?sp_atk=17cee4ac-56d1-4760-a971-20edf922aa34&xptdk=17cee4ac-56d1-4760-a971-20edf922aa34",
        "https://shopee.co.id/PASIR-KUCING-WANGI-GUMPAL-MARKOTOPS-25L-NO-CUBNKIT-NO-TOP-GOSEND-GRAB-i.400770224.21858018114?sp_atk=b4b6aac7-5767-4771-be58-9394eb250357&xptdk=b4b6aac7-5767-4771-be58-9394eb250357",
        "https://shopee.co.id/CPPETINDO-Nature-Bridge-Adult-Cat-Food-1-5kg-i.25592536.309123818?sp_atk=b463df8e-7003-437c-a0db-bb409b63453e&xptdk=b463df8e-7003-437c-a0db-bb409b63453e",
        "https://shopee.co.id/Olive-Care-Shampo-Kucing-Oil-Free-DEGREASER-untuk-Anti-Rontok-Bulu-Berminyak-Kotor-dan-Kembangin-Bulu-i.176794615.11738000644?sp_atk=3c932f21-90ba-42e6-92ff-5e5081eb5273&xptdk=3c932f21-90ba-42e6-92ff-5e5081eb5273",
        "https://shopee.co.id/garukan-kucing-cakaran-kucing-model-cacing-i.645745155.20947759017?sp_atk=810f9b36-5a61-4798-8378-e673f2b61edd&xptdk=810f9b36-5a61-4798-8378-e673f2b61edd",
        "https://shopee.co.id/Cat-Condo-Rumah-Kucing-interaktif-CATTREE-CONDO-SCRATHER-RUMAH-BOX-DAN-TIANG-GARUKAN-UNTUK-SEMUA-USIA-HEWAN-KUCING-siap-melayani-pesanan-jumlah-banyak-i.283964763.21478492756?sp_atk=1fb93c66-80a4-424d-927f-b3c118f718d6&xptdk=1fb93c66-80a4-424d-927f-b3c118f718d6",
        "https://shopee.co.id/Olive-Care-Vitamin-Penebal-Pemanjang-Pencegah-Anti-Bulu-Rontok-Kucing-i.200152280.3184092271?sp_atk=a4261144-1979-4dd3-93e9-476aabd1e39d&xptdk=a4261144-1979-4dd3-93e9-476aabd1e39d",
        "https://shopee.co.id/RAID-ALL-Smooth-touch-Cat-Shampo-Kucing-1L-i.48831728.2694404910?sp_atk=7d944ea3-289d-4304-802c-86ccc639dc81&utm_campaign=-&utm_content=14959-jHW6d4yINFmyoDfUasA8baQmRI8FBJaOILtjxnj06wQgS1Lt-https%3A%2F%2Fid.my-best.com-4e0cb6fb5fb446d1c92ede2ed8780188-&utm_medium=affiliates&utm_source=an_11146330000&utm_term=a2k4d1un84vj",
        "https://shopee.co.id/product/869802272/22743995310",
        "https://shopee.co.id/Royal-Canin-Adult-Persian-400gr-i.56418458.964716893?sp_atk=94f73383-a58a-4bab-bfa4-b3f626b5677f&xptdk=94f73383-a58a-4bab-bfa4-b3f626b5677f",
        "https://www.tokopedia.com/search?st=product&q=Pet%20Voyager%20tas%20travel%20tenteng%20hewan%20kucing%20anjing%20kelinci%20ayam"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rekomendasi_produk)

        val tvTitle: TextView = findViewById(R.id.tvTitle)
        val tvSubtitle: TextView = findViewById(R.id.tvSubtitle)

        tvTitle.text = "Rekomendasi Produk"
        tvSubtitle.text = "Direkomedasikan untuk anabul"

        val backButton = findViewById(R.id.btPrev) as ImageView

        backButton.setOnClickListener {
            onBackPressed()
        }

        recyclerView = findViewById(R.id.rvProduk)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        produkAdapter = ProdukAdapter(this, gambarList, urlList, this)
        recyclerView.adapter = produkAdapter
    }

    fun onProdukClicked(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
