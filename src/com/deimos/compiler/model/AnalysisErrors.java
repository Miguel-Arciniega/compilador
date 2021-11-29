/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deimos.compiler.model;

import java.util.ArrayList;

/**
 *
 * @author arcin
 */
public class AnalysisErrors {
    private ArrayList<String> lexicalErrors;
    private ArrayList<String> sintaxErrors;
    private ArrayList<String> semanticlErrors;

    public ArrayList<String> getLexicalErrors() {
        return lexicalErrors;
    }

    public void setLexicalErrors(ArrayList<String> lexicalErrors) {
        this.lexicalErrors = lexicalErrors;
    }

    public ArrayList<String> getSintaxErrors() {
        return sintaxErrors;
    }

    public void setSintaxErrors(ArrayList<String> sintaxErrors) {
        this.sintaxErrors = sintaxErrors;
    }

    public ArrayList<String> getSemanticlErrors() {
        return semanticlErrors;
    }

    public void setSemanticlErrors(ArrayList<String> semanticlErrors) {
        this.semanticlErrors = semanticlErrors;
    }
}
