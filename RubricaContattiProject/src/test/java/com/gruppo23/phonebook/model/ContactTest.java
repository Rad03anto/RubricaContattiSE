/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.gruppo23.phonebook.model;

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
 * @author miche
 */
public class ContactTest {
    
    private Contact contact;
    
    @BeforeEach
    public void setUp() throws InvalidContactException { 
        List<String> phoneNumbers = Arrays.asList("1234567890", "0987654321", "8908394302");
        List<String> emails = Arrays.asList("email@esempio.com", "email@esempio2.com", "email@esempio3.com");
        Image image = null;
        contact = new Contact("Nome", "Cognome", phoneNumbers, emails, "1234 Indirizzo", "Note", image, true);
    }
    
    /**
     * Test of getName method, of class Contact.
     */
    @Test
    public void testGetName() {
        assertEquals("Nome", contact.getName(), "Il nome del contatto non corrisponde");    
    }

    /**
     * Test of getSurname method, of class Contact.
     */
    @Test
    public void testGetSurname() {
        assertEquals("Cognome", contact.getSurname(), "Il cognome del contatto non corrisponde");
    }

    /**
     * Test of getPhoneNumbers method, of class Contact.
     */
    @Test
    public void testGetPhoneNumbers() {
        List<String> expectedNumbers = Arrays.asList("1234567890", "0987654321", "8908394302");
        assertEquals(expectedNumbers, contact.getPhoneNumbers(), "I numeri di telefono non corrispondono");
    }

    /**
     * Test of getEmails method, of class Contact.
     */
    @Test
    public void testGetEmails() {
        List<String> expectedEmails = Arrays.asList("email@esempio.com", "email@esempio2.com", "email@esempio3.com");
        assertEquals(expectedEmails, contact.getEmails(), "Le email non corrispondono");
    }

    /**
     * Test of getAddress method, of class Contact.
     */
    @Test
    public void testGetAddress() {
       assertEquals("1234 Indirizzo", contact.getAddress(), "L'indirizzo non corrisponde");
    }

    /**
     * Test of getNotes method, of class Contact.
     */
    @Test
    public void testGetNotes() {
        assertEquals("Note", contact.getNotes(), "Le note non corrispondono");
    }

    /**
     * Test of getImage method, of class Contact.
     */
   /* @org.junit.jupiter.api.Test
    public void testGetImage() {
    assertNotNull(contact.getImage(), "L'immagine non dovrebbe essere null");
    
    Image expectedImage = new Image(getClass().getResource("/images/testimmagine.png").toExternalForm());
    assertNotNull(expectedImage, "L'immagine attesa non è stata caricata correttamente");
    
    assertNotSame(expectedImage, contact.getImage(), "L'immagine recuperata dovrebbe essere diversa dall'immagine attesa se caricata separatamente.");
}*/

    /**
     * Test of setName method, of class Contact.
     */
    @Test
    public void testSetName() {
        contact.setName("Nuovo Nome");
        assertEquals("Nuovo Nome", contact.getName(), "Il nome non è stato aggiornato correttamente");
    }

    /**
     * Test of setSurname method, of class Contact.
     */
    @Test
    public void testSetSurname() {
        contact.setSurname("Nuovo Cognome");
        assertEquals("Nuovo Cognome", contact.getSurname(), "Il cognome non è stato aggiornato correttamente");
    }

    /**
     * Test of setPhoneNumbers method, of class Contact.
     */
    @Test
    public void testSetPhoneNumbers() {
        List<String> newPhoneNumbers = Arrays.asList("1111111111", "2222222222");
        contact.setPhoneNumbers(newPhoneNumbers);
        assertEquals(newPhoneNumbers, contact.getPhoneNumbers(), "I numeri di telefono non sono stati aggiornati correttamente");
    }

    /**
     * Test of setEmails method, of class Contact.
     */
    @Test
    public void testSetEmails() {
        List<String> newEmails = Arrays.asList("nuovaemail@esempio.com");
        contact.setEmails(newEmails);
        assertEquals(newEmails, contact.getEmails(), "Le email non sono state aggiornate correttamente");
    }

    /**
     * Test of setAddress method, of class Contact.
     */
    @Test
    public void testSetAddress() {
        contact.setAddress("Nuovo Indirizzo");
        assertEquals("Nuovo Indirizzo", contact.getAddress(), "L'indirizzo non è stato aggiornato correttamente");
    }

    /**
     * Test of setNotes method, of class Contact.
     */
    @Test
    public void testSetNotes() {
        contact.setNotes("Nuove Note");
        assertEquals("Nuove Note", contact.getNotes(), "Le note non sono state aggiornate correttamente");
    }

    /**
     * Test of setImage method, of class Contact.
     */
   /* @org.junit.jupiter.api.Test
    public void testSetImage() {
        Image newImage = new Image(getClass().getResource("/images/newtest.png").toExternalForm());
        contact.setImage(newImage);
        assertSame(newImage, contact.getImage(), "L'immagine non è stata aggiornata correttamente");
    } */

    /**
     * Test of getIsFavorite method, of class Contact.
     */
    @Test
    public void testGetIsFavorite() {
        assertTrue(contact.getIsFavorite(), "Il contatto dovrebbe essere tra i preferiti");
    }

    /**
     * Test of setIsFavorite method, of class Contact.
     */
    @Test
    public void testSetIsFavorite() {
        contact.setIsFavorite(false);
        assertFalse(contact.getIsFavorite(), "Il contatto non dovrebbe essere tra i preferiti");
    }

    /**
     * Test of compareTo method, of class Contact.
     */
    @Test
    public void testCompareTo() throws InvalidContactException {
        Contact anotherContact = new Contact("Nome", "Cognome", Arrays.asList("1234567890", "0987654321", "8908394302"), Arrays.asList("email@esempio.com", "email@esempio2.com", "email@esempio3.com"),
                "1234 Indirizzo", "Note", null, true);
        assertEquals(0, contact.compareTo(anotherContact), "I contatti non risultano uguali");
    }
    
}
