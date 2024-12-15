/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.gruppo23.phonebook.model;

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
public class ContactBookTest {
    
    public ContactBookTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addContact method, of class ContactBook.
     */
    @Test
    public void testAddContact() throws Exception {
        System.out.println("addContact");
        Contact contact = null;
        ContactBook instance = new ContactBook();
        instance.addContact(contact);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeContact method, of class ContactBook.
     */
    @Test
    public void testRemoveContact() {
        System.out.println("removeContact");
        Contact contact = null;
        ContactBook instance = new ContactBook();
        instance.removeContact(contact);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveToBin method, of class ContactBook.
     */
    @Test
    public void testMoveToBin() throws Exception {
        System.out.println("moveToBin");
        Contact contact = null;
        Bin bin = null;
        ContactBook instance = new ContactBook();
        instance.moveToBin(contact, bin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveToEmergencyList method, of class ContactBook.
     */
    @Test
    public void testMoveToEmergencyList() throws Exception {
        System.out.println("moveToEmergencyList");
        Contact contact = null;
        EmergencyList eList = null;
        ContactBook instance = new ContactBook();
        instance.moveToEmergencyList(contact, eList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGlobalContactCount method, of class ContactBook.
     */
    @Test
    public void testGetGlobalContactCount() {
        System.out.println("getGlobalContactCount");
        int expResult = 0;
        int result = ContactBook.getGlobalContactCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayFavorites method, of class ContactBook.
     */
    @Test
    public void testDisplayFavorites() {
        System.out.println("displayFavorites");
        ContactBook instance = new ContactBook();
        List<Contact> expResult = null;
        List<Contact> result = instance.displayFavorites();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
