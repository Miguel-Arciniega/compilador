/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deimos.compiler.exceptions;

/**
 *
 * @author arcin
 */
public class UnexpectedThemeException extends RuntimeException implements java.io.Serializable{
    public UnexpectedThemeException(final String message, final Throwable ex){
        super(message, ex);
    }
    public UnexpectedThemeException(final String message){
        super(message);
    }
}
