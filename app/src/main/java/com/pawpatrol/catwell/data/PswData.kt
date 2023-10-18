package com.pawpatrol.catwell.data


var pswlist = mutableListOf<PswData>()

val PSW_ID_EXTRA = "pswExtra"
data class PswData(
    val image: Int,
    val namapsw: String,
    val deskripsi: String,
    val id: Int? = pswlist.size
)
