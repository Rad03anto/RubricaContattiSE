/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gruppo23.phonebook.model;

import com.gruppo23.phonebook.exceptions.FullGroupException;
import java.io.Serializable;

/**
 * @file EmergencyList.java
 * @brief Classe che rappresenta una lista di contatti di emergenza.
 * 
 * Questa classe estende la classe ContactList e aggiunge delle funzionalità specifiche
 * per gestire un gruppo di contatti di emergenza, imponendo un limite massimo di 15 contatti.
 * 
 * @note Invariante: La dimensione della lista non deve mai superare MAX_SIZE.
 */
public class EmergencyList extends ContactList implements Serializable{
    
    private static final int MAX_SIZE = 15; ///< Dimensione massima della lista di contatti di emergenza.
    
    /**
     * @throws com.gruppo23.phonebook.exceptions.FullGroupException
     * @brief Aggiunge un contatto alla lista di emergenza.
     * 
     * Sovrascrive il metodo addContact della classe base ContactList.
     * Controlla che la lista non abbia già raggiunto il limite massimo di contatti 
     * prima di aggiungere un nuovo contatto.
     * 
     * @pre La lista di contatti deve contenere meno di MAX_SIZE contatti.
     * @param contact Oggetto di tipo Contact da aggiungere alla lista.
     * @post Se la lista contiene meno di MAX_SIZE contatti, il nuovo contatto viene aggiunto con successo.
     *       Altrimenti, la lista rimane invariata.
     */
    @Override
    public void addContact(Contact contact) throws FullGroupException {
        if(contactList.size()>=MAX_SIZE) {
            throw new FullGroupException("Gruppo Emergenza Pieno");
        }
        super.addContact(contact);
    }
    
}

