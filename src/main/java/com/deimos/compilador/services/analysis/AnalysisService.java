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
package com.deimos.compilador.services.analysis;

import com.deimos.compilador.model.errors.CompilationError;
import com.deimos.compilador.model.errors.ErrorType;
import com.deimos.compilador.services.ErrorHandlerService;
import java.io.StringReader;
import java.util.List;
import java.util.logging.Level;
import lombok.extern.java.Log;

/**
 *
 * Starts the Lexical and Syntax Analysis
 * 
 * @author Deimos
 */
@Log
public class AnalysisService {
    
    private static final String PARSER_FAIL_ERROR_CODE = "000";
    
    public void start(String code){   
        
        // Inicializa los analizadores sintáctico y léxico
        try {
            Syntax s = new Syntax(new LexerCup(new StringReader(code)));

            // Ejecuta el analizador sintáctico y léxico
            log.info("Iniciando el analisis\n");
            s.parse();
        } catch (NoClassDefFoundError | Exception e) {
            
            // Si no encuentra ninguna gramatica válida, se agrega el error de parseo
            log.log(Level.SEVERE, "{0}\n", e.toString());
            
            List<CompilationError> errors = ErrorHandlerService.compilationErrors.getErrors();
            CompilationError syntaxError = new CompilationError(PARSER_FAIL_ERROR_CODE, "An Exception Ocurred", "FATAL", ErrorType.FATAL, 1);
            errors.add(syntaxError);
        }
    }  
}
