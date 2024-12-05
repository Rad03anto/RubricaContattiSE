/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruppo23.rubricacontattiproject.phonebook.exceptions;

/**
 *
 * @author anton
 */
public class InvalidGroupException extends Exception {

    /**
     * Creates a new instance of <code>InvalidGroupException</code> without
     * detail message.
     */
    public InvalidGroupException() {
    }

    /**
     * Constructs an instance of <code>InvalidGroupException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidGroupException(String msg) {
        super(msg);
    }
}
