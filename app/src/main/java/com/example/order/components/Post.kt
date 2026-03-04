package com.example.order.components

import PostViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import res


@Composable
fun PostScreen() {

    val postviewmodel: PostViewModel = viewModel()
    val posts = postviewmodel.Postdata.value
    val loading = postviewmodel.loading.value

    LaunchedEffect(Unit) {
        postviewmodel.fetchPosts()
    }

    if (loading) {
        CircularProgressIndicator()
    } else {
        Column {
            posts.forEach { post ->
                PostCard(post)
            }
        }
    }
    }


@Composable
fun PostCard(post: res) {

    var likeCount by remember { mutableStateOf(post.likes) }

    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {

        Column {

            AsyncImage(
                model = post.image,
                contentDescription = "Post Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            )

            Column(modifier = Modifier.padding(16.dp)) {

                Text(
                    text = post.message,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = { likeCount++ }) {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "Like",
                                tint = Color.Red
                            )
                        }
                        Text(text = likeCount.toString())
                    }

                    IconButton(onClick = { /* Share */ }) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share"
                        )
                    }
                }
            }
        }
    }
}