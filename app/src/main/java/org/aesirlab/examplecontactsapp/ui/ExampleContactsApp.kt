package org.aesirlab.examplecontactsapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class ContactsAppScreen {
    MainScreen,
    AddContactScreen,
    DetailViewContactScreen
}

@Composable
fun ExampleContactsApp() {
    val navController = rememberNavController()

    Scaffold {
        NavHost(
            navController = navController,
            startDestination = ContactsAppScreen.MainScreen.name,
            modifier = Modifier.padding(it)
        ) {
            composable(route = ContactsAppScreen.MainScreen.name) {

            }
            composable(route = ContactsAppScreen.AddContactScreen.name) {

            }
            composable(route = ContactsAppScreen.DetailViewContactScreen.name) {

            }
        }
    }
}