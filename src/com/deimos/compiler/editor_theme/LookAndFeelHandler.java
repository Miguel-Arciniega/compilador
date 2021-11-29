/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deimos.compiler.editor_theme;

import com.deimos.compiler.util.FileHandler;
import com.deimos.compiler.exceptions.UnexpectedThemeException;
import com.deimos.compiler.view.Compilador;
import java.io.IOException;
import java.rmi.UnexpectedException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JFrame;

/**
 *
 * @author arcin
 */
public class LookAndFeelHandler {
       
        private static final String WORK_FOLDER_PATH = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\Compiler";
        private static final String UNEXPECTED_THEME_EXCEPTION_MESSAGE = "Unexpected Theme";
        private static final String CLASS_NAME = Compilador.class.getName();
        private static final String FILE_NAME = "lookandfeel.txt";
        
        private final FileHandler fileHandler = new FileHandler(FILE_NAME, WORK_FOLDER_PATH);
        private final JFrame frame;
        
        public LookAndFeelHandler(JFrame frame){      
            this.frame = frame;
        }
        
        public void setLookAndFeel() {
            try{
                String fileContent = Optional.ofNullable(fileHandler.read()).orElse(""); 
                if(!fileHandler.fileExist() || fileContent.isEmpty()){
                    fileHandler.write("MATERIAL LIGHT");
                }
                
                switch (fileContent) {
                    case "MATERIAL DARK":
                        new LookAndFeelFactory().getLookAndFeel(Theme.MATERIAL_DARK).execute(this.frame);    
                        break;
                    case "MATERIAL LIGHT":
                        new LookAndFeelFactory().getLookAndFeel(Theme.MATERIAL_LIGHT).execute(this.frame);    
                        break;
                    case "ONE DARK":
                        new LookAndFeelFactory().getLookAndFeel(Theme.ONE_DARK).execute(this.frame);    
                        break;
                    case "MONOKAI":
                        new LookAndFeelFactory().getLookAndFeel(Theme.MONOKAI).execute(this.frame);    
                        break;
                    case "MOONLIGHT":
                        new LookAndFeelFactory().getLookAndFeel(Theme.MOONLIGHT).execute(this.frame);    
                        break;
                    default:
                        throw new UnexpectedThemeException(UNEXPECTED_THEME_EXCEPTION_MESSAGE);
                }     
               
            }catch (UnexpectedThemeException | UnexpectedException ex){
                Logger.getLogger(CLASS_NAME).log(Level.SEVERE, UNEXPECTED_THEME_EXCEPTION_MESSAGE, ex);
            }
        }                 
}
