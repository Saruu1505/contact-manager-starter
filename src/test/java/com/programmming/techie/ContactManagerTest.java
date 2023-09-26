package com.programmming.techie;

import com.programming.techie.ContactManager;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactManagerTest {

    ContactManager contactManager;

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

    @BeforeAll
    public void setUpAll(){
        System.out.println("Should print out before all test");
    }

    @BeforeEach
    public void setUp(){
       contactManager = new ContactManager();
    }
    @Test
    @DisplayName("Should Not Create Contact When Last Name is Null")
    public void shouldThrowRunTimeExceptionWhenFirstNameIsNull(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact(null, "Doe", "0123456789");
        });
    } @Test
    @DisplayName("Should Not Create Contact When Last Name is Null")
    public void shouldThrowRunTimeExceptionWhenLastNameIsNull(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("Joe", null, "0123456789");
        });
    } @Test
    @DisplayName("Should Not Create Contact When Last Name is Null")
    public void shouldThrowRunTimeExceptionWhenPhoneNumberIsNull(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("null", "Doe", null);
        });
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Should execute After Each Test");
    }

    @AfterAll
    public void tearDownAll() {
        System.out.println("Should execute at the end of the test");
    }
}