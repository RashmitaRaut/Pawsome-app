package com.example.pawsome.components
import com.example.pawsome.R

data class CatsData(val imageResId: Int, val text: String, val destinationRoute: String)
val cardItems = listOf(
    CatsData(R.drawable.noorcat, "Noor, Pune", "NoorCatScreen"),
    CatsData(R.drawable.cat7, "Willow, Nagpur", ""),
    CatsData(R.drawable.cat3, "Oliver, Mumbai", ""),
    CatsData(R.drawable.cat4, "Bella, Chandrapur", ""),
    CatsData(R.drawable.cat5, "Millo, Amravati", ""),
    CatsData(R.drawable.cat6, "Pari, Beed", ""),
    CatsData(R.drawable.cat2, "Luna, Solapur", ""),
    CatsData(R.drawable.cat8, "Dandellion, Nashik", ""),
)