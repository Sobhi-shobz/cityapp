package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mycity.data.CityPlace

@Composable
fun CityCard(place: CityPlace, onClick: (CityPlace) -> Unit) {
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth()
            .clickable { onClick(place) },
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(Modifier.padding(8.dp)) {
            Image(
                painter = rememberAsyncImagePainter(place.imageUrl),
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.width(12.dp))
            Column {
                Text(place.name, style = MaterialTheme.typography.titleMedium)
                Text(place.category, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
