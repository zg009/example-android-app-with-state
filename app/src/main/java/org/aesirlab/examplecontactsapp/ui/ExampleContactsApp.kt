package org.aesirlab.examplecontactsapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.aesirlab.examplecontactsapp.logic.ContactsViewModel
import org.aesirlab.examplecontactsapp.ui.screens.AddContactScreen
import org.aesirlab.examplecontactsapp.ui.screens.DetailViewContactScreen
import org.aesirlab.examplecontactsapp.ui.screens.MainScreen

enum class ContactsAppScreen {
    MainScreen,
    AddContactScreen,
    DetailViewContactScreen
}

@Composable
fun ExampleContactsApp(
    contactsViewModel: ContactsViewModel = viewModel()
) {
    val navController = rememberNavController()
    val contactsList by contactsViewModel.allContacts.collectAsState()

    Scaffold {
        NavHost(
            navController = navController,
            startDestination = ContactsAppScreen.MainScreen.name,
            modifier = Modifier.padding(it)
        ) {
            composable(route = ContactsAppScreen.MainScreen.name) {
                MainScreen(contacts = contactsList) {
                    navController.navigate(ContactsAppScreen.AddContactScreen.name)
                }
            }
            composable(route = ContactsAppScreen.AddContactScreen.name) {
                AddContactScreen()
            }
            composable(route = ContactsAppScreen.DetailViewContactScreen.name) {
                DetailViewContactScreen()
            }
        }
    }
}