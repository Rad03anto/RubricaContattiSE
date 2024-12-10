/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.gruppo23.phonebook.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe principale per l'applicazione PhoneBook.
 * Carica l'interfaccia grafica e avvia l'applicazione.
 */
public class PhoneBookApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carica il file FXML
        Parent root = FXMLLoader.load(getClass().getResource("/com/gruppo23/phonebook/view/PhoneBookView.fxml"));
        
        // Imposta il titolo della finestra
        primaryStage.setTitle("Phone Book Application");
        
        // Imposta la scena
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        
        // Mostra la finestra principale
        primaryStage.show();
    }

    /**
     * Metodo principale per l'esecuzione dell'applicazione.
     *
     * @param args argomenti della riga di comando
     */
    public static void main(String[] args) {
        launch(args);
    }
}
