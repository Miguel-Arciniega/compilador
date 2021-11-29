/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deimos.compiler.editor_theme;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerContrastIJTheme;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author arcin
 */
public class MaterialDark implements LookAndFeel{
    
    @Override
    public void execute(JFrame frame){
        FlatMaterialDarkerContrastIJTheme.setup();
        SwingUtilities.updateComponentTreeUI(frame);
    }
}
