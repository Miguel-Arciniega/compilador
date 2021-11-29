/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deimos.compiler.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arcin
 */
public class FileHandler {
   
    private static final String CLASS_NAME = FileHandler.class.getName();
    private static final String FILE_NOT_FOUND_EXCEPTION_MESSAGE = "File not found";
    private final File file;
    private final File folder;
    
    public FileHandler(String name, String route){        
        this.file = new File(route + "\\" + name);
        this.folder = new File(route);
    }
    
    public void write(String content) {
        try{
            if(!this.file.exists()){
                this.folder.mkdir();
                this.file.createNewFile();
            }

            FileWriter fw = new FileWriter(this.file);
            try (BufferedWriter bufferedWriter = new BufferedWriter(fw)) {
                bufferedWriter.write(content);
            }
        }catch(IOException ex) {
            Logger.getLogger(CLASS_NAME).log(Level.SEVERE, FILE_NOT_FOUND_EXCEPTION_MESSAGE, ex);
        }
    }
    
    public String read() {
        String content;
        String newContent = "";
        try{
            if(!this.file.exists()){
                this.folder.mkdir();
                this.file.createNewFile();
            }

            BufferedReader bf = new BufferedReader(new FileReader(this.file));

            while ((content = bf.readLine())!=null) {
                newContent += content;
            }
        }catch(IOException ex){
            Logger.getLogger(CLASS_NAME).log(Level.SEVERE, FILE_NOT_FOUND_EXCEPTION_MESSAGE, ex);
        }
        return newContent;
    }
    
    public boolean fileExist(){
        return this.file.exists();
    }
    
}
