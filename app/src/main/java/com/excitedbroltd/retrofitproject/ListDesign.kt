package com.excitedbroltd.retrofitproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.excitedbroltd.retrofitproject.modelclass.Posts

@Composable
fun ListDesign(posts: Posts) {
    Box() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .background(Color.LightGray)
                .padding(12.dp),
        ) {
            Column() {
                Text(text = "${posts.userId}")
                Text(text = "${posts.id}")
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column() {
                Text(text = "${posts.title}")
                Text(text = "${posts.body}", maxLines = 4)
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun showItemView() {
    ListDesign(posts = Posts(1, 2, "This is show time", "This is my time for show you who I am"))
}