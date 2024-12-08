/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gruppo23.phonebook.model;

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
    private Boolean isFavorite;
    
    //push di aggiornamento
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

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
    
    public void editContact(){
        
    }
}
