package com.example.mycity.data

data class CityPlace(
    val id: Int,
    val name: String,
    val category: String, // e.g., "Attraction", "Restaurant", "Event"
    val description: String,
    val imageUrl: String,
    val mapLocation: String // e.g., geo URI or Google Maps link
)
