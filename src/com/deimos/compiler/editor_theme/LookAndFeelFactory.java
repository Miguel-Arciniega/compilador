/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deimos.compiler.editor_theme;

import java.rmi.UnexpectedException;

/**
 *
 * @author arcin
 */
public class LookAndFeelFactory {
    
    private static final String UNEXPECTED_THEME_EXCEPTION_MESSAGE = "Unexpected Theme";
    
    public LookAndFeel getLookAndFeel(Theme theme) throws UnexpectedException{
        switch (theme) {
            case MATERIAL_LIGHT:
                return new MaterialLight();
            case MATERIAL_DARK:
                return new MaterialDark();
            case ONE_DARK:
                return new OneDark();
            case MONOKAI:
                return new Monokai();
            case MOONLIGHT:
                return new Moonlight();
            default:
                throw new UnexpectedException(UNEXPECTED_THEME_EXCEPTION_MESSAGE);
        }
    }
}
