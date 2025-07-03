package com.example.mycity.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.mycity.data.CityPlace

@Composable
fun DetailDialog(place: CityPlace, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(place.name) },
        text = {
            Text(place.description)
        },
        confirmButton = {
            Button(onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(place.mapLocation))
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                try {
                    onDismiss()
                    intent.let { startIntent ->
                        LocalContext.current.startActivity(startIntent)
                    }
                } catch (e: Exception) {
                    // handle if Maps app not found
                }
            }) {
                Text("Open in Maps")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Close")
            }
        }
    )
}
