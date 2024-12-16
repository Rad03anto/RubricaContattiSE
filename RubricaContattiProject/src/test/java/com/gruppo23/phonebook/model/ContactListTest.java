/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author anton
 */
public class ContactListTest {
    
    public ContactListTest() {
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
     * Test of addContact method, of class ContactList.
     */
    @Test
    public void testAddContact() throws Exception {
        System.out.println("addContact");
        Contact contact = null;
        ContactList instance = new ContactListImpl();
        instance.addContact(contact);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeContact method, of class ContactList.
     */
    @Test
    public void testRemoveContact() {
        System.out.println("removeContact");
        Contact contact = null;
        ContactList instance = new ContactListImpl();
        instance.removeContact(contact);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class ContactList.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String searchString = "";
        ContactList instance = new ContactListImpl();
        List<Contact> expResult = null;
        List<Contact> result = instance.search(searchString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContacts method, of class ContactList.
     */
    @Test
    public void testGetContacts() {
        System.out.println("getContacts");
        ContactList instance = new ContactListImpl();
        List<Contact> expResult = null;
        List<Contact> result = instance.getContacts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ContactListImpl extends ContactList {
    }
    
}
