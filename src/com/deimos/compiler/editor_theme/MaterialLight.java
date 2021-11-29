/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deimos.compiler.editor_theme;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubContrastIJTheme;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author arcin
 */
public class MaterialLight implements LookAndFeel{
    
    @Override
    public void execute(JFrame frame){
        FlatGitHubContrastIJTheme.setup();
        SwingUtilities.updateComponentTreeUI(frame);
    }
}
