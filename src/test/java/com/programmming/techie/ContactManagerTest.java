package com.programmming.techie;

import com.programming.techie.ContactManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

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

    //bruker annotasjon repeated test
    //value --> kjøres testen x antall ganger
    @DisplayName("Repeat Contact Creation Test 5 Times")
    @RepeatedTest(value = 5,
            name = "Repeating Contact Creation Test {currentRepetition} of {totalRepetitions}" )
    public void shouldTestContactCreationRepeatedly(){
        contactManager.addContact("John", "Doe", "0123456789");
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    //bruker parametrisert tester
    //skal validere telefonnummer
    //sjekk ut validatePhoneNumber metoden i Contact-class
    //bruker @ValueSource i første eksempel
    @DisplayName("Testing Contant Creation Using ValueSource")
    @ParameterizedTest
    @ValueSource(strings = {"0789456123", "0147852369", "0123456789"})
    public void shouldTestContactCreationUsingValueSource(String phoneNumber){
        contactManager.addContact("John", "Doe", phoneNumber);
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());

        //bruker methodSource under
        //samme eksempel over bare vi bruker methodsource her
    } @DisplayName("Method Source Case - Phone Number should match the required Format")
    @ParameterizedTest
    @MethodSource("phoneNumberList")
    public void shouldTestPhoneNumberFormatUsingMethodSource(String phoneNumber){
        contactManager.addContact("John", "Doe", phoneNumber);
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    private static List<String> phoneNumberList(){
        return Arrays.asList("0789456123", "0147852369", "0123456789");
    }

    //CSV Source Fil --> Komma separerte filer
    @DisplayName("CSV Source Case - Phone Number should match the required Format")
    @ParameterizedTest
    @CsvSource({"0789456123", "0147852369", "0123456789"})
    public void shouldTestPhoneNumberFormatUsingCSVSource(String phoneNumber){
        contactManager.addContact("John", "Doe", phoneNumber);
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }






}