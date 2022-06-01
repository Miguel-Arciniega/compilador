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
package com.deimos.compilador.services.codigo_intermedio;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Deimos
 */
public class CodeProcessor {

    public final Map<String, String> variableHashMap = new HashMap<>();

//    public static void main(String... args) {
//        
//        CodeProcessor codeProcessor = new CodeProcessor();
//        String result = codeProcessor.processCode("int var1 = 30;\nvar2 = 30;");
//        System.out.println(result);
//        
//        codeProcessor.variableHashMap.entrySet().forEach(variable -> {
//            System.out.println(variable.getKey() + " : " + variable.getValue());
//        });
//    }

    public String processCode(String codigoFuente) {

        StringTokenizer tokenizedCode = new StringTokenizer(codigoFuente, "\n");
        String codigoIntermedio = "/////////// Código intermedio generado con el compilador SHL ////////////////\n\n";
        boolean flag = false;
        boolean flagOpenBracket = false;

        while (tokenizedCode.hasMoreTokens()) {
            
            String line = tokenizedCode.nextToken().trim().replaceAll("\\s", "");    
            
            if (line.matches(Patterns.INIT_METHOD)) {
                flag = true;
                codigoIntermedio += "\nvoid setup() {\n";
                continue;
            }
            if (line.matches(Patterns.ITERATE_METHOD)) {
                codigoIntermedio += "}\n\nvoid loop() {\n";
                continue;
            }
            if (line.matches(Patterns.DECLARATION)) {
                if(flagOpenBracket){
                    codigoIntermedio += "    ";
                }
                if(!flag){
                    codigoIntermedio += processDeclaration(line) + "\n";
                }else {
                    codigoIntermedio += "   " + processDeclaration(line) + "\n";
                }
                continue;
            }
            
            if (line.matches(Patterns.ASSIGNMET)) {
                if(flagOpenBracket){
                    codigoIntermedio += "    ";
                }
                codigoIntermedio += "   " + processAsignment(line) + "\n";
            }
            
            if (line.matches(Patterns.MODE_FUNC)) {
                if(flagOpenBracket){
                    codigoIntermedio += "    ";
                }
                codigoIntermedio += "   " + "pinMode" + processTwoParameterFunc(line) + "\n";
            }
            
            if (line.matches(Patterns.A_WRITE_FUNC)) {
                if(flagOpenBracket){
                    codigoIntermedio += "    ";
                }
                codigoIntermedio += "   " + "analogWrite" + processTwoParameterFunc(line) + "\n";
            }

            if (line.matches(Patterns.WAIT_FUNC)) {
                if(flagOpenBracket){
                    codigoIntermedio += "    ";
                }
                codigoIntermedio += "   " + "delay" + processOneParameterFunc(line) + "\n";
            }
            
            if (line.matches(Patterns.PRINT_FUNC)) {
                if(flagOpenBracket){
                    codigoIntermedio += "    ";
                }
                codigoIntermedio += "   " + "Serial.println" + processOneParameterFunc(line) + "\n";
            } 
            
            if (line.matches(Patterns.IF_STATEMENT)) {
                if(flagOpenBracket){
                    codigoIntermedio += "    ";
                }
                codigoIntermedio += "\n" + "   " + "if " + processIfStatement(line) + " {\n\n";
                flagOpenBracket = true;
            }
            
            if (line.matches(Patterns.CLOSING_BRACKER)) {
                if(flagOpenBracket){
                    codigoIntermedio += "   }\n\n";
                    flagOpenBracket = false;
                }
            } 
        }
        codigoIntermedio += "}";

        return codigoIntermedio;
    }

    private String storeVariable(String sentence, String result, StatementType statementType) {
        if (StringUtils.isBlank(sentence)) {
            return "";
        }
        
        if (statementType == StatementType.DECLARATION) {
        
            Pattern pattern = Pattern.compile("(int|float|String)(\\s*)(.*)(\\s*)=(.*);");
            Matcher matcher = pattern.matcher(sentence);
        
            if (matcher.find()){
                String variable = matcher.group(3);
                String value = matcher.group(5);
                
//                for(Entry var: variableHashMap.entrySet()){
//                    if (value.contains(var.getKey().toString())) {
//                            value = value.replace(var.getKey().toString(), var.getValue().toString());
//                    } 
//                }
//                
//                variableHashMap.put(variable, value);

                result += variable + " = " + value + ";";
            }
        }
        
        if (statementType == StatementType.ASSIGNMENT) {
        
            Pattern pattern = Pattern.compile("(.*)(\\s*)=(.*);");
            Matcher matcher = pattern.matcher(sentence);
        
            if (matcher.find()){
                String variable = matcher.group(1);
                String value = matcher.group(3);

//                for(Entry var: variableHashMap.entrySet()){
//                    if (value.contains(var.getKey().toString())) {
//                            value = value.replace(var.getKey().toString(), var.getValue().toString());
//                    } 
//                }
//                
//                variableHashMap.put(variable, value);

                result += variable + " = " + value + ";";
            }
        }
        
        return result;
    }

    private String processDeclaration(String declaration) {
        
        String result = "";
        
        if(declaration.contains("int")){
            result += "int ";
        }
        if(declaration.contains("float")){
            result += "float ";
        }
        if(declaration.contains("string")){
            declaration = declaration.replace("string", "String");
            result += "String ";
        }

        return storeVariable(declaration, result, StatementType.DECLARATION);
    }

    private String processAsignment(String assignment) {
        String result = "";
        return storeVariable(assignment, result, StatementType.ASSIGNMENT) + "\n";
    }

    private String processTwoParameterFunc(String func) {
        Pattern pattern = Pattern.compile("(.*)\\(([^,]*)\\,([^,]*)\\)(.*);");
        Matcher matcher = pattern.matcher(func);
        String result = "";
        
        if (matcher.find()){
            String parameter1 = matcher.group(2);
            String parameter2 = matcher.group(3);
            
            result = "(" + parameter1 + ", " + parameter2 + ");\n";
        }
        
        return result;
    }
    
    private String processOneParameterFunc(String func) {
        Pattern pattern = Pattern.compile("(.*)\\(([^,]*)\\)(.*)");
        Matcher matcher = pattern.matcher(func);
        String result = "";
        
        if (matcher.find()){
            String parameter = matcher.group(2);
            
            result = "(" + parameter + ");\n";
        }
        
        return result;
    }

    private String processIfStatement(String ifStatement) {
        Pattern pattern = Pattern.compile("\\(((\\s*)(\\w+)((\\s*)(\\|\\||&&|<=|>=|<|>|!=|==)(\\s*)(\\w+)(\\s*))+|(\\s*)(\\w+)(\\s*))\\)");
        Matcher matcher = pattern.matcher(ifStatement);
        
        String result = "";
        int i = 0;
                        
        if (matcher.find()){
            String parameter = matcher.group(0);
            result += parameter;
        }
        
        return result;
    }
}
