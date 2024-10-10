package org.aesirlab.examplecontactsapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
    val coroutineScope = rememberCoroutineScope()
    val currentContact by contactsViewModel.currentContact.collectAsState()

    Scaffold {
        NavHost(
            navController = navController,
            startDestination = ContactsAppScreen.MainScreen.name,
            modifier = Modifier.padding(it)
        ) {
            composable(route = ContactsAppScreen.MainScreen.name) {
                MainScreen(
                    contacts = contactsList,
                    onDetailClicked = { contact ->
                        contactsViewModel.setCurrentContact(contact)
                        navController.navigate(
                            ContactsAppScreen.DetailViewContactScreen.name
                        )
                    },
                    onClickAddScreen = {
                        navController.navigate(ContactsAppScreen.AddContactScreen.name)
                    })
            }
            composable(route = ContactsAppScreen.AddContactScreen.name) {
                AddContactScreen { contact ->
                    coroutineScope.launch {
                        withContext(Dispatchers.IO) {
                            contactsViewModel.insert(contact)
                        }
                    }
                    navController.navigate(ContactsAppScreen.MainScreen.name)
                }
            }
            composable(route = ContactsAppScreen.DetailViewContactScreen.name) {
                DetailViewContactScreen(currentContact!!)
            }
        }
    }
}