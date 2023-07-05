package com.example.pawsome.components

import com.example.pawsome.R

data class DogsData(val imageResId: Int, val text: String,  val destinationRoute: String)
val dogCardItems = listOf(
    DogsData(R.drawable.dog1_maltipoo, "Sheru, Pune", "MaltipooDogScreen"),
    DogsData(R.drawable.dog7_shifu, "Rocky, Nagpur", ""),
    DogsData(R.drawable.dog3_shih_tzu, "Hira, Mumbai", ""),
    DogsData(R.drawable.dog4_puh, "Pooh, Chandrapur", ""),
    DogsData(R.drawable.dog6_sheru, "Husky, Amravati", ""),
    DogsData(R.drawable.dog2_chowchow, "Goldy, Beed", ""),
    DogsData(R.drawable.dog5_husky, "Cookie, Solapur", ""),
)
