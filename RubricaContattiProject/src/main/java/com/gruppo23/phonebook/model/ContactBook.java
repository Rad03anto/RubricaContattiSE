/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gruppo23.phonebook.model;

import com.gruppo23.phonebook.exceptions.InvalidContactException;
import com.gruppo23.phonebook.exceptions.FullGroupException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @package com.gruppo23.phonebook.model
 * @class ContactBook
 * 
 * @brief Gestisce la rubrica principale con funzionalità di aggiunta, rimozione e
 *        spostamento di contatti.
 * 
 * @details Questa classe estende ContactList, include
 *          un numero massimo di contatti e diverse operazioni come il trasferimento 
 *          dei contatti nel cestino o in una lista di emergenza.
 * 
 * @author gruppo23
 * @date December 8, 2024
 * @version 1.0
*/
public class ContactBook extends ContactList implements Serializable {
    
    private static final int MAX_CONTACTS = 1000;
    private static int globalContactCount = 0;
    

    /**
     * @brief Aggiunge un contatto alla rubrica.
     * 
     * @param[in] contact: il contatto da aggiungere alla
     * @throws FullGroupException: il numero massimo di contatti è stato raggiunto
     * @post Il contatto viene aggiunto alla rubrica e il contatore globale è incrementato di 1.
     */
    @Override 
    public void addContact(Contact contact) throws FullGroupException {
        if (globalContactCount >= MAX_CONTACTS) {
                throw new FullGroupException("La rubrica ha raggiunto il numero massimo di contatti!");  
        }
        super.addContact(contact);
        globalContactCount++;
    }
    
    /**
     * @brief Rimuove un contatto dalla rubrica principale.
     * 
     * @pre Il contatto deve esistere nella rubrica.
     * @param[in] contact: contatto da rimuovere
     * @post Il contatto viene rimosso dalla rubrica e il contatore globale è decrementato di 1.
     */
    @Override
    public void removeContact(Contact contact){
        super.removeContact(contact);
        globalContactCount--;
    }
    
    /**
     * @brief Sposta un contatto dalla rubrica al cestino.
     * 
     * @pre Il contatto deve essere presente nella rubrica.
     * @param[in] contact Il contatto da spostare
     * @param[out] bin Il cestino in cui spostare il contatto
     * @post Il contatto viene rimosso dalla rubrica principale e aggiunto al cestino.
     */
    public void moveToBin(Contact contact, Bin bin) throws FullGroupException {
          if (contactList.contains(contact)) {
            removeContact(contact);
            bin.addContact(contact);
        } 
    }
    
    /**
     * @brief Aggiunge un contatto a una lista di emergenza.
     * 
     * @pre Il contatto non deve già essere presente nella lista di emergenza.
     * @param[in] contact Il contatto da aggiungere
     * @param[inout] eList La lista di emergenza a cui aggiungere il contatto
     * @post Il contatto viene aggiunto alla lista di emergenza (e mantenuto nella rubrica principale)
     */
    
    public void moveToEmergencyList(Contact contact, EmergencyList eList) throws FullGroupException {
        eList.addContact(contact);
    }
    
    /**
     * @brief Restituisce il numero totale di contatti presenti nella rubrica a livello globale.
     * 
     * @pre Nessuna precondizione.
     * @return il numero totale di contatti
     * @post Il numero totale di contatti rimane invariato dopo la chiamata.
     */
    public static int getGlobalContactCount() {
    
        return globalContactCount;
    }
    
    /**
     * @brief Restituisce il numero totale di contatti presenti nella rubrica a livello globale.
     * 
     * @pre Nessuna precondizione.
     * @return il numero totale di contatti
     * @post Il numero totale di contatti rimane invariato dopo la chiamata.
     */
    
    /**
     * @brief Mostra la lista dei contatti principale filtrata con i contatti preferiti
     * @pre La rubrica deve contenere almeno un contatto. Ogni contatto deve avere un attributo `isFavorite` correttamente impostato.
     * @post Viene visualizzata la lista dei contatti preferiti, se presenti.
     * 
     */
    public List<Contact> displayFavorites() {
        //da implementare
        List<Contact> favorites = new ArrayList<>();
        for (Contact contact : contactList) {
        if (contact.getIsFavorite() != null && contact.getIsFavorite()) {
            favorites.add(contact);
        }
    }
        return favorites;
    }
    
    
}
