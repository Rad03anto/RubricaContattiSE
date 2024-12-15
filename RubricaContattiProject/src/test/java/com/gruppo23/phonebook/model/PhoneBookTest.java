/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.gruppo23.phonebook.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
 * @author miche
 */
public class PhoneBookTest {
    
    private PhoneBook phoneBook;
    private ContactBook contactBook;
    private EmergencyList eList;
    private Bin bin;
    
    public PhoneBookTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        contactBook = new ContactBook();
        eList = new EmergencyList();
        bin = new Bin();
        phoneBook = new PhoneBook(contactBook, eList, bin);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test per getContactBook.
     */
    @Test
    public void testGetContactBook() {
        assertNotNull(phoneBook.getContactBook());
        assertEquals(contactBook, phoneBook.getContactBook());
    }

    /**
     * Test per setContactBook
     */
    @Test
    public void testSetContactBook() {
        ContactBook newContactBook = new ContactBook();
        phoneBook.setContactBook(newContactBook);
        assertEquals(newContactBook, phoneBook.getContactBook());
    }

    /**
     * Test per geteList.
     */
    @Test
    public void testGeteList() {
        assertNotNull(phoneBook.geteList());
        assertEquals(eList, phoneBook.geteList());
    }

    /**
     * Test per seteList.
     */
    @Test
    public void testSeteList() {
        EmergencyList newEList = new EmergencyList();
        phoneBook.seteList(newEList);
        assertEquals(newEList, phoneBook.geteList());
    }

    /**
     * Test per getBin.
     */
    @Test
    public void testGetBin() {
        assertNotNull(phoneBook.getBin());
        assertEquals(bin, phoneBook.getBin());
    }

    /**
     * Test per setBin.
     */
    @Test
    public void testSetBin() {
        Bin newBin = new Bin();
        phoneBook.setBin(newBin);
        assertEquals(newBin, phoneBook.getBin());
    }

    /**
     * Test del metodo LoadFromFile
     * per il caricamento da file csv.
     */
    @Test
    public void testLoadFromFile() throws Exception {
        String filename = "testPhoneBook.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Mario;Rossi;12345;67890;54321;mail1@mail.com;mail2@mail.com;mail3@mail.com;Via Roma;Note;image.png;true;CONTACTBOOK\n");
        }
        phoneBook.loadFromFile(filename);
        List<Contact> contacts = phoneBook.getContactBook().getContacts();
        assertFalse(contacts.isEmpty());
        assertEquals("Mario", contacts.get(0).getName());
        assertEquals("Rossi", contacts.get(0).getSurname());

        new File(filename).delete();
    }

    /**
     * Test per il metodo SaveToFile
     * per il salvataggio su file csv.
     */
    @Test
    public void testSaveToFile() throws Exception {
        Contact contact = new Contact("Mario", "Rossi", Arrays.asList("12345", "67890", "54321"),
                Arrays.asList("mail1@mail.com", "mail2@mail.com", "mail3@mail.com"), 
                "Via Roma", "Note", null, true);
        phoneBook.getContactBook().addContact(contact);
        String filename = "testSavePhoneBook.csv";
        phoneBook.saveToFile(filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            assertTrue(line.contains("Mario"));
            assertTrue(line.contains("Rossi"));
        }
        new File(filename).delete();
    }
    
}
