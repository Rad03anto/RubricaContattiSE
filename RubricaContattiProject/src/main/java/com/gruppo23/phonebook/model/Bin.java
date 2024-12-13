/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gruppo23.phonebook.model;

import com.gruppo23.phonebook.exceptions.FullGroupException;

/**
 *Classe Bin
 *@brief Gestisce un cestino per contatti, consentendo il ripristino o
 *la cancellazione automatica dei contatti.
 *
 *@details  La classe Bin estende ContactList e aggiunge funzionalità specifiche per
 *la gestione dei contatti spostati nel cestino, come il ripristino e l'eliminazione automatica.
 *
 *@author gruppo23
 */
public class Bin extends ContactList {
    
/**
 *@brief Costruttore predefinito della classe Bin.
 *@post Viene creato un oggetto Bin vuoto.
 */

    public Bin() {     
    }
    
 /**
     * @param contact
     * @brief Ripristina un contatto dal cestino alla rubrica.
     * 
     * @pre Il contatto deve essere presente nel cestino.
     * @param[in] contact il contatto da ripristinare
     * @post Il contatto viene rimosso dal cestino, pronto per essere aggiunto a un'altra lista.
     */
   
    public void restoreContact(Contact contact, ContactBook contactBook) throws FullGroupException{
       removeContact(contact);
       contactBook.addContact(contact);
    }
/**
 *@brief Elimina automaticamente tutti i contatti dal cestino.
 *@pre Il cestino  contiene uno o più contatti.
 *@post Tutti i contatti presenti nel cestino vengono eliminati definitivamente.
 */
    public void autodeleteFromBin(){
        
    }
    
}
