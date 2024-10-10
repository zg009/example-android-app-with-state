package org.aesirlab.examplecontactsapp.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen(
    onClickNavigate: () -> Unit
) {
    Text("This is the Main Screen!")
    Button(onClick = onClickNavigate) {
        Text("Add Contacts")
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    Text("This is the main screen!")
}