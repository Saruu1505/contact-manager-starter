package com.programmming.techie;

import com.programming.techie.ContactManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactManagerTest {

    //teste om en kontakt har blitt opprettet riktig
    @Test
    public void shouldCreateContact() {
        ContactManager contactManager = new ContactManager();
        contactManager.addContact("Jon", "Doe", "0123456789");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1,contactManager.getAllContacts().size());
    }


    //under tester jeg ved bruk av exception
    //i ContactManager klassen er det en funksjon som heter validateContact validerer
    // som kontakten.
    //lager en test som validerer feil verdier
    //assertThrows --> bruker exception klassen 
    @Test
    @DisplayName("Should Not Create Contact When Last Name is Null")
    public void shouldThrowRunTimeExceptionWhenFirstNameIsNull(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact(null, "Doe", "0123456789");
        });
    } @Test
    @DisplayName("Should Not Create Contact When Last Name is Null")
    public void shouldThrowRunTimeExceptionWhenLastNameIsNull(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("Joe", null, "0123456789");
        });
    } @Test
    @DisplayName("Should Not Create Contact When Last Name is Null")
    public void shouldThrowRunTimeExceptionWhenPhoneNumberIsNull(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("null", "Doe", null);
        });
    }
}