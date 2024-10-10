package org.aesirlab.examplecontactsapp.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.aesirlab.examplecontactsapp.model.Contact

@Composable
fun DetailViewContactScreen(contact: Contact) {
    Text(text = "This is the detail view screen!")
}

@Preview
@Composable
fun PreviewDetailContactScreen() {

}