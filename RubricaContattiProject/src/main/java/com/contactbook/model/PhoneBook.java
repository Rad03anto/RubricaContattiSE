/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contactbook.model;

/**
 *
 * @author miche
 */
public class PhoneBook {
    
    private ContactBook contactBook;
    private FavList fList;
    private EmergencyList eList;
    private BlockedList bList;
    private Bin bin;

    public PhoneBook(ContactBook contactBook, FavList fList, EmergencyList eList, BlockedList bList, Bin bin) {
        this.contactBook = contactBook;
        this.fList = fList;
        this.eList = eList;
        this.bList = bList;
        this.bin = bin;
    }
    
   
    
    
}
