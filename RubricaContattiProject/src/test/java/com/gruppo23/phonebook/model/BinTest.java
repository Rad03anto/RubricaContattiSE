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
 * @author miche
 */
public class BinTest {
    
    private Contact contact;
    private Bin bin;
    private ContactBook contactBook;
    
    public BinTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws InvalidContactException, FullGroupException {
        
     List<String> phoneNumbers = Arrays.asList("1234567890", "0987654321", "8908394302");
     List<String> emails = Arrays.asList("email@esempio.com", "email@esempio2.com", "email@esempio3.com");
     Image image = null;
     Contact contact = new Contact("Nome", "Cognome", phoneNumbers, emails, "1234 Indirizzo", "Note", image, true);   
     bin.addContact(contact);
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test del metodo restoreContact.
     * Verifica che il contatto venga rimosso e aggiunto alla rubrica.
     * @throws Exception 
     */
    @Test
    public void testRestoreContact() throws Exception {
       
    }

    /**
     * Test of deleteContactPermanently method, of class Bin.
     */
   
    
}
