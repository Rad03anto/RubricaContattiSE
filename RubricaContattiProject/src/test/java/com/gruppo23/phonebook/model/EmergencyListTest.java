/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.gruppo23.phonebook.model;

import com.gruppo23.phonebook.exceptions.FullGroupException;
import com.gruppo23.phonebook.exceptions.InvalidContactException;
import java.util.Arrays;
import java.util.List;
import javafx.scene.image.Image;
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
public class EmergencyListTest {
    
    private EmergencyList eList;
    
    public EmergencyListTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        eList = new EmergencyList();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test per il metodo AddContact della classe EmergencyList
     * per l'aggiunta di un contatto ai contatti di emergenza.
     * @throws InvalidContactException
     * @throws FullGroupException
     */
    @Test
    public void testAddContact() throws InvalidContactException, FullGroupException {
        List<String> phoneNumbers = Arrays.asList("1234567890", "0987654321", "8908394302");
        List<String> emails = Arrays.asList("email@esempio.com", "email@esempio2.com", "email@esempio3.com");
        Image image = null;
        Contact contact = new Contact("Nome", "Cognome", phoneNumbers, emails, "1234 Indirizzo", "Note", image, true);

       eList.addContact(contact);      
       assertTrue(eList.getContacts().contains(contact),"Il contatto dovrebbe essere presente nei Contatti di Emergenza dopo essere stato aggiunto");
    }
    
    /**
     * Test per il metodo AddContactMaxSize della classe EmergencyList
     * Per verificare che venga lanciata un'eccezione quando provo a inserire il contatto numero 16 nel gruppo di emergenza
     * @throws InvalidContactException
     * @throws FullGroupException 
     */
    @Test
    public void testAddContactMaxSize() throws InvalidContactException, FullGroupException {
        List<String> phoneNumbers = Arrays.asList("1234567890", "0987654321", "8908394302");
        List<String> emails = Arrays.asList("email@esempio.com", "email@esempio2.com", "email@esempio3.com");
        Image image = null;
        for (int i = 0; i < 15; i++) {
            Contact contact = new Contact("Nome", "Cognome", phoneNumbers, emails, "1234 Indirizzo", "Note", image, true);
            eList.addContact(contact);
        }
        Contact extraContact = new Contact("NomeExtra", "CognomeExtra", phoneNumbers, emails, "1234 Indirizzo", "Note", image, true);
        try {
            eList.addContact(extraContact);
            fail("Dovrebbe essere lanciata l'eccezione");
        } catch (FullGroupException e) {
            assertEquals("Gruppo Emergenza Pieno", e.getMessage());
        }
        }
    
}
