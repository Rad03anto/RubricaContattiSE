/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gruppo23.phonebook.model;

import com.gruppo23.phonebook.exceptions.FullGroupException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
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
public class PhoneBook  extends ContactList implements Serializable{ 
    
    private ContactBook contactBook;
    private EmergencyList eList;
    private Bin bin;
    private String name;
    
/**
 * @brief Costruttore di PhoneBook.
 * 
 * @details Inizializza la rubrica, la lista di emergenza e il cestino.
 * 
 * @param[in] contactBook Oggetto di tipo `ContactBook` per gestire i contatti.
 * @param[in] eList Oggetto di tipo `EmergencyList` per gestire la lista di emergenza.
 * @param[in] bin Oggetto di tipo `Bin` per gestire il cestino.
 */
  
    public PhoneBook(ContactBook contactBook, EmergencyList eList, Bin bin,String name) {
        this.contactBook = contactBook;
        this.eList = eList;
        this.bin = bin;
        this.name=name;
}

    /**
     * @brief Carica la rubrica da un file.
     * 
     * @param[in] filename Il nome del file da cui caricare la rubrica.
     * @return Un oggetto `PhoneBook` caricato dal file.
     * @note Se il caricamento fallisce, viene restituito `null`.
     */
    public static PhoneBook loadFromFile(String filename) throws FullGroupException {
        //da implementare
        PhoneBook phonebook = new PhoneBook("Import from file: " + filename);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                Contact contact = new Contact();
                Scanner scanner = new Scanner(line);
                scanner.useDelimiter("\\|"); // Utilizzo del delimitatore pipe "|"
                
                // Lettura dei campi del contatto
                contact.setName(scanner.next().trim());
                contact.setSurname(scanner.next().trim());
                contact.setPhoneNumbers(Arrays.asList(scanner.next().split(";")));
                contact.setEmails(Arrays.asList(scanner.next().split(";")));
                contact.setAddress(scanner.next().trim());
                contact.setNotes(scanner.next().trim());
                
                // Aggiunta del contatto alla rubrica
                phonebook.addContact(contact);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PhoneBook.class.getName()).log(Level.SEVERE, "File non trovato: " + filename, ex);
        } catch (IOException ex) {
            Logger.getLogger(PhoneBook.class.getName()).log(Level.SEVERE, "Errore durante la lettura del file", ex);
        }
        
        return phonebook;
    }

    private PhoneBook(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    
        /**
     * @brief Salva la rubrica su un file.
     * 
     * @param[in] filename Il nome del file su cui salvare la rubrica.
     */
    public void saveToFile(String filename) {
         try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        // Scrive ogni contatto nel file
        for (Contact contact : this.getContacts()) {
            // Crea una stringa per ogni contatto, separando i campi con "|"
            String contactData = contact.getName() + "|" +
                                 contact.getSurname() + "|" +
                                 String.join(";", contact.getPhoneNumbers()) + "|" +
                                 String.join(";", contact.getEmails()) + "|" +
                                 contact.getAddress() + "|" +
                                 contact.getNotes();
            
            // Scrive la stringa nel file
            writer.write(contactData);
            writer.newLine(); // Aggiungi una nuova riga per il prossimo contatto
        }
        writer.flush(); // Assicurati che tutti i dati vengano scritti nel file
    } catch (IOException ex) {
        Logger.getLogger(PhoneBook.class.getName()).log(Level.SEVERE, "Errore durante il salvataggio del file", ex);
    }
}
    }
    

