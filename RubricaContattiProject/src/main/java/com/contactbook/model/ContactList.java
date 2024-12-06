/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contactbook.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author miche
 */
public abstract class ContactList implements Serializable{
    
    protected List<Contact> contactList = new ArrayList<>();
    
    
    public void addContact(Contact contact){
        contactList.add(contact);
    }
    
    public void removeContact(Contact contact){
        contactList.remove(contact);
    }
    
    public void search(){    
    }

    public List<Contact> getContacts() {
        return contactList;
    }
  
}
