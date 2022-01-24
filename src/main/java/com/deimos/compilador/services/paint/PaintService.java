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
package com.deimos.compilador.services.paint;

import com.deimos.compilador.utils.CollectionUtils;
import com.deimos.compilador.model.painter.PaintRequest;
import com.deimos.compilador.model.painter.PaintRequests;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 * 
 * Obtiene las solicitodes para pintar (paintRequests) y pinta las palabras solicitadas.
 * Clase basada en el trabajo de Yisus. Creditos para YisusFBI.
 * 
 * @author Deimos
 */
public class PaintService {

    public static final String CLASS_NAME = PaintService.class.getName();
    public static final String LEXER_PAINTER_EXCEPTION_MESSAGE = "An error ocurred while matching words to paint";
    
    public static PaintRequests paintRequestList;
    
    /**
     * 
     * Inicia el proceso de pintar palabras
     * 
     * @param jTextPane donde se pintaran las palabras
     */
    public static void start(JTextPane jTextPane){
        try {
            paintRequestList = new PaintRequests();
            paintRequestList.setPaintRequests(new ArrayList<>());
            
            LexerPainter lexerPainter = new LexerPainter(new StringReader(jTextPane.getText()));
            while(true)
                if(lexerPainter.yylex() == null)
                    break;
            if(paintRequestList != null){
                paint(paintRequestList, jTextPane);
            }
        } catch (IOException ex) {
            Logger.getLogger(CLASS_NAME).log(Level.SEVERE, LEXER_PAINTER_EXCEPTION_MESSAGE);
        }
    }
    
    /**
    *
    * Pinta las palabras en las solicitudes de pintura (paintRequests)
    * 
    * @param paintRequests the words that are going to be painted
    * @param jTextPane where the words are going to be painted
    */
    private static void paint(PaintRequests paintRequestList, JTextPane jTextPane){
        if(CollectionUtils.isNotEmpty(paintRequestList.getPaintRequests())){
            List<PaintRequest> paintRequests = paintRequestList.getPaintRequests();
            StyledDocument style = jTextPane.getStyledDocument();
            StyleContext cont = StyleContext.getDefaultStyleContext();
            
            paintRequests.forEach(paintRequest -> setCharacterAttributes(paintRequest, buildAttributeSet(paintRequest, cont), style));  
        }
    }
    
   /**
    *
    * Construye el AttributeSet
    * 
    * @param paintRequest
    * @param cont 
    */
    private static AttributeSet buildAttributeSet(PaintRequest paintRequest, StyleContext cont){
        return cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, paintRequest.getColor());
    }
    
   /**
    *
    * Define los CharacterAttributes
    * 
    * @param paintRequest
    * @param attributeSet
    * @param style 
    */
    private static void setCharacterAttributes(PaintRequest paintRequest, AttributeSet attributeSet, StyledDocument style){
        style.setCharacterAttributes(paintRequest.getPosIni(), paintRequest.getPosFin(), attributeSet, true);
    }
}
