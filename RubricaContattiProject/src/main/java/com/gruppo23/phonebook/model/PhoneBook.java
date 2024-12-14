/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gruppo23.phonebook.model;

import java.io.Serializable;

/**
 * @package com.gruppo23.phonebook.model
 * @class PhoneBook
 * @brief Gestisce la rubrica dei contatti, inclusi salvataggio, caricamento e gestione delle liste.
 * 
 * @details Questa classe gestisce una rubrica principale (`ContactBook`), una lista di emergenza (`EmergencyList`) 
 * e un cestino (`Bin`). Include funzionalità per il salvataggio dei dati su file e il caricamento da file.
 * 
 * @author gruppo23
 * @version 1.0
 * @date 8 Dicembre 2024

 */
public class PhoneBook implements Serializable { 
    
    private ContactBook contactBook;
    private EmergencyList eList;
    private Bin bin;
    
/**
 * @brief Costruttore di PhoneBook.
 * 
 * @details Inizializza la rubrica, la lista di emergenza e il cestino.
 * 
 * @param[in] contactBook Oggetto di tipo `ContactBook` per gestire i contatti.
 * @param[in] eList Oggetto di tipo `EmergencyList` per gestire la lista di emergenza.
 * @param[in] bin Oggetto di tipo `Bin` per gestire il cestino.
 */     
    
    public PhoneBook(ContactBook contactBook, EmergencyList eList, Bin bin) {
        this.contactBook = contactBook;
        this.eList = eList;
        this.bin = bin;
    }
  
      /**
     * @brief Carica la rubrica da un file.
     * 
     * @param[in] filename Il nome del file da cui caricare la rubrica.
     * @return Un oggetto `PhoneBook` caricato dal file.
     * @note Se il caricamento fallisce, viene restituito `null`.
     */
  
    public static PhoneBook loadFromFile(String filename) {
       //da implementare
    return null;
    }
    
        /**
     * @brief Salva la rubrica su un file.
     * 
     * @param[in] filename Il nome del file su cui salvare la rubrica.
     */
    public void saveToFile(String filename) {
        //da implementare
    }
    
}
