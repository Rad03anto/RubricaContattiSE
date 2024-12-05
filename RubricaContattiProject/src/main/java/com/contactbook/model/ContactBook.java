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
  
    }
    
    @Override
    public void removeContact(Contact contact){
        
    }
    
    public static int getGlobalContactCount() {
    
        return globalContactCount;
    }
    
}
