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
package com.deimos.compilador.utils;

import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Deimos
 */
public class StringConstants {
    
    // Constantes para consola
    public static final String NEW_LINE = "\n";
    public static final String BLANK_SPACE = " ";
    public static final String EMPTY = "";
    
    // Paths para el generador de analyisis
    public static final String PROJECT_DIRECTORY = System.getProperty("user.dir").concat("\\");
    public static final String ANALYSIS_DIRECTORY = PROJECT_DIRECTORY.concat("\\src\\main\\java\\com\\deimos\\compilador\\services\\analysis\\");
    public static final String UTIL_EDITOR_DIRECTORY = PROJECT_DIRECTORY.concat("\\src\\main\\java\\com\\deimos\\compilador\\services\\paint\\");
    
    // Paths del proyecto
    public static final String USER_DOCUMENTS_FOLDER = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
    public static final String PROJECT_FOLDER = "\\CompilerProjects";
    public static final String PROJECT_WORKSPACE = "\\Workspace";
    public static final String PROJECT_CONFIG = "\\Config";
    public static final String THEME_FILE = "lookandfeel.txt";
    
    // Nombre del compilador y extensi?n
    public static final String FILE_TYPE_NAME = "SHL";
    public static final String EXTENSION = ".shl";
    public static final String WINDOW_INITIAL_TITLE = FILE_TYPE_NAME + " - NewFile" + EXTENSION;
}
