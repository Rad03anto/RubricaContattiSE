/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruppo23.rubricacontattiproject.phonebook.exceptions;

/**
 *
 * @authors Antonio Radesca, Luca Nazzaro, Alessandro Scandone, Michele Savino
 */
public class FullGroupException extends Exception {

    /**
     * Creates a new instance of <code>FullEmergencyListException</code> without
     * detail message.
     */
    public FullGroupException() {
    }

    /**
     * Constructs an instance of <code>FullEmergencyListException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public FullGroupException(String msg) {
        super(msg);
    }
}
