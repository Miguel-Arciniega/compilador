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

import java.rmi.UnexpectedException;

/**
 * 
 * Creates LookAndFeel objects
 * 
 * @author Deimos
 */
public class LookAndFeelFactory {
    
    private static final String UNEXPECTED_THEME_EXCEPTION_MESSAGE = "Unexpected Theme";
    
    /**
     * Returns LookAndFeel object
     * 
     * @throws UnexpectedException throws when theme is null
     * @param theme  theme enum to filter LookAndFeel generation
     * @return LookAndFeel
     */
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
