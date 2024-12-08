/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gruppo23.phonebook.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @package com.gruppo23.phonebook.model
 * @brief Questa classe astratta contiene metodi e attributi ereditabili da altre classi
 * @author gruppo23
 * @date December 8, 2024
 * @version 1.0
 */
public abstract class ContactList implements Serializable{
    
    protected List<Contact> contactList = new ArrayList<>();
    
    /**
     * @brief Metodo usato per aggiungere un contatto a una lista generica
     * 
     * @pre La lista non contiene il contatto
     * @post Il contatto viene aggiunto alla lista
     * @note Invariante: Il contatto non deve essere nullo
     * 
     * @param[in] contact Il contatto che verrà aggiunto alla lista
     */
    public void addContact(Contact contact){
        contactList.add(contact);
    }
    
    /**
     * @brief Metodo usato per rimuovere un contatto a una lista generica
     * 
     * @pre Il contatto è presente nella lista
     * @post Il contatto viene rimosso dalla lista
     * @note Invariante: Il contatto deve esistere
     * 
     * @param[in] contact Il contatto da rimuovere
     */
    
    public void removeContact(Contact contact){
        contactList.remove(contact);
    }
    
    /**
     * @brief Metodo usato per cercare un contatto in una lista generica, cercando per nome e cognome
     * 
     * Restituisce quella lista ordinata in base alle caratteristiche: nome e cognome.
     * La lista viene filtrata in base a:
     * 1. cognome che inizia per la sottostringa passata
     * 2. cognome che contiene la sottostringa passata
     * 3. nome che inizia per la sottostringa passata
     * 4. nome che contiene la sottostringa passata
     * 
     * @pre Viene visualizzata la lista completa
     * @post Viene visualizzata la lista "filtrata" e ordinata
     * 
     * @note Invariante: Il contatto deve esistere
     * 
     * @param[in] string La sottostringa da cercare
     * @return result La lista filtrata e ordinata
     */
    
    public List<Contact> search(String string){
        //da implementare
        List<Contact> result = new ArrayList();
        return result;
    }
    
    /**
     * @brief Restituisce una lista di contatti
     * 
     * @return la lista di contatti
     */
    public List<Contact> getContacts() {
        return contactList;
    }
  
}
