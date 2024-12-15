/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.gruppo23.phonebook.model;

import com.gruppo23.phonebook.exceptions.FullGroupException;
import com.gruppo23.phonebook.exceptions.InvalidContactException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gruppo23
 */
public class ContactBookTest {
    
    private ContactBook contactBook;
    private Contact contact;
    private Contact favoriteContact;
    private Bin bin;
    private EmergencyList emergencyList;
    
    public ContactBookTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws InvalidContactException, FullGroupException {
        
        contactBook = new ContactBook();
        bin = new Bin();
        emergencyList = new EmergencyList();
        
        List<String> phoneNumbers = Arrays.asList("1234567890", "0987654321", "8908394302");
        List<String> emails = Arrays.asList("email@esempio.com", "email@esempio2.com", "email@esempio3.com");
        
        contact = new Contact("Nome", "Cognome", phoneNumbers, emails, "1234 Indirizzo", "Note", null, true);
        favoriteContact = new Contact("Nome2", "Cognome2", phoneNumbers, emails, "1234 Indirizzo2", "Note", null, true);
        
        contactBook.addContact(contact);
        contactBook.addContact(favoriteContact);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test per addContact della classe ContactBook
     * Aggiunge un contatto alla contactbook, cioè alla rubrica principale.
     */
    @Test
    public void testAddContact() throws Exception {
        assertTrue(contactBook.getContacts().contains(contact), "Il contatto dovrebbe essere presente nella rubrica principale.");
    }

    /**
     * Test di removeContact della classe ContactBook
     * Verifica che il contatto sia rimosso dalla rubrica principale
     */
    @Test
    public void testRemoveContact() {
        contactBook.removeContact(contact);
        assertFalse(contactBook.getContacts().contains(contact), "Il contatto dovrebbe essere stato rimosso dalla rubrica principale.");
        
    }

    /**
     * Test di moveToBin della classe ContactBook
     * verifica che il contatto venga aggiunto al cestino
     */
    @Test
    public void testMoveToBin() throws Exception {
       
        assertTrue(contactBook.getContacts().contains(contact), "Il contatto dovrebbe essere nella rubrica.");
        contactBook.moveToBin(contact, bin);
        assertFalse(contactBook.getContacts().contains(contact), "Il contatto dovrebbe essere stato rimosso dalla rubrica.");
        assertTrue(bin.getContacts().contains(contact), "Il contatto dovrebbe essere stato aggiunto al cestino.");
    }

    /**
     * Test di moveToEmergencyList della classe ContactBook
     * verifica che un contatto venga aggiunto ai contatti di emergenza e che non venga eliminato dalla rubrica
     */
    @Test
    public void testMoveToEmergencyList() throws Exception {
        
        contactBook.moveToEmergencyList(contact, emergencyList);
        assertTrue(emergencyList.getContacts().contains(contact), "Il contatto dovrebbe essere stato aggiunto ai contatti di emergenza.");
        assertTrue(contactBook.getContacts().contains(contact), "Il contatto dovrebbe essere ancora nella rubrica.");
    }

    /**
     * Test di displayFavorites della classe ContactBook.
     * verifica che il contatto preferito sia aggiunto nel display
     */
    @Test
    public void testDisplayFavorites() throws InvalidContactException, FullGroupException {
        List<Contact> favorites = contactBook.displayFavorites();
        assertTrue(favorites.contains(favoriteContact), "La lista dei preferiti dovrebbe contenere il contatto preferito.");
    }

    
}
