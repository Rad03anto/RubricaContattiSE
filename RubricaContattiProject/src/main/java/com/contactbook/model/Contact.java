/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contactbook.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @authors Antonio Radesca, Luca Nazzaro, Alessandro Scandone, Michele Savino
 */
public class Contact {
    
    private String name;
    private String surname;
    private List<String> phoneNumbers;
    private List<String> emails;
    private String address;
    private String notes;

    public Contact(String name, String surname, List phoneNumbers, List emails, String address, String notes) {
        this.name = name;
        this.surname = surname;
        this.phoneNumbers = new ArrayList<>();
        this.emails = new ArrayList<>();
        this.address = address;
        this.notes = notes;
    }
    
    
}
