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
import com.deimos.compilador.model.errors.statement.Statement;
import com.deimos.compilador.model.errors.statement.StatementType;
import com.deimos.compilador.services.ErrorHandlerService;
import com.deimos.compilador.utils.CollectionUtils;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Deimos
 */
public class SemanticAnalysis {
    
   public static List<Statement> statements; 

   public static void start(){
        if(CollectionUtils.isNotEmpty(statements)){
            validateVariables();
        }
   }
   
   private static void validateVariables(){
       
        HashMap<String, String> variables = new HashMap<>();
        List<CompilationError> errors = ErrorHandlerService.compilationErrors.getErrors();
        
        for (Statement statement : statements) {
            if(statement == null){
                continue;
            }
            if(statement.getType() == StatementType.DELCARATION){
                String identifier = statement.getContent().get(1);
                if(variables.containsKey(identifier)){
                    CompilationError semanticError =
                            new CompilationError("019", "The variable " + identifier + " has already been declared", null, ErrorType.SEMANTIC, statement.getLine());
                    errors.add(semanticError);
                    continue;
                }
                variables.put(statement.getContent().get(1), statement.getContent().get(3));
            }
        }  
   }
}
