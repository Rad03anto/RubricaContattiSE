/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruppo23.phonebook.controller;

import com.gruppo23.phonebook.model.Contact;
import com.gruppo23.phonebook.model.ContactBook;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ContactBook contactBook;
    private ObservableList<Contact> observableContacts;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        contactBook = new ContactBook();
        observableContacts = FXCollections.observableArrayList();
        TableBook.setItems(observableContacts);
        
        nameClm.setCellValueFactory(new PropertyValueFactory("name"));
        surnameClm.setCellValueFactory(new PropertyValueFactory("surname"));
        
        TableBook.setItems(observableContacts);
    }
    
    @FXML
    private void handleCreateButtonAction(ActionEvent event) {
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
        contactBook.addContact(newContact);
        observableContacts.add(newContact);
        
        CreateForm.setVisible(false);
        TableBook.setVisible(true);
    }

    @FXML
    private void OnAddToELButton(ActionEvent event) {
        
    }
    
    
    
    
}
