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
package com.deimos.compilador.services.theme;

import java.awt.Color;
import java.rmi.UnexpectedException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import com.deimos.compilador.utils.editor.LinePainter;
import com.deimos.compilador.utils.FileHandler;
import com.deimos.compilador.exceptions.UnexpectedThemeException;

/**
 *
 * Handles LookAndFeel operations
 * 
 * @author Deimos
 */
public class LookAndFeelService {
       
        private static final String CLASS_NAME = Compiler.class.getName();
        private static final String UNEXPECTED_THEME_EXCEPTION_MESSAGE = "Unexpected Theme";
        
        public static final String MATERIAL_DARK = "MATERIAL DARK";
        public static final String MATERIAL_LIGHT = "MATERIAL LIGHT";
        public static final String ONE_DARK = "ONE DARK";
        public static final String MONOKAI = "MONOKAI";
        public static final String MOONLIGHT = "MOONLIGHT";
        
        private final JFrame frame;
        private final FileHandler fileHandler;
        private final JTextPane jTextPane;
        
        public LookAndFeelService(JFrame jFrame, FileHandler fileHandler, JTextPane jTextPane){      
            this.frame = jFrame;
            this.fileHandler = fileHandler;
            this.jTextPane = jTextPane;
        }
        
        public void setLookAndFeel() {
            try{
                String fileContent = Optional.ofNullable(fileHandler.read()).orElse(""); 
                if(!fileHandler.fileExist() || fileContent.isEmpty()){
                    fileHandler.write(MATERIAL_LIGHT);
                }
                
                switch (fileContent) {
                    case MATERIAL_DARK:
                        new LookAndFeelFactory().getLookAndFeel(Theme.MATERIAL_DARK).execute(this.frame);
                        new LinePainter(jTextPane).setColor(new Color(35,35,35));
                        break;
                    case MATERIAL_LIGHT:
                        new LookAndFeelFactory().getLookAndFeel(Theme.MATERIAL_LIGHT).execute(this.frame);  
                        new LinePainter(jTextPane).setColor(new Color(233, 239, 248));
                        break;
                    case ONE_DARK:
                        new LookAndFeelFactory().getLookAndFeel(Theme.ONE_DARK).execute(this.frame);
                       new LinePainter(jTextPane).setColor(new Color(50,55,75));
                        break;
                    case MONOKAI:
                        new LookAndFeelFactory().getLookAndFeel(Theme.MONOKAI).execute(this.frame);
                        new LinePainter(jTextPane).setColor(new Color(42,42,46));
                        break;
                    case MOONLIGHT:
                        new LookAndFeelFactory().getLookAndFeel(Theme.MOONLIGHT).execute(this.frame);
                        new LinePainter(jTextPane).setColor(new Color(45,45,84));
                        break;
                    default:
                        throw new UnexpectedThemeException(UNEXPECTED_THEME_EXCEPTION_MESSAGE);
                }     
               
            }catch (UnexpectedThemeException | UnexpectedException ex){
                Logger.getLogger(CLASS_NAME).log(Level.SEVERE, UNEXPECTED_THEME_EXCEPTION_MESSAGE, ex);
            }
        }                 
}
