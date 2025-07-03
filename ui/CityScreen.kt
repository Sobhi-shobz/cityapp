package com.example.mycity.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycity.viewmodel.CityViewModel

@Composable
fun CityScreen(viewModel: CityViewModel) {
    val places by viewModel.places.collectAsState()
    var selectedPlace by remember { mutableStateOf<CityPlace?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Explore My City", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        SearchBar(onSearch = viewModel::search)
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(places.size) { index ->
                CityCard(place = places[index], onClick = { selectedPlace = it })
            }
        }
    }

    selectedPlace?.let {
        DetailDialog(place = it, onDismiss = { selectedPlace = null })
    }
}
