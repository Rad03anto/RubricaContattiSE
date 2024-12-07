/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruppo23.phonebook.exceptions;

/**
 *
 * @authors Antonio Radesca, Luca Nazzaro, Alessandro Scandone, Michele Savino
 */
public class InvalidContactException extends Exception {

    /**
     * Creates a new instance of <code>EmptyFieldException</code> without detail
     * message.
     */
    public InvalidContactException() {
    }

    /**
     * Constructs an instance of <code>EmptyFieldException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidContactException(String msg) {
        super(msg);
    }
}