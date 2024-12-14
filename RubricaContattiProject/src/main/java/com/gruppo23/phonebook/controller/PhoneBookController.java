/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruppo23.phonebook.controller;

import com.gruppo23.phonebook.model.EmergencyList;
import com.gruppo23.phonebook.exceptions.FullGroupException;
import com.gruppo23.phonebook.exceptions.InvalidContactException;
import com.gruppo23.phonebook.model.Bin;
import com.gruppo23.phonebook.model.Contact;
import com.gruppo23.phonebook.model.ContactBook;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 * Classe che gestisce il controller della rubrica telefonica, fornendo i metodi per l'inizializzazione
 * e la gestione delle operazioni relative all'interfaccia utente e ai dati della rubrica.
 * @author gruppo23
 */
public class PhoneBookController implements Initializable {
    
    @FXML
    private TextField searchCB;
    @FXML
    private Button CreateButton;
    @FXML
    private Button ViewButton;
    @FXML
    private Button AddToELButton;
    @FXML
    private Button ImportButton;
    @FXML
    private Button ExportButton;
    @FXML
    private TextField searchEL;
    @FXML
    private Button RemoveELButton;
    @FXML
    private TextField searchB;
    @FXML
    private GridPane CreateForm;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private TextField number1TextField;
    @FXML
    private TextField email1TextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField notesTextField;
    @FXML
    private TextField number2TextField;
    @FXML
    private TextField number3TextField;
    @FXML
    private TextField email2TextField;
    @FXML
    private TextField email3TextField;
    @FXML
    private CheckBox favoritesCheckBox;
    @FXML
    private TableView<Contact> TableBook;
    @FXML
    private GridPane ContactView;
    @FXML
    private Label number3Label;
    @FXML
    private Label email3Label;
    @FXML
    private Label addressLabel;
    @FXML
    private Label favoritesLabel;
    @FXML
    private Label notesLabel;
    @FXML
    private Label email1Label;
    @FXML
    private Label email2Label;
    @FXML
    private Label nameLabel;
    @FXML
    private Label surnameLabel;
    @FXML
    private Label number1Label;
    @FXML
    private Label number2Label;
    @FXML
    private TableColumn<Contact,String> surnameClm;
    @FXML
    private TableColumn<Contact,String> nameClm;
    @FXML
    private Button SaveContactButton;
    @FXML
    private Button ImageButton;
    @FXML
    private ImageView contactImage;
    @FXML
    private Button onMoveToBinButton;
    
    /**
     * Inizializza la classe controller.
     */
    @FXML
    private TableView<Contact> TableEL;
    @FXML
    private TableColumn<Contact, String> surnameClm1;
    @FXML
    private TableColumn<Contact, String> nameClm1;
    @FXML
    private TableView<Contact> TableBin;
    @FXML
    private TableColumn<Contact, String> surnameClm2;
    @FXML
    private TableColumn<Contact, String> nameClm2;
    
    private ContactBook contactBook;
    private EmergencyList emergencyList;
    private ObservableList<Contact> observableContacts;
    private ObservableList<Contact> observableEL;


    @FXML
    private Button goBackButton;
    @FXML
    private Button ViewButton1;
    @FXML
    private Button ViewButton11;
    @FXML
    private Tab emergencyTab;
    @FXML
    private Tab contactBookTab;
    @FXML
    private Tab binTab;
    @FXML
    private Label number3Label2;
    @FXML
    private Label email3Label2;
    @FXML
    private Label addressLabel2;
    @FXML
    private Label favoritesLabel2;
    @FXML
    private Label notesLabel2;
    @FXML
    private Label email1Label2;
    @FXML
    private Label email2Label2;
    @FXML
    private Label nameLabel2;
    @FXML
    private Label surnameLabel2;
    @FXML
    private Label number1Label2;
    @FXML
    private Button goBackButton2;
    @FXML
    private Label number2Label2;
    @FXML
    private Label number3Label21;
    @FXML
    private Label email3Label21;
    @FXML
    private Label addressLabel21;
    @FXML
    private Label favoritesLabel21;
    @FXML
    private Label notesLabel21;
    @FXML
    private Label email1Label21;
    @FXML
    private Label email2Label21;
    @FXML
    private Label nameLabel21;
    @FXML
    private Label surnameLabel21;
    @FXML
    private Label number1Label21;
    @FXML
    private Button goBackButton21;
    @FXML
    private Label number2Label21;
    @FXML
    private GridPane ContactView1;
    @FXML
    private GridPane ContactView11;
    @FXML
    private Button SearchButton;
    @FXML
    private Button SearchButton1;
    @FXML
    private Button SearchButton2;

    private Bin bin;
    private ObservableList<Contact> observableBin;
    @FXML

    private Button onRestoreButton;
    @FXML
    private Button onRemoveBinButton;

    @FXML
    private Button editContactButton;
    @FXML
    private GridPane CreateForm1;
    @FXML
    private TextField nameTextField1;
    @FXML
    private TextField surnameTextField1;
    @FXML
    private TextField number1TextField1;
    @FXML
    private TextField email1TextField1;
    @FXML
    private TextField addressTextField1;
    @FXML
    private TextField notesTextField1;
    @FXML
    private TextField number2TextField1;
    @FXML
    private TextField number3TextField1;
    @FXML
    private TextField email2TextField1;
    @FXML
    private TextField email3TextField1;
    @FXML
    private CheckBox favoritesCheckBox1;
    @FXML
    private ImageView contactImage1;
    @FXML
    private Button ImageButton1;
    @FXML
    private Button CancelButton;
    @FXML
    private Button SaveEditButton1;
    @FXML
    private Button CancelButton1;
    @FXML
    private AnchorPane rubricaZone;
    @FXML
    private Button FavButton;
    @FXML
    private Button ContactBookButton;
    


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Implementazione dei setText della pagina Rubrica
        binTab.setText("🗑 Cestino");
        contactBookTab.setText("📖 Rubrica");
        SearchButton.setText("🔍 Cerca");
        emergencyTab.setText("🚑 Contatti di emergenza");
        CreateButton.setText("➕ Crea Contatto");
        ViewButton.setText("👁 Visualizza Contatto");
        AddToELButton.setText("🚑 Aggiungi ai contatti di emergenza");
        onMoveToBinButton.setText("🗑 Sposta nel cestino");
        ImportButton.setText("📥 Importa rubrica");
        ExportButton.setText("📤 Esporta rubrica");
        
        //Implementazione dei setText della pagina EmergencyList
        SearchButton1.setText("🔍 Cerca");
        RemoveELButton.setText("🚑 Rimuovi dai contatti di emergenza");
        ViewButton1.setText("👁 Visualizza Contatto");
        
        //Implementazione dei setText della pagina Cestino
        SearchButton2.setText("🔍 Cerca");
        onRestoreButton.setText("🔁 Ripristina contatto");
        onRemoveBinButton.setText("🗑 Rimuovi definitivamente dai contatti");
        ViewButton11.setText("👁 Visualizza Contatto");
        
        contactBook = new ContactBook();
        emergencyList = new EmergencyList();
        observableContacts = FXCollections.observableArrayList(contactBook.getContacts());
        bin = new Bin();
        observableEL = FXCollections.observableArrayList(emergencyList.getContacts());
        observableBin = FXCollections.observableArrayList(bin.getContacts());
        nameClm.setCellValueFactory(new PropertyValueFactory("name"));
        surnameClm.setCellValueFactory(new PropertyValueFactory("surname"));
        nameClm1.setCellValueFactory(new PropertyValueFactory("name"));
        surnameClm1.setCellValueFactory(new PropertyValueFactory("surname"));
        nameClm2.setCellValueFactory(new PropertyValueFactory("name"));
        surnameClm2.setCellValueFactory(new PropertyValueFactory("surname"));
        
        TableBook.setItems(observableContacts);
        TableEL.setItems(observableEL);
        TableBin.setItems(observableBin);
    }
    
    @FXML
    private void handleCreateButtonAction(ActionEvent event) {
        ContactView.setVisible(false);
        TableBook.setVisible(false);
        CreateForm.setVisible(true);
    }

    @FXML
    private void onSaveContactButton(ActionEvent event) throws InvalidContactException {
        
        TableBook.setItems(observableContacts);
        
        String name = nameTextField.getText();
        String surname = surnameTextField.getText();
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(number1TextField.getText());
        phoneNumbers.add(number2TextField.getText());
        phoneNumbers.add(number3TextField.getText());
        List<String> emails = new ArrayList<>();
        emails.add(email1TextField.getText());
        emails.add(email2TextField.getText());
        emails.add(email3TextField.getText());
        String address = addressTextField.getText();
        String notes = notesTextField.getText();
        Image image = contactImage.getImage();
        boolean isFavorite = favoritesCheckBox.isSelected();
        
        Contact newContact = new Contact(name, surname, phoneNumbers, emails, address, notes, image, isFavorite);
        try {
            contactBook.addContact(newContact);
            observableContacts.setAll(contactBook.getContacts());
        } catch (FullGroupException ex) {
            Logger.getLogger(PhoneBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CreateForm.setVisible(false);
        TableBook.setVisible(true);
        
        nameTextField.clear();
        surnameTextField.clear();
        number1TextField.clear();
        number2TextField.clear();
        number3TextField.clear();
        email1TextField.clear();
        email2TextField.clear();
        email3TextField.clear();
        addressTextField.clear();
        notesTextField.clear();
        favoritesCheckBox.setSelected(false);
        contactImage.setImage(null);
    }

    @FXML
    private void onAddToELButton(ActionEvent event) throws FullGroupException {
         Contact selectedContact = TableBook.getSelectionModel().getSelectedItem();
         if(selectedContact!=null){
             contactBook.moveToEmergencyList(selectedContact, emergencyList);
             observableEL.setAll(emergencyList.getContacts());
             
             }
            
    }
    
    
    @FXML
    private void onDisplayContactButton(ActionEvent event) {
        Object source= event.getSource();
        Contact selectedContact;
        
        if(source == ViewButton){
        selectedContact = TableBook.getSelectionModel().getSelectedItem();
        CreateForm.setVisible(false);
        TableBook.setVisible(false);
        ContactView.setVisible(true);
        
        int i=0;
        int j=0;
        nameLabel.setText(selectedContact.getName());
        surnameLabel.setText(selectedContact.getSurname());
       
        
        for(String p : selectedContact.getPhoneNumbers()){
            if(i==0){
            number1Label.setText(p);    
            i++;            
            }
            else if(i==1){
                number2Label.setText(p);
                i++;
            }
            else if(i==2){
                number3Label.setText(p);
            }
        }
        
         for(String s : selectedContact.getEmails()){
            if(j==0){
            email1Label.setText(s);    
            j++;            
            }
            else if(i==1){
                email2Label.setText(s);
                j++;
            }
            else if(j==2){
                email3Label.setText(s);
            }
        }
         
         notesLabel.setText(selectedContact.getNotes());
         addressLabel.setText(selectedContact.getAddress());
         if(selectedContact.getIsFavorite()==true)
         favoritesLabel.setText("Preferito");
         else favoritesLabel.setText("Non preferito");
         contactImage.setImage(selectedContact.getImage());
         
        }
        else if(source == ViewButton1){
         selectedContact = TableEL.getSelectionModel().getSelectedItem();
       
        TableEL.setVisible(false);
        ContactView1.setVisible(true);
        
        int i=0;
        int j=0;
        nameLabel2.setText(selectedContact.getName());
        surnameLabel2.setText(selectedContact.getSurname());
       
        
        for(String p : selectedContact.getPhoneNumbers()){
            if(i==0){
            number1Label2.setText(p);    
            i++;            
            }
            else if(i==1){
                number2Label2.setText(p);
                i++;
            }
            else if(i==2){
                number3Label2.setText(p);
            }
        }
        
         for(String s : selectedContact.getEmails()){
            if(j==0){
            email1Label2.setText(s);    
            j++;            
            }
            else if(i==1){
                email2Label2.setText(s);
                j++;
            }
            else if(j==2){
                email3Label2.setText(s);
            }
        }
         
         notesLabel2.setText(selectedContact.getNotes());
         addressLabel2.setText(selectedContact.getAddress());
         if(selectedContact.getIsFavorite()==true)
         favoritesLabel2.setText("Preferito");
         else favoritesLabel2.setText("Non preferito");
         contactImage.setImage(selectedContact.getImage());
         
        
        }
        else{
        selectedContact = TableBin.getSelectionModel().getSelectedItem();
        
        TableBin.setVisible(false);
       
        ContactView11.setVisible(true);
        int i=0;
        int j=0;
        nameLabel21.setText(selectedContact.getName());
        surnameLabel21.setText(selectedContact.getSurname());
       
        
        for(String p : selectedContact.getPhoneNumbers()){
            if(i==0){
            number1Label21.setText(p);    
            i++;            
            }
            else if(i==1){
                number2Label21.setText(p);
                i++;
            }
            else if(i==2){
                number3Label21.setText(p);
            }
        }
        
         for(String s : selectedContact.getEmails()){
            if(j==0){
            email1Label21.setText(s);    
            j++;            
            }
            else if(i==1){
                email2Label21.setText(s);
                j++;
            }
            else if(j==2){
                email3Label21.setText(s);
            }
        }
         
         notesLabel21.setText(selectedContact.getNotes());
         addressLabel21.setText(selectedContact.getAddress());
         if(selectedContact.getIsFavorite()==true)
         favoritesLabel21.setText("Preferito");
         else favoritesLabel21.setText("Non preferito");
         contactImage.setImage(selectedContact.getImage());
         
        }
        
       
    }

    @FXML
    private void onGoBackButton(ActionEvent event) {
        Object source = event.getSource();
        
        if(source== goBackButton){
        ContactView.setVisible(false);
        TableBook.setVisible(true);}
        else if( source == goBackButton2){
          ContactView1.setVisible(false);
        TableEL.setVisible(true);}  
        
      else{
    ContactView11.setVisible(false);
        TableBin.setVisible(true);
    }
    }
    
    @FXML
    private void handleEmergencyTab(Event event) {
        CreateForm.setVisible(false);
        ContactView1.setVisible(false);
        TableEL.setVisible(true);
    }

    @FXML
    private void onContactBookTab(Event event) {
         ContactView.setVisible(false);
        TableBook.setVisible(true);
    }

    @FXML
    private void onBinTab(Event event) {
        CreateForm.setVisible(false);
        ContactView11.setVisible(false);
        TableBin.setVisible(true);
    }
   
   @FXML
    private void onMoveToBinButton(ActionEvent event) throws FullGroupException {
    Contact selectedContact = TableBook.getSelectionModel().getSelectedItem();
        if (selectedContact != null) {
            if (emergencyList.getContacts().contains(selectedContact)) {
            emergencyList.removeContact(selectedContact);
            observableEL.setAll(emergencyList.getContacts());
        }
            observableBin.add(selectedContact);
            bin.addContact(selectedContact);
            contactBook.removeContact(selectedContact);
            observableContacts.remove(selectedContact);
        }
    }



    @FXML
    private void onEditContactButton(ActionEvent event) {
      Contact selectedContact = TableBook.getSelectionModel().getSelectedItem();
      int i=0;
      int j=0;
        CreateForm1.setVisible(true);
        CreateForm.setVisible(false);
        ContactView.setVisible(false);
        nameTextField1.setText(selectedContact.getName());
        surnameTextField1.setText(selectedContact.getSurname());
         for(String p : selectedContact.getPhoneNumbers()){
            if(i==0){
            number1TextField1.setText(p);    
            i++;            
            }
            else if(i==1){
                number2TextField1.setText(p);
                i++;
            }
            else if(i==2){
                number3TextField1.setText(p);
            }
        }
        
         for(String s : selectedContact.getEmails()){
            if(j==0){
            email1TextField1.setText(s);    
            j++;            
            }
            else if(j==1){
                email2TextField1.setText(s);
                j++;
            }
            else if(j==2){
                email3TextField1.setText(s);
            }
        }
    
     addressTextField1.setText(selectedContact.getAddress());
    notesTextField1.setText(selectedContact.getNotes());
    favoritesCheckBox1.setSelected(selectedContact.getIsFavorite());
     contactImage1.setImage(selectedContact.getImage());
  
    }


    @FXML
    private void onSaveEditButton(ActionEvent event) throws InvalidContactException {
        Contact selectedContact = TableBook.getSelectionModel().getSelectedItem();
        
        selectedContact.setName(nameTextField1.getText());
        selectedContact.setSurname(surnameTextField1.getText());
        selectedContact.getPhoneNumbers().set(0,number1TextField1.getText());
        selectedContact.getPhoneNumbers().set(1,number2TextField1.getText());
        selectedContact.getPhoneNumbers().set(2,number3TextField1.getText());
        selectedContact.getEmails().set(0,email1TextField1.getText());
        selectedContact.getEmails().set(1,email2TextField1.getText());
        selectedContact.getEmails().set(2,email3TextField1.getText());
        selectedContact.setAddress(addressTextField1.getText());
        selectedContact.setNotes(notesTextField1.getText());
        selectedContact.setImage(contactImage1.getImage());
        selectedContact.setIsFavorite(favoritesCheckBox1.isSelected());
        
        if ((selectedContact.getName() == null || selectedContact.getName().trim().isEmpty()) && (selectedContact.getSurname() == null || selectedContact.getSurname().trim().isEmpty())) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Contatto non salvato!");
        alert.setHeaderText("Il contatto non è stato modificato correttamente!");
        alert.setContentText("Inserire almeno un nome o un cognome.");
        alert.showAndWait();
        throw new InvalidContactException("Il contatto deve avere almeno un nome o un cognome.");

    }
       TableBook.refresh();
        
        CreateForm1.setVisible(false);
        TableBook.setVisible(true);
    }

    @FXML
    private void onCancelButton(ActionEvent event) {
        CreateForm1.setVisible(false);
        CreateForm.setVisible(false);
        TableBook.setVisible(true);
    }


    
    @FXML
    private void onSearchButtonAction(ActionEvent event) {
        List<Contact> filteredContacts = contactBook.search(searchCB.getText().toLowerCase());
        ObservableList<Contact> observableFilteredContacts = FXCollections.observableArrayList(filteredContacts);
        TableBook.setItems(observableFilteredContacts);
    }
    
    @FXML
    private void onRestoreButton(ActionEvent event) throws FullGroupException {
        
        Contact selectedContact = TableBin.getSelectionModel().getSelectedItem();

        if (selectedContact != null) {
            bin.restoreContact(selectedContact, contactBook);
            observableContacts.add(selectedContact); 
            observableBin.remove(selectedContact);
            TableBook.refresh();
            TableBin.refresh();
        }
    }
    
    @FXML
    private void onRemoveBinButton(ActionEvent event) {
        Contact selectedContact = TableBin.getSelectionModel().getSelectedItem();
        if (selectedContact != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Rimuovi definitivamente");
            alert.setHeaderText("Sei sicuro di voler eliminare definitivamente il contatto?");
            alert.setContentText("L'operazione è irreversibile.");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                bin.deleteContactPermanently(selectedContact, contactBook);
                observableBin.remove(selectedContact);
                observableContacts.remove(selectedContact);
                TableBook.refresh();
                TableBin.refresh();
            }
        }
    }

    @FXML
    private void onFavButton(ActionEvent event) {
    List<Contact> favoriteContacts = contactBook.displayFavorites();


    ObservableList<Contact> favoriteObservableContacts = FXCollections.observableArrayList(favoriteContacts);


    TableBook.setItems(favoriteObservableContacts);
    }

    @FXML
    private void onRemoveFromEL(ActionEvent event) {
        Contact selectedContact = TableBook.getSelectionModel().getSelectedItem();
        if (selectedContact != null) 
            if (emergencyList.getContacts().contains(selectedContact)) {
            emergencyList.removeContact(selectedContact);
            observableEL.setAll(emergencyList.getContacts());
        }
            
    }

    @FXML
    private void onContactBookButton(ActionEvent event) {
        TableBook.setItems(observableContacts);
    }

}
