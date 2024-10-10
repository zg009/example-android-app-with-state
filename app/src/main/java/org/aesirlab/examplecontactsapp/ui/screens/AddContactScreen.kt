package org.aesirlab.examplecontactsapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import org.aesirlab.examplecontactsapp.model.Contact

@Composable
fun AddContactScreen(
    addContactClick: (Contact) -> Unit
) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    Column {
        TextField(value = firstName, onValueChange = { firstName = it } )
        TextField(value = lastName, onValueChange = { lastName = it } )
        TextField(value = email, onValueChange = { email = it } )
        TextField(value = phoneNumber, onValueChange = { phoneNumber = it } )
        Button(onClick = {
            val newContact = Contact(
                firstName,
                lastName,
                email,
                phoneNumber,
                System.currentTimeMillis()
            )
            addContactClick(newContact)
        }) {
            Text("Add your new contact!")
        }
    }
}

@Preview
@Composable
fun PreviewAddContactScreen() {
    Text("this is the preview screen!")
}