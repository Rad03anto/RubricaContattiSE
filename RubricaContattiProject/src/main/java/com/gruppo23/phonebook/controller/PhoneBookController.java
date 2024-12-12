/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruppo23.phonebook.controller;

import com.gruppo23.phonebook.model.EmergencyList;
import com.gruppo23.phonebook.exceptions.FullGroupException;
import com.gruppo23.phonebook.model.Bin;
import com.gruppo23.phonebook.model.Contact;
import com.gruppo23.phonebook.model.ContactBook;
import com.gruppo23.phonebook.model.PhoneBook;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    private Button MoveToBinButton;
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
    private Button RestoreButton;
    @FXML
    private Button RemoveBinButton;
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
    private PhoneBook phonebook;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        contactBook = new ContactBook();
        emergencyList = new EmergencyList();
        observableContacts = FXCollections.observableArrayList(contactBook.getContacts());
        observableEL = FXCollections.observableArrayList(emergencyList.getContacts());
        nameClm.setCellValueFactory(new PropertyValueFactory("name"));
        surnameClm.setCellValueFactory(new PropertyValueFactory("surname"));
        nameClm1.setCellValueFactory(new PropertyValueFactory("name"));
        surnameClm1.setCellValueFactory(new PropertyValueFactory("surname"));
        
        TableBook.setItems(observableContacts);
        TableEL.setItems(observableEL);
        
    }
    
    @FXML
    private void handleCreateButtonAction(ActionEvent event) {
        ContactView.setVisible(false);
        TableBook.setVisible(false);
        CreateForm.setVisible(true);
    }

    @FXML
    private void onSaveContactButton(ActionEvent event) {
        
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
            observableContacts.add(newContact);
        } catch (FullGroupException ex) {
            Logger.getLogger(PhoneBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CreateForm.setVisible(false);
        TableBook.setVisible(true);
    }

    @FXML
    private void onAddToELButton(ActionEvent event) throws FullGroupException {
         Contact selectedContact = TableBook.getSelectionModel().getSelectedItem();
         if(selectedContact!=null){
             contactBook.moveToEmergencyList(selectedContact, emergencyList);
             observableEL.add(selectedContact);
             
             }
            
    }
    
    @FXML
    private void onDisplayContactButton(ActionEvent event) {
        Contact selectedContact = TableBook.getSelectionModel().getSelectedItem();
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

    @FXML
    private void onImportFile(ActionEvent event) {

        // Crea un oggetto FileChooser per permettere all'utente di selezionare il file CSV
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        
        // Ottieni il riferimento alla finestra principale
        Stage stage = (Stage) ImportButton.getScene().getWindow();
        
        // Mostra la finestra di dialogo per aprire il file e ottieni il file selezionato
        File file = fileChooser.showOpenDialog(stage);
        
        // Se l'utente ha selezionato un file
        if (file != null) {
            try {
                // Chiamata al metodo loadFromFile della classe PhoneBook
                PhoneBook phonebook = PhoneBook.loadFromFile(file.getAbsolutePath());
                
                // Qui puoi aggiornare la tua UI con i contatti importati
                // Per esempio, se usi una ListView per visualizzare i contatti:
                // contactListView.setItems(FXCollections.observableArrayList(phonebook.getContacts()));

                showSuccessMessage("Rubrica importata correttamente.");
            } catch (FullGroupException e) {
                // Gestisci eventuali errori di lettura del file
                showErrorMessage("Errore durante l'importazione della rubrica.");
            }
        }
    }
    // Metodo per mostrare un messaggio di successo


    // Metodo per mostrare un messaggio di errore
    private void showErrorMessage(String message) {
        Alert alert = new Alert(AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }

    @FXML
    private void onExportButton(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
    Stage stage = (Stage) ExportButton.getScene().getWindow();
    File file = fileChooser.showSaveDialog(stage);

    if (file != null) {
        // Chiama il metodo saveToFile per salvare i contatti nel file selezionato
        try{
            phonebook.saveToFile(file.getAbsolutePath());
        showSuccessMessage("Rubrica salvata correttamente.");
    } catch (Exception e) {
            showErrorMessage("Errore nel salvataggio della rubrica.");
        }
    }

}

// Metodo per mostrare un messaggio di successo
private void showSuccessMessage(String message) {
    Alert alert = new Alert(AlertType.INFORMATION, message, ButtonType.OK);
    alert.showAndWait();
}


    }


    

