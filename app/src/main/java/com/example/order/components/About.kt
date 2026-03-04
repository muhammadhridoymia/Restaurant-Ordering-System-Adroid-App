package com.example.order.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun AboutRestaurantScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        // 🔶 Restaurant Image
        AsyncImage(
            model = "https://images.unsplash.com/photo-1504674900247-0877df9cc836",
            contentDescription = "Post Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {

            // 🔶 Restaurant Name
            Text(
                text = "Golden Spoon Restaurant",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 🔶 Rating
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Rating",
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "4.8 (1,245 reviews)")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 🔶 Description
            Text(
                text = "About Us",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Golden Spoon is a premium restaurant offering authentic Asian and Continental cuisine. We focus on fresh ingredients, delicious flavors, and a warm dining experience for families and friends.",
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 🔶 Location
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location",
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = "123 Main Street, Dhaka, Bangladesh")
            }

            Spacer(modifier = Modifier.height(12.dp))

            // 🔶 Opening Hours
            Text(
                text = "Opening Hours",
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = "Mon - Fri: 10:00 AM - 10:00 PM")
            Text(text = "Sat - Sun: 9:00 AM - 11:00 PM")

            Spacer(modifier = Modifier.height(16.dp))

            // 🔶 Contact
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Phone",
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = "+880 1234 567 890")
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}