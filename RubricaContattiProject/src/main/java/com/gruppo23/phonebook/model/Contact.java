/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gruppo23.phonebook.model;


import com.gruppo23.phonebook.exceptions.InvalidContactException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

/**
* @package com.gruppo23.phonebook.model
* @class Contact.java
* @brief Questo file contiene l'implementazione dei metodi della classe Contact  
*
* Il file contenente la classe Contact presenta tutti gli attributi che appartengono agli oggetti Contact e i metodi invocabili   * su  essi
*
* @author Gruppo23
* @date Dicembre 8, 2024
* @versione 1.0
*/
public class Contact implements Comparable<Contact> {
    
    private String name;///< Il nome del contatto
    private String surname; ///< Il cognome del contatto
    private List<String> phoneNumbers; ///< Lista dei numeri di cellulare del contatto
    private List<String> emails; ///< Lista delle email associate al contatto
    private String address; ///< Indirizzo di locazione associato al contatto
    private String notes; ///< Informazioni aggiuntive associate al contatto
    private Image image; ///< Immagine di profilo associata al contatto
    private Boolean isFavorite; ///< Etichetta che identifica il contatto come preferito o meno
    
    /**
*
* @brief Costruttore degli oggetti Contact
* 
* @pre name e surname non devono essere entrambe vuote
* @post Il valore restituito è un oggetto Contact
*
* @param[in] name  La stringa che assegnerà un valore all'attributo name dell'oggetto Contact che verrà creato.
* @param[in] surname La stringa che assegnerà un valore all'attributo surname dell'oggetto  Contact che verrà creato.
*
* @throws InvalidContactException Eccezione che viene lanciata nel caso in cui le stringhe name e surname sono vuote
* @return nuovo oggetto Contact
*/
    public Contact(String name, String surname, List<String> phoneNumbers, List<String> emails, String address, String notes, Image image, Boolean isFavorite) throws InvalidContactException {    
    if ((name == null || name.trim().isEmpty()) && (surname == null || surname.trim().isEmpty())) {
        throw new InvalidContactException("Il contatto deve avere almeno un nome o un cognome.");

    }
    this.name = name;
    this.surname = surname;
    this.phoneNumbers = phoneNumbers;
    this.emails = emails;
    this.address = address;
    this.notes = notes;
    this.image = image;
    this.isFavorite = isFavorite;
}


    /**
     *
     * @brief metodo per ottenere il valore del nome di un contatto della rbrica
     *
     * @pre L'oggetto Contact su cui viene invocato il metodo deve essere esistente
     * @post Il valore restituito è il nome dell'oggetto Contact su cui è stato invocato il metodo
     *
     * @return valore dell'attributo name su cui è stato invocato l'oggetto
     */
    public String getName() {
        return name;
    }

/**
*
* @brief metodo per ottenere il cognome di un contatto della rubrica
* 
* @pre L'oggetto Contact su cui viene invocato il metodo deve essere esistente
* @post Il valore restituito è il cognome dell'oggetto Contact su cui è stato invocato il metodo
*
* @return valore dell'attributo surname su cui è stato invocato l'oggetto
*/

    public String getSurname() {
        return surname;
    }

    /**
*
* @brief metodo per ottenere la lista dei numeri di telefono di un contatto della rubrica
* 
* @pre L'oggetto Contact su cui viene invocato il metodo deve essere esistente
* @post Il valore restituito è la lista phonenumbers dell'oggetto Contact su cui è stato invocato il metodo
*
* @return valori contenuti nell'attributo phonenumbers 
*/
    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

/**
*
* @brief metodo per ottenere la lista delle email di un contatto della rubrica
* 
* @pre L'oggetto Contact su cui viene invocato il metodo deve essere esistente
* @post Il valore restituito è la list emails dell'oggetto Contact su cui è stato invocato il metodo
*
* @return valori contenuti nell'attributo emails
*/
    public List<String> getEmails() {
        return emails;
    }

/**
* 
* @brief metodo per ottenere l'indirizzo di un contatto della rubrica
* 
* @pre L'oggetto Contact su cui viene invocato il metodo deve essere esistente
* @post Il valore restituito è l'indirizzo dell 'oggetto su cui è stato invocato il metodo
*
* @return  valore dell'attributo address
*/

    public String getAddress() {
        return address;
    }

/**
*
* @brief metodo per ottenere le note di un contatto della rubrica
* 
* @pre L'oggetto Contact su cui viene invocato il metodo deve essere esistente
* @post Ottenimento di informazioni aggiuntive sull 'oggetto su cui è stato invocato il metodo
*
* @return valore dell'attributo notes
*/    
    public String getNotes() {
        return notes;
    }

/**
*
* @brief metodo per ottenere l'immagine di un contatto della rubrica
* 
* @pre L'oggetto Contact su cui viene invocato il metodo deve essere esistente
* @post Il valore restituito è l'immagine dell 'oggetto su cui è stato invocato il metodo
*
* @return  valore dell'attributo image
*/
    public Image getImage() {
        return image;
    }

/**
*
* @brief metodo per impostare il nome di un contatto della rubrica
*
* @pre L'oggetto Contact su cui è invocato il metodo deve essere esistente
* @post  Il contatto ha un nome
*
* @param name il nome che verrà assegnato all'oggetto Contact
*
*/
     public void setName(String name) {
        this.name = name;
    }

/**
*
* @brief metodo per impostare il cognome di un contatto della rubrica
*
* @pre L'oggetto Contact su cui è invocato il metodo deve essere esistente
* @post  Il contatto ha un cognome
*
* @param surname il cognome che verrà assegnato all'oggetto Contact
*
*/
    public void setSurname(String surname) {
        this.surname = surname;
    }

/**
*
* @brief metodo per impostare i numeri di cellulare di un contatto della rubrica
*
* @pre L'oggetto Contact su cui è invocato il metodo deve essere esistente
* @post  Il contatto ha una lista di numeri di cellulare
*
* @param phoneNumbers La lista di numeri di cellulare che verranno assegnati all'oggetto Contact
*
*/

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
  
/**
*
* @brief metodo per impostare le email di un contatto della rubrica
*
* @pre L'oggetto Contact su cui è invocato il metodo deve essere esistente
* @post  Il contatto ha una o più email
*
* @param emails la lista di valori che verranno assegnati all'attributo emails dell'oggetto Contact
*
*/
    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

/**
*
* @brief metodo per impostare l'indirizzo di un contatto della rubrica
*
* @pre L'oggetto Contact su cui è invocato il metodo deve essere esistente
* @post  Il contatto ha il campo indirizzo pieno
*
* @param[in] address Il valore che verrà assegnato al campo indirizzo delll'oggetto Contact
*
*/

    public void setAddress(String address) {
        this.address = address;
    }

    /**
*
* @brief metodo per inserire informazioni aggiuntive di un contatto della rubrica
*
* @pre L'oggetto Contact su cui è invocato il metodo deve essere esistente
* @post  Il contatto ha delle informazioni aggiuntive
*
* @param notes il contenuto che verrà assegnato all'attributo notes dell'oggetto Contact
*
*/
    public void setNotes(String notes) {
        this.notes = notes;
    }

/**
*
* @brief metodo per impostare un'immagine di profilo ad un contatto della rubrica
*
* @pre L'oggetto Contact su cui è invocato il metodo deve essere esistente
* @post  Il contatto ha un'immaginee di profilo
*
* @param[in] image l''immagine che verrà assegnata all'attributo image delll'oggetto Contact
*
*/ 
    public void setImage(Image image) {
        this.image = image;
    }

/**
*
* @brief metodo per impostare come preferito un contatto della rubrica
*
* @pre L'oggetto Contact su cui è invocato il metodo deve essere esistente
* @post  Il contatto viene etichettato come preferito o meno
*
* @param[in] isFavorite il valore  booleano che verrà assegnato al campo isFavorite dell'oggetto Contact
*
*/
    public Boolean getIsFavorite() {
        return isFavorite;
    }

/**
*
* @brief metodo per modificare di un contatto della rubrica
*
* @pre L'oggetto Contact su cui è invocato il metodo deve essere esistente
* @post  Il contatto ha un nome
*
* @param[in] name il nome che verrà assegnato all'oggetto Contact
*
*/
    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
    
    /**
     * @brief metodo per la comparazione tra due contatti, utile alla visualizzazione in ordine alfabetico
     * 
     * @details nel caso in cui il cognome del contatto con cui confrontare non abbia il cognome, se il contatto da
     * aggiungere non ha il cognome, vengono confrontati i nomi, altrimenti se lo ha si confronta il cognome con il
     * nome del contatto da confrontare.
     * Nel caso in cui il cognome del contatto da aggiungere sia assente, si confronta il nome del contatto da aggiungere
     * con il cognome del contatto da confrontare.
     * Se entrambi hanno il cognome, si fa confronto tra cognomi.
     * Se i cognomi sono uguali, vengono confrontati i nomi.
     * 
     * @param contact
     * @return 
     */
    public int compareTo(Contact contact) {
        
    if (this.surname == null || this.surname.isEmpty()) {
        if (contact.surname == null || contact.surname.isEmpty()) {
            
            return this.name.compareTo(contact.name);
        } else {
            
            return this.name.compareTo(contact.surname);
        }
    }

    if (contact.surname == null || contact.surname.isEmpty()) {
        return this.surname.compareTo(contact.name);
    }

    int surnameComparison = this.surname.compareTo(contact.surname);
    if (surnameComparison != 0) {
        return surnameComparison;
    }
    
    return this.name.compareTo(contact.name);
    }
}
  

