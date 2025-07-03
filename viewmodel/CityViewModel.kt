package com.example.mycity.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mycity.data.CityPlace
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CityViewModel : ViewModel() {
    private val allPlaces = samplePlaces()
    private val _filteredPlaces = MutableStateFlow(allPlaces)
    val places: StateFlow<List<CityPlace>> = _filteredPlaces

    fun search(query: String) {
        _filteredPlaces.value = if (query.isBlank()) {
            allPlaces
        } else {
            allPlaces.filter {
                it.name.contains(query, ignoreCase = true) ||
                it.category.contains(query, ignoreCase = true)
            }
        }
    }
}

private fun samplePlaces(): List<CityPlace> = listOf(
    CityPlace(1, "Victoria Memorial", "Attraction", "Colonial-era museum in a white marble building.", "https://via.placeholder.com/150", "https://maps.google.com/?q=Victoria+Memorial"),
    CityPlace(2, "Flurys", "Restaurant", "Iconic tearoom serving pastries & breakfast.", "https://via.placeholder.com/150", "https://maps.google.com/?q=Flurys+Kolkata"),
    CityPlace(3, "Kolkata Book Fair", "Event", "Annual international book fair with global participation.", "https://via.placeholder.com/150", "https://maps.google.com/?q=Kolkata+Book+Fair")
)
