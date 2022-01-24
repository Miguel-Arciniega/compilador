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

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JFrame;

import static com.deimos.compilador.utils.StringConstants.FILE_TYPE_NAME;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Deimos
 */
public class FontUitls {
    
    public static final int INCREASE = 0;
    public static final int DECREASE = 1;

    public static void changeFontSize(int operation, JTextPane jTextPane){
        Font consoleFont = jTextPane.getFont();

        int fontSize = consoleFont.getSize();

        switch(operation){
            case INCREASE:
                fontSize++;
                break;
            case DECREASE:
                fontSize--;
                break;
            default:
                // TODO: add custom exception
        }

        Font newFont = new Font(consoleFont.getFontName(), consoleFont.getStyle(), fontSize);

        jTextPane.setFont(newFont);
    }
        
    public static void actionSelectFont(JTextPane[] jTextPaneList, JFrame frame) {
        
        // Presenta el dialogo de selección de fuentes
        Font font = JFontChooser.showDialog(frame, FILE_TYPE_NAME + " - Fuente de letra:", jTextPaneList[0].getFont());
       
        /**
         * Si un fuente fue seleccionado
         * se establece como fuente del area de edición
         */
        if (font != null) { 
            ArrayList<JTextPane> jTextPanes = new ArrayList<>();
            Collections.addAll(jTextPanes, jTextPaneList);
            
            jTextPanes.forEach(jtextPane -> jtextPane.setFont(font)); 
        }
    }
}
