/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deimos.compiler.generate_analysis;

import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;

public class GenerateAnalysis {
    
//    private static final String CURRENT_DIRECTORY = System.getProperty("user.dir")+"\\src\\com\\deimos\\compiler\\";
    private static final String LEXICAL_DIRECTORY = System.getProperty("user.dir")+"\\src\\com\\deimos\\compiler\\lexical_analysis\\";
//    private static final String SINTAX_DIRECTORY = System.getProperty("user.dir")+"\\src\\com\\deimos\\compiler\\sintax_analysis\\";
    
    private static final String LEXER_FLEX = "Lexer.flex";
//    private static final String LEXER_CUP_FLEX = "Lexer.flex";
//    
//    private static final String SINTAX_CUP = "Sintax.cup";
//    private static final String SYM_JAVA = "Sym.java";
//    private static final String SINTAX_JAVA = "Sintax.java";
    
    public static void main(String... args) {
        String ruta1 = LEXICAL_DIRECTORY + LEXER_FLEX;
//        String ruta2 = LEXICAL_DIRECTORY + LEXER_CUP_FLEX;
//        String[] rutaS = {"-parser", "Sintax", SINTAX_DIRECTORY + SINTAX_CUP};
        generate(ruta1);
//        generate(ruta1, ruta2, rutaS);
    }
    
    public static void generate(String ruta1) {
        File archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
    }
    
//    public static void generate(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
//        File archivo;
//        archivo = new File(ruta1);
//        JFlex.Main.generate(archivo);
//        archivo = new File(ruta2);
//        JFlex.Main.generate(archivo);
//        java_cup.Main.main(rutaS);
//        
//        Path rutaSym = Paths.get(SINTAX_DIRECTORY + SYM_JAVA);
//        if (Files.exists(rutaSym)) {
//            Files.delete(rutaSym);
//        }
//        Files.move(
//                Paths.get(CURRENT_DIRECTORY + SYM_JAVA), 
//                Paths.get(SINTAX_DIRECTORY + SYM_JAVA)
//        );
//        Path rutaSin = Paths.get(SINTAX_DIRECTORY + SINTAX_JAVA);
//        if (Files.exists(rutaSin)) {
//            Files.delete(rutaSin);
//        }
//        Files.move(
//                Paths.get(CURRENT_DIRECTORY + SINTAX_JAVA), 
//                Paths.get(SINTAX_DIRECTORY + SINTAX_JAVA)
//        );
//    }
}