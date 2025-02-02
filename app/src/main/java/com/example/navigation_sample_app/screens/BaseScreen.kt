package com.example.navigation_sample_app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun BaseScreen(
    title: String,
    onClose: () -> Unit,
    onNext: (() -> Unit)? = null,
    onBack: (() -> Unit)? = null,
    content: @Composable (() -> Unit) = {}
) {
    Column(modifier = Modifier.padding(vertical = 24.dp, horizontal = 12.dp)) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = onClose) {
                    Icon(imageVector = Icons.Outlined.Close, "")
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(title, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.weight(2f))
            }
            Spacer(modifier = Modifier.weight(1f))
            content()
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                onBack?.let {
                    Spacer(modifier = Modifier.weight(1f))
                    Button(onClick = it) {
                        Text("Back")
                    }
                } ?: Spacer(modifier = Modifier.weight(1f))
                onNext?.let {
                    Spacer(modifier = Modifier.weight(1f))
                    Button(onClick = it) {
                        Text("Next")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                } ?: Spacer(modifier = Modifier.weight(1f))


            }
        }
    }

}

@Preview
@Composable
fun Preview() {
    BaseScreen(
        title = "Base screen",
        onClose = {},
        onNext = {},
        onBack = {}
    )
}