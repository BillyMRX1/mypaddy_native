package com.mrx.mypaddynative.data

data class Plant(
    var id: Int = 0,
    var name: String = "",
    var detail: String = "",
    var solution: ArrayList<String> = ArrayList(),
    var image: Int = 0
)