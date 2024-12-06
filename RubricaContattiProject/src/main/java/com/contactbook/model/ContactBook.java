/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contactbook.model;

import java.io.Serializable;

/**
 *
 * @author miche
 */
public class ContactBook extends ContactList implements Serializable {
    
    private static final int MAX_CONTACTS = 1000;
    private static int globalContactCount = 0;
    
    @Override 
    public void addContact(Contact contact) {
        if (globalContactCount >= MAX_CONTACTS) {
            throw new IllegalStateException("La rubrica ha raggiunto il numero massimo di contatti!");
        }
        super.addContact(contact);
        globalContactCount++;
    }
    
    @Override
    public void removeContact(Contact contact){
        super.removeContact(contact);
        globalContactCount--;
    }
    
    public void moveToBin(Contact contact, Bin bin){
          if (contactList.contains(contact)) {
            removeContact(contact);
            bin.addContact(contact);
        } 
    }
    
    public void moveToEmergencyList(Contact contact, EmergencyList eList){
        eList.addContact(contact);
    }
    
    public static int getGlobalContactCount() {
    
        return globalContactCount;
    }
    
}
