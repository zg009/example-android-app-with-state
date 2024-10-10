package org.aesirlab.examplecontactsapp.model

data class Contact(
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val addedDate: Long
)