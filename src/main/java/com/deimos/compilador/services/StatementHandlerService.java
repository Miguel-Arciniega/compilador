/*
 * The MIT License
 *
 * Copyright 2022 Deimos.
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
package com.deimos.compilador.services;

import com.deimos.compilador.model.errors.statement.Statement;
import com.deimos.compilador.model.errors.statement.StatementType;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Deimos
 */
public class StatementHandlerService {
    
    public static Statement save(final String statementString, int line){
        
        ArrayList<String> words = new ArrayList<>();
        
        
        // A�ade todas las palabras de una sentencia
        words.addAll(Arrays.asList(statementString.split(" ")));
        
        if(words.contains("INT") | words.contains("STRING") | words.contains("FLOAT")){
            return new Statement(StatementType.DELCARATION, words, line);        
        }
        
        return null;
    }
}
