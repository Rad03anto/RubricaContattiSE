/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contactbook.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @authors Antonio Radesca, Luca Nazzaro, Alessandro Scandone, Michele Savino
 */
public class PhoneBook implements Serializable { 
    
    private ContactBook contactBook;
    private EmergencyList eList;
    private Bin bin;
    private List<Group> groups;

    public PhoneBook(ContactBook contactBook, EmergencyList eList, Bin bin, List<Group> groups) {
        this.contactBook = contactBook;
        this.eList = eList;
        this.bin = bin;
        this.groups = groups;
    }
   
    
    public static PhoneBook loadFromFile(String filename) {
       
    return null;
    }
    
    public void saveToFile(String filename) {
        
    }
    
    
}
