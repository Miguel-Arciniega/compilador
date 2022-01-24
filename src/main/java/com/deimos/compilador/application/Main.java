/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deimos.compilador.application;

import java.util.Locale;
import lombok.extern.java.Log;

/**
 *
 * @author Deimos
 */
@Log
public class Main {
        
    /**
     * Corre el Compilador
     * 
     * @param args argumentos de la linea de comandos
     */
    public static void main(String args[]) {
        
        Locale.setDefault(new Locale("en", "EN"));
        
        Compilador compilador = new Compilador();

        try {
            log.info("Iniciando la aplicacion\n");
            compilador.start();
        } catch (InterruptedException ex) {
            log.severe("Error al iniciar la aplicacion\n");
        }
    }   
}
