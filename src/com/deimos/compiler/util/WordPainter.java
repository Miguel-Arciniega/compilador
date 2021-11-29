/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deimos.compiler.util;

import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 *
 * @author arcin
 */
public class WordPainter {
    public void paint(ArrayList<PaintRequest> textoC, JTextPane jTextPane){
        StyledDocument style = jTextPane.getStyledDocument();
        StyleContext cont = StyleContext.getDefaultStyleContext();
        AttributeSet colorExp;

        for(int i=0; i<textoC.size(); i++){
            colorExp = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, textoC.get(i).getColor());
            style.setCharacterAttributes(textoC.get(i).getPosini(), textoC.get(i).getPosfin(), colorExp, true);
        }
    }
}
