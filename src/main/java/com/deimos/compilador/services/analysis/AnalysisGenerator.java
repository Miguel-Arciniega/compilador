/*
 * The MIT License
 *
 * Copyright 2021 Deimos.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.deimos.compilador.services.analysis;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.java.Log;

import static com.deimos.compilador.utils.StringConstants.ANALYSIS_DIRECTORY;
import static com.deimos.compilador.utils.StringConstants.PROJECT_DIRECTORY;
import static com.deimos.compilador.utils.StringConstants.UTIL_EDITOR_DIRECTORY;

/**
 *
 * Generates Necessary Classes to Run Analysis Fase of Compilation
 * 
 * @author Deimos
 */
@Log
public class AnalysisGenerator {
    
    private static final String LEXER_CUP_FLEX_IN_ANALISYS = ANALYSIS_DIRECTORY + "LexerCup.flex";
    private static final String LEXER_PAINTER_FLEX_IN_UTIL = UTIL_EDITOR_DIRECTORY + "LexerPainter.flex";
    
    private static final String SYM_JAVA_IN_PROJECT = PROJECT_DIRECTORY + "sym.java";
    private static final String SINTAX_JAVA_IN_PROJECT = PROJECT_DIRECTORY + "Syntax.java";
    
    private static final String SINTAX_CUP_IN_ANALISYS = ANALYSIS_DIRECTORY + "Syntax.cup";
    private static final String SYM_JAVA_IN_ANALISYS = ANALYSIS_DIRECTORY + "sym.java";
    private static final String SINTAX_JAVA_IN_ANALISYS = ANALYSIS_DIRECTORY + "Syntax.java";
    
    private static final String FILE_NOT_FOUND_EXCEPTION_MESSAGE = "No se pudo encontrar el archivo";
    private static final String JCUP_GENERATION_EXCEPTION_MESSAGE = "Se produjo un error mientras se generaba el analizador sintáctico";

    /**
     * 
     * Crea las classes necesarias para la fase de analisis léxico
     * 
     */
    private static void createClassesLexer(){        
        File archivo;
        
        archivo = new File(LEXER_CUP_FLEX_IN_ANALISYS);
        JFlex.Main.generate(archivo);
        
        archivo = new File(LEXER_PAINTER_FLEX_IN_UTIL);
        JFlex.Main.generate(archivo);
    }

    /**
     * 
     * Crea las classes necesarias para la fase de analisis sintáctico
     * 
     */
    private static void createClassesSyntax(){
        createFiles();
        moveFiles();
    }
    
    /**
     * 
     * Crea los archivos de sym.java y syntax.java
     * 
     */
    private static void createFiles(){
        final String[] javaCupArgs = {"-parser", "Syntax", SINTAX_CUP_IN_ANALISYS};

        try {
            java_cup.Main.main(javaCupArgs);
        } catch (IOException ex) {
            log.severe(FILE_NOT_FOUND_EXCEPTION_MESSAGE);
        } catch (Exception ex) {
            log.severe(JCUP_GENERATION_EXCEPTION_MESSAGE);
        }  
    }
    
    /**
     * 
     * Mueve los arhivos a la carpeta de analysis
     * 
     */
    private static void moveFiles(){
        
        final Path sintaxJavaInAnalysisFile = Paths.get(SINTAX_JAVA_IN_ANALISYS);
        final Path sintaxJavaInProjectFile = Paths.get(SINTAX_JAVA_IN_PROJECT);
        final Path symJavaInAnalysisFile = Paths.get(SYM_JAVA_IN_ANALISYS);
        final Path symJavaInProjectFile = Paths.get(SYM_JAVA_IN_PROJECT);
        
        try{
            // Si ya hay un archivo sym.java en la carpeta de analysis, se borra
            if (Files.exists(symJavaInAnalysisFile)) {
                Files.delete(symJavaInAnalysisFile);
            }
            /**
             * Mueve el archivo sym.java generado en la carpeta del projecto a
             * la carpeta de analysis
             */
            Files.move(symJavaInProjectFile, symJavaInAnalysisFile);
        }catch(IOException ex){
            log.severe(FILE_NOT_FOUND_EXCEPTION_MESSAGE);
        }
        
        try{
            // Si ya hay un archivo Syntax.java en la carpeta de analysis, se borra
            if (Files.exists(sintaxJavaInAnalysisFile)) {
                Files.delete(sintaxJavaInAnalysisFile);
            }
            
            /**
             * Mueve el archivo Syntax.java generado en la carpeta del projecto a
             * la carpeta de analysis
             */
            Files.move(sintaxJavaInProjectFile, sintaxJavaInAnalysisFile);
        }catch(IOException ex){
            log.severe(FILE_NOT_FOUND_EXCEPTION_MESSAGE);
        }
        
    }
    
    /**
     * 
     * Crea las classes necesarias para la fase de analisis
     * 
     */
    public static void main(String... args) {
        createClassesLexer();
        createClassesSyntax();
    }
}