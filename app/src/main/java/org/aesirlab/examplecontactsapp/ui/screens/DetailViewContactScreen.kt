package org.aesirlab.examplecontactsapp.ui.screens

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.aesirlab.examplecontactsapp.model.Contact
import java.util.Date

@Composable
fun DetailViewContactScreen(contact: Contact) {
//    Text(text = "This is the detail view screen!")
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Spacer(modifier = Modifier.padding(vertical = 3.dp))
        Text(text = contact.firstName)
        Spacer(modifier = Modifier.padding(vertical = 3.dp))
        Text(text = contact.lastName)
        Spacer(modifier = Modifier.padding(vertical = 3.dp))
        Text(text = contact.email)
        Spacer(modifier = Modifier.padding(vertical = 3.dp))
        Text(text = contact.phoneNumber)
        Spacer(modifier = Modifier.padding(vertical = 3.dp))
        Text(text = SimpleDateFormat("yyyy.MM.dd HH:mm").format(Date(contact.addedDate)))
    }
}

@Preview
@Composable
fun PreviewDetailContactScreen() {

}