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
package com.deimos.compilador.services.analysis;

import com.deimos.compilador.model.errors.CompilationError;
import com.deimos.compilador.model.errors.ErrorType;
import com.deimos.compilador.services.ErrorHandlerService;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Deimos
 */
public class VariableHandler {
    
    public static final HashMap<String, String> variables = new HashMap<>();
    
    public static void validate(String variableId, String value, int line){
        if(variables == null || variables.isEmpty()){
           variables.put(variableId, value); 
        }else{
            if(variables.containsKey(variableId)){
                List<CompilationError> errors = ErrorHandlerService.compilationErrors.getErrors();
                CompilationError semanticError = new CompilationError("019", "The variable " + variableId + " has already been declared", ErrorType.SEMANTIC, line);
                errors.add(semanticError);
            }else{
                variables.put(variableId, value);
            }
        }
    }
    
    public static void validateId(String variableId, int line){
        if (variables != null) {
            if(!variables.containsKey(variableId) && !"OUTPUT".equals(variableId)){
                List<CompilationError> errors = ErrorHandlerService.compilationErrors.getErrors();
                CompilationError semanticError = new CompilationError("020", "The variable " + variableId + " has not been declared", ErrorType.SEMANTIC, line);
                errors.add(semanticError); 
            }   
        }
    }
}
