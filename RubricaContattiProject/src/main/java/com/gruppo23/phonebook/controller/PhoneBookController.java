/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruppo23.phonebook.controller;

import com.gruppo23.phonebook.exceptions.InvalidContactException;
import com.gruppo23.phonebook.model.Contact;
import com.gruppo23.phonebook.model.ContactBook;
import javafx.event.ActionEvent;
import java.net.URL;
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

    /**
     * Inizializza la classe controller.
     */
    private ContactBook contactbook;
    private ObservableList<Contact> observableContacts;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        contactbook = new ContactBook();
        observableContacts = FXCollections.observableArrayList();
        TableBook.setItems(observableContacts);   
    }
  
    @FXML
    private void handleCreateButtonAction(ActionEvent event) {
        TableBook.setVisible(false);
        CreateForm.setVisible(true);
    }
    
}
