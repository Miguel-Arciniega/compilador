/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deimos.compilador.application;

import com.deimos.compilador.services.analysis.AnalysisGenerator;
import com.deimos.compilador.view.CompiladorUI;
import lombok.extern.java.Log;

/**
 *
 * @author Deimos
 */
@Log 
public class Compilador {

    /**
     * Inicia el Compilador
     */
    public void start() throws InterruptedException {
        
        // Genera las clases para el anlyisis
        log.info("Creando clases necesarias: \n");
        AnalysisGenerator.main();
        
        // Espera a que las clases se creen
        Thread.sleep(3000);
        System.out.print("\n");
        
        // Inicializa el Frame
        CompiladorUI compilador = new CompiladorUI();
        log.info("Iniciando compilador\n");
        
        // Crea y despliega el Frame
        java.awt.EventQueue.invokeLater(() -> {
            compilador.setVisible(true);
        });
    }   
}
