package org.aesirlab.examplecontactsapp.logic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.aesirlab.examplecontactsapp.model.Contact

class ContactsViewModel: ViewModel() {

    private val _allContacts = MutableStateFlow<List<Contact>>(
        listOf()
    )
    val allContacts: StateFlow<List<Contact>> = _allContacts.asStateFlow()

    suspend fun insert(contact: Contact) {
        coroutineScope {
            _allContacts.value = allContacts.value.plus(contact)
        }
    }

    suspend fun delete(contact: Contact) {
        coroutineScope {
            _allContacts.value = allContacts.value.minus(contact)
        }
    }
}