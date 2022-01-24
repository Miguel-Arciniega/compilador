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
package com.deimos.compilador.utils.editor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileFilter;
import com.deimos.compilador.utils.FileHandler;
import com.deimos.compilador.services.paint.PaintService;

import static com.deimos.compilador.utils.StringConstants.EMPTY;
import static com.deimos.compilador.utils.StringConstants.EXTENSION;
import static com.deimos.compilador.utils.StringConstants.FILE_TYPE_NAME;
import static com.deimos.compilador.utils.StringConstants.PROJECT_FOLDER;
import static com.deimos.compilador.utils.StringConstants.PROJECT_WORKSPACE;
import static com.deimos.compilador.utils.StringConstants.USER_DOCUMENTS_FOLDER;

/**
 * Provides Static Methods Needed to handle file operations
 * @author Deimos
 */
public class CodeEditorUtils {
    
    /**
     *
     */
    public static JFrame jFrame;

    /**
     *
     */
    public static JTextPane jTextPaneEditor;

    /**
     *
     */
    public static JTextPane jTextPaneConsole;
    
    /**
     *
     */
    public static File currentFile;

    /**
     *
     */
    public static FileHandler fileHandler;
    
            
    /**
     *
     */
    public static boolean hasChanged = false;
    
    /**
     *
     */
    public static FileFilter textFileFilter = new FileFilter() {
 
        @Override
        public boolean accept(File file) {
            return file.isDirectory() || file.getName().toLowerCase().endsWith(EXTENSION);
        }
 
        @Override
        public String getDescription() {
            return "Archivos ".concat(FILE_TYPE_NAME);
        }
    };
    
    /**
     *
     * getJFileChooser
     * @param 
     * @return jFileChooser
     * 
     */
    private static JFileChooser getJFileChooser() {
        
        StringBuilder path = new StringBuilder();
        
        path.append(USER_DOCUMENTS_FOLDER)
                .append(PROJECT_FOLDER)
                .append(PROJECT_WORKSPACE);
        fileHandler = new FileHandler(path.toString());
        
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(fileHandler.getFolder());
        jFileChooser.setDialogTitle(FILE_TYPE_NAME.concat(" - Abrir archivo:"));          
        jFileChooser.setMultiSelectionEnabled(false);                    
        jFileChooser.setFileFilter(textFileFilter);  
        jFileChooser.setFileSelectionMode(jFileChooser.FILES_ONLY);
        
        return jFileChooser;    
    }
    
    /**
     *
     * Save File As
     * 
     */
    public static void actionSaveAs() {
        JFileChooser fileChooser = getJFileChooser();
        fileChooser.setDialogTitle(FILE_TYPE_NAME.concat(" - Guardar como:"));
        fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
 
        int state = fileChooser.showSaveDialog(jFrame);
        if (state == JFileChooser.APPROVE_OPTION) { 
            File file = fileChooser.getSelectedFile();  
 
            try {
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                    jTextPaneEditor.write(bufferedWriter);
                }   
 
                jFrame.setTitle(FILE_TYPE_NAME.concat(" - ").concat(file.getName()));
                currentFile = file;

                hasChanged = false;
            } catch (IOException ex) {    
                JOptionPane.showMessageDialog(jFrame,
                                              ex.getMessage(),
                                              ex.toString(),
                                              JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     *
     * Save File     */
    public static void actionSave() {       
         if (currentFile == null) {   
            actionSaveAs();   
        } else if (hasChanged == true) {    
            BufferedWriter bw;
            File file = currentFile;
            try {
                bw = new BufferedWriter(new FileWriter(file));
                jTextPaneEditor.write(bw);
                bw.close();   
                hasChanged = false;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(jFrame,
                                            ex.getMessage(),
                                            ex.toString(),
                                            JOptionPane.ERROR_MESSAGE);
            }
        }       
    }
    
    /**
     *
     * Open File     */
    public static void actionOpen() {
        if (hasChanged == true) {
            int option = JOptionPane.showConfirmDialog(jFrame, "¿Desea guardar los cambios?");
 
            switch (option) {
                case JOptionPane.YES_OPTION:     
                    actionSave();               
                    break;
                case JOptionPane.CANCEL_OPTION: 
                    return;    
            }           
        }       
 
        JFileChooser fileChooser = getJFileChooser(); 
 
        int state = fileChooser.showOpenDialog(jFrame);
        String content, newContent;
        
        if (state == JFileChooser.APPROVE_OPTION) {  
            File file = fileChooser.getSelectedFile();    
            if (!(file.getName().endsWith(EXTENSION))) {
                JOptionPane.showMessageDialog(null, "Solo los archivos con extensión ".concat(EXTENSION).concat(" son admitidos"));
                actionOpen();
                return;
            }
            try {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                    newContent = bufferedReader.readLine();
                    
                    while ((content = bufferedReader.readLine()) != null) {
                        newContent = newContent + "\n" + content;
                    }
                    
                    jTextPaneEditor.setText(newContent);
                    PaintService.start(jTextPaneEditor);
                }
 
                jFrame.setTitle(FILE_TYPE_NAME + " - " + file.getName());
 
                currentFile = file;
                hasChanged = false;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(jFrame,
                                              ex.getMessage(),
                                              ex.toString(),
                                              JOptionPane.ERROR_MESSAGE);
            }
        }       
    }
    
        /**
     *
     * Open File     */
    public static void actionOpenFolder() {
        if (hasChanged == true) {
            int option = JOptionPane.showConfirmDialog(jFrame, "¿Desea guardar los cambios?");
 
            switch (option) {
                case JOptionPane.YES_OPTION:     
                    actionSave();               
                    break;
                case JOptionPane.CANCEL_OPTION: 
                    return;    
            }           
        }       
 
        JFileChooser fileChooser = getJFileChooser(); 
 
        int state = fileChooser.showOpenDialog(jFrame);
        String content, newContent;
        
        if (state == JFileChooser.APPROVE_OPTION) {  
            File file = fileChooser.getSelectedFile();    
            if (!(file.getName().endsWith(EXTENSION))) {
                JOptionPane.showMessageDialog(null, "Solo los archivos con extensión ".concat(EXTENSION).concat(" son admitidos"));
                actionOpen();
                return;
            }
            try {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                    newContent = bufferedReader.readLine();
                    
                    while ((content = bufferedReader.readLine()) != null) {
                        newContent = newContent + "\n" + content;
                    }
                    
                    jTextPaneEditor.setText(newContent);
                }
 
                jFrame.setTitle(FILE_TYPE_NAME.concat(" - ").concat(file.getName()));
 
                currentFile = file;
                hasChanged = false;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(jFrame,
                                              ex.getMessage(),
                                              ex.toString(),
                                              JOptionPane.ERROR_MESSAGE);
            }
        }       
    }
    
    /**
     *
     * New File     */
    public static void actionNew() {
        if (hasChanged == true) { 
            int option = JOptionPane.showConfirmDialog(jFrame, "¿Desea guardar los cambios?");
 
            switch (option) {
                case JOptionPane.YES_OPTION:  {
                    actionSave();
                }
                break;

                case JOptionPane.CANCEL_OPTION:
                    return;
            }
        }
 
        jFrame.setTitle(FILE_TYPE_NAME.concat(" - New File").concat(EXTENSION)); 
        jTextPaneEditor.setText(EMPTY);
        currentFile = null;
        hasChanged = false;
    }  
}
