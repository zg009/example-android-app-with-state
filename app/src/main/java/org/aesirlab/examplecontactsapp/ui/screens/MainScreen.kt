package org.aesirlab.examplecontactsapp.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.aesirlab.examplecontactsapp.model.Contact

@Composable
fun MainScreen(
    contacts: List<Contact>,
    onClickNavigate: () -> Unit
) {
//    Text("This is the Main Screen!")
    Column {
        Button(onClick = onClickNavigate) {
            Text("Add Contacts")
        }
        LazyColumn {
            items(contacts) { contact ->
                Spacer(modifier = Modifier.padding(vertical = 6.dp))
                ContactBox(contact = contact)
            }
        }
    }


}

@Composable
fun ContactBox(contact: Contact) {
    Row(modifier = Modifier
        .border(2.dp, Color.Red)) {
        Text(text = contact.firstName,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(4.dp))
        Spacer(modifier = Modifier.padding(
            vertical = 12.dp,
            horizontal = 4.dp)
        )
        Text(text = contact.lastName,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(4.dp))
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    val mockContacts = listOf(Contact("a", "b", "C", "d", 1011))
    Column {
        Button(onClick = { }) {
            Text("Add Contacts")
        }
        LazyColumn {
            items(mockContacts) { contact ->
                Spacer(modifier = Modifier.padding(vertical = 6.dp))
                ContactBox(contact = contact)
            }
        }
    }
}