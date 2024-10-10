package org.aesirlab.examplecontactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.aesirlab.examplecontactsapp.ui.ExampleContactsApp
import org.aesirlab.examplecontactsapp.ui.theme.ExampleContactsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExampleContactsAppTheme {
                ExampleContactsApp()
            }
        }
    }
}
