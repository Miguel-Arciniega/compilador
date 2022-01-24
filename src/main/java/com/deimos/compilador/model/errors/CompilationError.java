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
package com.deimos.compilador.model.errors;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static com.deimos.compilador.utils.StringConstants.BLANK_SPACE;

/**
 * 
 * POJO Donde se define la estructura de los errores,
 * atributos y como se imprimen
 *
 * @author Deimos
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompilationError {
    
    private String errorId; 
    private String errorMessage;
    private String errorContent;
    private ErrorType type;
    private int errorLine;

    public CompilationError(String errorId, String errorMessage, ErrorType type, int errorLine) {
        this.errorId = errorId;
        this.errorMessage = errorMessage;
        this.type = type;
        this.errorLine = errorLine;
    }
    
    /**
     * 
     * Sobrescribe el m?todo toString para crear la estructura de los errores
     * en consola
     * 
     * @return string
     * 
     */
    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        return string
                .append(BLANK_SPACE)
                .append(type)
                .append(BLANK_SPACE)
                .append("Error")
                .append(BLANK_SPACE)
                .append("[")
                .append(errorId)
                .append("]")
                .append(BLANK_SPACE)
                .append("in")
                .append(BLANK_SPACE)
                .append("line")
                .append(BLANK_SPACE)
                .append("(")
                .append(errorLine)
                .append(")")
                .append(":")
                .append(BLANK_SPACE)
                .append(errorMessage)
                .append(BLANK_SPACE)
                .append("->")
                .append(BLANK_SPACE)
                .append(errorContent)
                .toString();
    }
}