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
package com.deimos.compilador.services;

import com.deimos.compilador.model.errors.CompilationErrors;
import com.deimos.compilador.model.errors.CompilationError;
import com.deimos.compilador.utils.CollectionUtils;
import java.util.logging.Level;
import lombok.extern.java.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.deimos.compilador.utils.StringConstants.BLANK_SPACE;
import static com.deimos.compilador.utils.StringConstants.NEW_LINE;

/**
 *
 * @author Deimos
 */
@Log
public class ErrorHandlerService {
    
    private boolean errorState = false;
    public static CompilationErrors compilationErrors;
    
    public ErrorHandlerService(final CompilationErrors compilationErrors){
        compilationErrors.setErrors(new ArrayList<>());
        this.compilationErrors = compilationErrors;
    }
    
    /**
    * 
    * @return error
    */
    public boolean error(){
        return this.errorState;
    }
    
    /**
    * 
    * Starts the error handler service and returns console output
    * 
    * @param compilationErrors POJO that has the errors
    * @return output
    */
    public StringBuilder start(final String code){
        
        // Se incializa la salida de consola
        StringBuilder output = new StringBuilder();     
        
        // Si hay errores se pone la bandera de error en true
        if(CollectionUtils.isNotEmpty(compilationErrors.getErrors())){
            this.errorState = true;
        }
        
        // Si hay errores, se processan
        if(this.errorState){
            StringBuilder errores =  new StringBuilder();
            
            // Se inicializa la lista de errores
            List<CompilationError> errors = compilationErrors.getErrors();
            
            // Se ordenan los errores
            int begin = 0;
            int end = errors.size()-1;

            CollectionUtils.errorQuickSort(errors, begin, end);
            
            /** 
             * Se obtienen las lineas de c?digo separadas por salto de linea
             * Y se eliminan los espacios de m?s 
             */
            List<String> codeLines = Arrays.asList(code.split("\\s*\n\\s*"));

            /** 
             * Se coloca el contenido de la linea de c?digo correspondiente en 
             * el contenido de los errores que no sean lexicos o fatales.
             */
            errors.forEach(error -> { 
                if(error.getErrorContent() == null){
                    error.setErrorContent(codeLines.get(error.getErrorLine()-1));
                }
                error.setErrorContent(error.getErrorContent().trim());
                error.setErrorContent(error.getErrorContent().replaceAll("\n", ""));
                errores.append(error.toString());
                errores.append(NEW_LINE);
            });
            
            /** 
             * Se agregan los mensajes errores los errores y se agrega
             * el mensaje de compilacion fallida  a la salida de consola
             */       
            int errorCount = errors.size();
            
            if(errorCount > 1){
                log.log(Level.WARNING, "Compilacion completada con [{0}] errores: \n{1}", new Object[]{errorCount, errores});
            } else{
                log.log(Level.WARNING, "Compilacion completada con [{0}] error: \n{1}", new Object[]{errorCount, errores});
            }

            errors.forEach(compError ->
                output
                    .append(BLANK_SPACE)
                    .append(compError)
                    .append(NEW_LINE)
            );

            output
                .append(NEW_LINE)
                .append(BLANK_SPACE)
                .append(BLANK_SPACE)
                .append("BUILD FAILED")
                .append(BLANK_SPACE)
                .append("WITH")
                .append(BLANK_SPACE)
                .append("[")
                .append(errorCount)
                .append("]")
                .append(BLANK_SPACE)
                .append("ERRORS");
        }
        
        // Si no hay errores se agrega el mensaje de compilacion exitosa
        if(!this.errorState){
            output
                .append(BLANK_SPACE)
                .append(BLANK_SPACE)
                .append("BUILD SUCCESSFUL");
            
            log.info("Compilacion completada con exito\n");
        }
        
        return output;
    }    
}