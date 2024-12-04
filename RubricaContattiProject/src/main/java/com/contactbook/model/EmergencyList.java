/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contactbook.model;

/**
 *
 * @author miche
 */
public class EmergencyList extends ContactList {
    
    private static final int MAX_SIZE = 15;
    @Override
    public void addContact(Contact contact) {
        if(contactList.size()!=15){
            contactList.add(contact);
        }
        else System.out.println("Il Gruppo di Emergenza può contenere al massimo 15 contatti");
    }
}
