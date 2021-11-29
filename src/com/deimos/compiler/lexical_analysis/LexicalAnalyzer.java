/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deimos.compiler.lexical_analysis;

import com.deimos.compiler.exceptions.UnexpectedTokenException;
import com.deimos.compiler.model.AnalysisErrors;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author arcin
 */
public class LexicalAnalyzer {

    private static final String CLASS_NAME = LexicalAnalyzer.class.getName();
    private static final String FILE_NOT_FOUND_EXCEPTION_MESSAGE = "File not found";
    private static final String UNEXPECTED_TOKEN_EXCEPTION_MESSAGE = "Unexpected Token";
    private static final String FILE_NAME = "code.txt";

    public AnalysisErrors start(AnalysisErrors analysisErrors, String code){   
       
        ArrayList<String> errores = new ArrayList<>();
        analysisErrors.setLexicalErrors(errores);
        
        File archivo = new File(FILE_NAME);
        PrintWriter escribir;
        
        try {
            escribir = new PrintWriter(archivo);
            escribir.print(code);
            escribir.close();
            Reader lector = new BufferedReader(new FileReader(FILE_NAME));
            Lexer lexer = new Lexer(lector);
            
            while (true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    break;
                }
                switch (tokens) {
                    case ERROR:
                        errores.add("Simbolo no definido -> " + lexer.lexeme);
                        break;
                    case Identificador: 
                    case Numero: 
                    case Reservadas:
                    case Igual:
                    case Suma:
                    case Resta:
                    case Multiplicacion:
                    case Division:
                        break;
                    default:
                        throw new UnexpectedTokenException(UNEXPECTED_TOKEN_EXCEPTION_MESSAGE);
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(CLASS_NAME).log(Level.SEVERE, FILE_NOT_FOUND_EXCEPTION_MESSAGE , ex);
        } catch (UnexpectedTokenException ex) {
            Logger.getLogger(CLASS_NAME).log(Level.SEVERE, UNEXPECTED_TOKEN_EXCEPTION_MESSAGE , ex);
        }
        return analysisErrors;
    }  
}
