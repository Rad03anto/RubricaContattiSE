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
import java.util.Scanner;
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
     * Test per getContactBook della classe PhoneBook
     */
    @Test
    public void testGetContactBook() {
        assertNotNull(phoneBook.getContactBook());
        assertEquals(contactBook, phoneBook.getContactBook());
    }

    /**
     * Test per setContactBook della classe PhoneBook
     */
    @Test
    public void testSetContactBook() {
        ContactBook newContactBook = new ContactBook();
        phoneBook.setContactBook(newContactBook);
        assertEquals(newContactBook, phoneBook.getContactBook());
    }

    /**
     * Test per geteList della classe PhoneBook
     */
    @Test
    public void testGeteList() {
        assertNotNull(phoneBook.geteList());
        assertEquals(eList, phoneBook.geteList());
    }

    /**
     * Test per seteList della classe PhoneBook
     */
    @Test
    public void testSeteList() {
        EmergencyList newEList = new EmergencyList();
        phoneBook.seteList(newEList);
        assertEquals(newEList, phoneBook.geteList());
    }

    /**
     * Test per getBin della classe PhoneBook
     */
    @Test
    public void testGetBin() {
        assertNotNull(phoneBook.getBin());
        assertEquals(bin, phoneBook.getBin());
    }

    /**
     * Test per setBin della classe PhoneBook
     */
    @Test
    public void testSetBin() {
        Bin newBin = new Bin();
        phoneBook.setBin(newBin);
        assertEquals(newBin, phoneBook.getBin());
    }

    /**
     * Test del metodo LoadFromFile della classe PhoneBook
     * per il caricamento da file csv.
     */
    @Test
    public void testLoadFromFile() throws Exception {
        String filename = "Contatti.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        writer.write("Name;Surname;number1;number2;number3;email1;email2;email3;address;notes;image;isFavorite;Type\n");
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
     * Test per il metodo SaveToFile della classe PhoneBook
     * per il salvataggio su file csv.
     */
    @Test
    public void testSaveToFile() throws Exception {
        Contact contact = new Contact("Mario", "Rossi", Arrays.asList("12345", "67890", "54321"),
                Arrays.asList("mail1@mail.com", "mail2@mail.com", "mail3@mail.com"), 
                "Via Roma", "Note", null, true);
        phoneBook.getContactBook().addContact(contact);
        String filename = "Contatti.csv";
        phoneBook.saveToFile(filename);
        try (Scanner s = new Scanner(new BufferedReader(new FileReader(filename)))) {
        
        if (s.hasNextLine()) {
            s.nextLine();
        }
        
        String line = s.nextLine().trim();  
        
        System.out.println("First contact in the file: " + line);
        assertTrue(line.contains("Mario"));
        assertTrue(line.contains("Rossi"));
    }
        
    new File(filename).delete();
    }
    
    }
