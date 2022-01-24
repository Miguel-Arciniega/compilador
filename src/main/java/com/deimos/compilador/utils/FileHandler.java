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
package com.deimos.compilador.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;
import lombok.Data;

/**
 * 
 * Provides a FileHandler class that manages Folder and File creation
 * As well as File Reading and Writing
 * 
 * @author Deimos
 */
@Data
public class FileHandler {
   
    private static final String CLASS_NAME = FileHandler.class.getName();
    private static final String FILE_NOT_FOUND_EXCEPTION_MESSAGE = "File not found";
    private static final String DEFAULT_FILE = "newFile.txt";
    
    private static final String USER_DOCUMENTS_FOLDER = FileSystemView
                                                            .getFileSystemView()
                                                            .getDefaultDirectory()
                                                            .getPath();
    
    private static final String PROJECT_FOLDER = "\\CompilerProjects";
    private static final File COMPILER_FOLDER = new File(USER_DOCUMENTS_FOLDER.concat(PROJECT_FOLDER));
    private final File file;
    private final File folder;
    
    public FileHandler(String file, String folder){        
        this.file = new File(folder.concat("\\").concat(file));
        this.folder = new File(folder);
        
        if(!this.folder.exists()){
            this.folder.mkdirs();
        }
    }
    
    public FileHandler(String folder){        
        this.file = new File(folder.concat("\\").concat(DEFAULT_FILE));
        this.folder = new File(folder);
        
        if(!this.folder.exists()){
            this.folder.mkdirs();
        }
    }
    
    public void write(String content) {
        try{
            if(!this.file.exists()){
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
    
    public boolean folderExist(){
        return this.folder.exists();
    }
    
}
