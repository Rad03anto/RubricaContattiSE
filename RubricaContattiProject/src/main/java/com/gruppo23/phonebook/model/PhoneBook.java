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
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import javafx.scene.image.Image;

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

    public ContactBook getContactBook() {
        return contactBook;
    }

    public void setContactBook(ContactBook contactBook) {
        this.contactBook = contactBook;
    }

    public EmergencyList geteList() {
        return eList;
    }

    public void seteList(EmergencyList eList) {
        this.eList = eList;
    }

    public Bin getBin() {
        return bin;
    }

    public void setBin(Bin bin) {
        this.bin = bin;
    }
  
      /**
     * @brief Carica la rubrica da un file.
     * 
     * @param[in] filename Il nome del file da cui caricare la rubrica.
     * @return Un oggetto `PhoneBook` caricato dal file.
     * @note Se il caricamento fallisce, viene restituito `null`.
     */
  
    public void loadFromFile(String filename) throws FileNotFoundException, IOException, FullGroupException {
       //da implementare
    
        try(Scanner s = new Scanner(new  BufferedReader(new FileReader(filename)))){
            if(s.nextLine()== null) return;
            s.useDelimiter("[;\n]");//notazione insiemistica quando abbiamo più separatori che in questo caso sono ; e \n
            s.useLocale(Locale.US);
          
            while(s.hasNext()){
                String name =s.next();
                String surname = s.next();
                List<String> numbers= new ArrayList<>();
                numbers.add(s.next());
                  numbers.add(s.next());
                    numbers.add(s.next());
                
                List<String> ems= new ArrayList<>();
                ems.add(s.next());
                  ems.add(s.next());
                   ems.add(s.next());
                String address = s.next(); 
                String notes =s.next();
                String image = s.next(); // Salta immagine (null)
                Boolean fav = s.nextBoolean();
                Contact cc = new Contact(name,surname,numbers,ems,address,notes,null,fav);
                String prov=s.next().trim();
                if(prov.equalsIgnoreCase("CONTACTBOOK")){
                    contactBook.addContact(cc);
                }
                else if(prov.equalsIgnoreCase("BIN")){
                    bin.addContact(cc);
                }
                else eList.addContact(cc);
                
            }
            
        }
    }
        /**
     * @brief Salva la rubrica su un file.
     * 
     * @param[in] filename Il nome del file su cui salvare la rubrica.
     */
        
    public void saveToFile(String filename) throws IOException {
   
        try(PrintWriter pw = new PrintWriter( new BufferedWriter(new FileWriter( filename )))){
           
            pw.println("Name; Surname; number1; number2; number3; email1; email2; email3; address; notes; image; isFavorite; Type");
            
            for(Contact c : contactBook.getContacts()){
                
                pw.append(c.getName());
                pw.append(';');
                pw.append(c.getSurname());
                pw.append(';');
                pw.append(c.getPhoneNumbers().get(0));
                pw.append(';');
                pw.append(c.getPhoneNumbers().get(1));
                pw.append(';');
                pw.append(c.getPhoneNumbers().get(2));
                pw.append(';');
                pw.append(c.getEmails().get(0));
                pw.append(';');
                pw.append(c.getEmails().get(1));
                pw.append(';');
                pw.append(c.getEmails().get(2));
                pw.append(';');
                pw.append(c.getAddress());
                pw.append(';'); 
                pw.append(c.getNotes());
                pw.append(';');
         
                pw.append((CharSequence) c.getImage());
                pw.append(';');
                pw.append(""+ c.getIsFavorite());
                pw.append(';');
                pw.append("CONTACTBOOK");
                pw.append("\n");
            }
           
            for(Contact c : bin.getContacts()){
                
                pw.append(c.getName());
                pw.append(';');
                pw.append(c.getSurname());
                pw.append(';');
                pw.append(c.getPhoneNumbers().get(0));
                pw.append(';');
                pw.append(c.getPhoneNumbers().get(1));
                pw.append(';');
                pw.append(c.getPhoneNumbers().get(2));
                pw.append(';');
                pw.append(c.getEmails().get(0));
                pw.append(';');
                pw.append(c.getEmails().get(1));
                pw.append(';');
                pw.append(c.getEmails().get(2));
                pw.append(';');
                pw.append(c.getAddress());
                pw.append(';');
                 pw.append(c.getNotes());
                pw.append(';');
                pw.append((CharSequence) c.getImage());
                pw.append(';');
                pw.append(""+ c.getIsFavorite());
                pw.append(';');
                pw.append("BIN");
                pw.append("\n");
                
            }
            
          
            for(Contact c : eList.getContacts()){
                
                pw.append(c.getName());
                pw.append(';');
                pw.append(c.getSurname());
                pw.append(';');
                pw.append(c.getPhoneNumbers().get(0));
                pw.append(';');
                pw.append(c.getPhoneNumbers().get(1));
                pw.append(';');
                pw.append(c.getPhoneNumbers().get(2));
                pw.append(';');
                pw.append(c.getEmails().get(0));
                pw.append(';');
                pw.append(c.getEmails().get(1));
                pw.append(';');
                pw.append(c.getEmails().get(2));
                pw.append(';');
                pw.append(c.getAddress());
                pw.append(';');
                pw.append(c.getNotes());
                pw.append(';');
                pw.append((CharSequence) c.getImage());
                pw.append(';');
                pw.append(""+ c.getIsFavorite());
                pw.append(';');
                pw.append("EMERGENCYLIST");
                pw.append("\n");
            }
    }
    }
}
