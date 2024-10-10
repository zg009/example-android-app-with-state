package org.aesirlab.examplecontactsapp.logic

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

    private val _currentContact = MutableStateFlow<Contact?>(null)
    val currentContact = _currentContact.asStateFlow()

    fun setCurrentContact(contact: Contact) {
        _currentContact.value = contact
    }

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

    init {
        val alex = Contact(
            "Alex",
            "Nelson",
            "an01@aesir.org",
            "1110002345",
            System.currentTimeMillis()
        )
        val zach = Contact(
            "Zach",
            "Grider",
            "zg01@aesir.org",
            "0003335521",
            System.currentTimeMillis()
        )
        _allContacts.value = listOf(zach, alex)
    }
}