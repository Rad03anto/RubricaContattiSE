/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contactbook.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

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
    private ImageIcon image;
    private boolean isFavourite; 

    public Contact(String name, String surname) {
        
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public List<String> getEmails() {
        return emails;
    }

    public String getAddress() {
        return address;
    }

    public String getNotes() {
        return notes;
    }

    public ImageIcon getImage() {
        return image;
    }

    public boolean isIsFavourite() {
        return isFavourite;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public void setIsFavourite(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }
    
}
