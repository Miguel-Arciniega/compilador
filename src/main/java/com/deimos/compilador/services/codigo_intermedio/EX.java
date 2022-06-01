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

/**
 *
 * @author Deimos
 */
import java.util.StringTokenizer;

public class EX {

    String fuente = ""; //CONTENDRÁ EL CÓDIGO FUENTE
    String saliente = ""; //CONTENDRA EL CÓDIGO INTERMEDIO EN ARDUINO
    String salientetab = ""; //CONTENDRÁ EL CÓDIGO INTERMEDIO EN ARDUINO CON TABULACIONES
    String salienteloop = "void loop() {\n"; //CONTENTDRÁ LO CORRESPONDIENTE AL MÉTODO LOOP
    String[] codseg; 
    public int tab=0;
    
    public EX(String sentencias) {
        fuente = sentencias;
        expresiones();
    }
    public String getArduino(){
        return salientetab;
    }
    
    public void expresiones(){
        
    //EXPRESIONES REGULARES DEL LENGUAJE DE ANADAN PARA CAMBIAR POR ESTRUCTURAS EN ARDUINO
       String inijust = ".*int.*;.*";
       String iniflag = ".*flag.*;.*";
       String inibroken = ".*broken.*[//;].*";
       String iniword = ".*word.*[//;].*";
       String inicio = ".*begin.*";
       String fin = ".*end.*";
       String sentif = ".*if[//(].*";
       String sentfor = ".*for[//(].*";
       String sentwhile = ".*while[//(].*";
       String sentswitch = ".*switch[//(].*";
       String sentcase = ".*case[//:].*";
       String sentcut = ".*cut[//;].*";
       String printerport = ".*printerport[//(].*";
       
       String llavecierra = ".*[//}].*";
       String metodo = ".*method.*[//(].*";
       
       String asignacion = ".*=.*;.*";
       
       //EXPRESIONES REGULARES DE LAS FUNCIONES BÁSICAS DE ANADAN
       String fb1 = ".*setfilamenttype[//(].*";
       String fb2 = ".*fillrectangle[//(].*";
       String fb3 = ".*drawrentangle[//(].*";
       String fb4 = ".*sleep[//(].*";
       String fb5 = ".*fillcircle[//(].*";
       String fb6 = ".*drawcircle[//(].*";
       String fb7 = ".*drawtriangle[//(].*";
       String fb8 = ".*filltriangle[//(].*";
       String fb9 = ".*stop[//(].*";
       String fb10 = ".*getextrusorx[//(].*";
       String fb11 = ".*getextrusory[//(].*";
       String fb12 = ".*getextrusorz[//(].*";
       String fb13 = ".*getfilamenttype[//(].*";
       String fb14 = ".*gettemperature[//(].*";
       String fb15 = ".*get[//(].*";
       String fb16 = ".*give[//(].*";
       String fb17 = ".*rightrim[//(].*";
       String fb18 = ".*leftrim[//(].*";
       String fb19 = ".*righttemple[//(].*";
       String fb20 = ".*lefttemple[//(].*";
       String fb21 = ".*bridge[//(].*";
       String fb22 = ".*rims[//(].*";
       String fb23 = ".*lefttemple[//(].*";
       String fb24 = ".*righttemple[//(].*";
       
       String fb25 = ".*[///][//*][//*][///].*";
       
       
       //SEPARAMOS EL CÓDIGO FUENTE ESCRITO POR EL USUARIO EN TOKENS INDIVIDUALES
        StringTokenizer splitfake = new StringTokenizer(fuente,"\n");
        //EVALUACIÓN DE TOKENS INDIVIDUALES
        while(splitfake.hasMoreTokens()){
            
        //linea CONTIENE CADA TOKEN EN CADA CICLO DEL WHILE
            String linea = splitfake.nextToken().replaceAll("\\s", "");
            
            //SE EVALUA CADA LINEA CON LAS EXPRESIONES REGULARES ANTERIORES A TRAVÉS DE MATCHES
            if(linea.matches(fb25)){
                
            }else if(linea.matches(metodo)){
                String[] first = linea.split("[//(]");
                String[] second = first[0].split("method");
                String[] n1 = first[1].split("[//)]");
                String[] n2 = n1[0].split(",");
                saliente += "void " + second[1] + "(";
                
                if(n2.length>0){for(int i=0; i<n2.length; i++){
                        
                        if(n2[i].contains("broken")){
                            if(i>=1){
                            n2[i]=n2[i].replace("broken", ",float "); 
                            }else{
                            n2[i]=n2[i].replace("broken", "float ");
                            }
                            saliente +=n2[i];
                        }
                        if(n2[i].contains("flag")){
                            if(i>=1){
                            n2[i]=n2[i].replace("flag", ",boolean "); 
                            }else{
                            n2[i]=n2[i].replace("flag", "boolean "); 
                            }
                            saliente +=n2[i];
                        }if(n2[i].contains("just")){
                            if(i>=1){
                            n2[i]=n2[i].replace("just", ",int "); 
                            }else{
                            n2[i]=n2[i].replace("just", "int "); 
                            }
                            saliente +=n2[i];
                        }
                        if(n2[i].contains("word")){
                            if(i>=1){
                            n2[i]=n2[i].replace("word", ",string "); 
                            }else{
                            n2[i]=n2[i].replace("word", "string "); 
                            }
                            saliente +=n2[i];
                        }
                }
                saliente +="){\n";
                }       
            }else if(linea.matches(inijust)){
                String[] first = linea.split(";");
                String[] second = first[0].split("int");
                saliente += "entero " + second[1] + ";\n"; 
            }else if(linea.matches(iniflag)){
                String[] first = linea.split(";");
                String[] second = first[0].split("flag");
                saliente += "boolean " + second[1] + ";\n"; 
            }else if(linea.matches(inibroken)){
                String[] first = linea.split(";");
                String[] second = first[0].split("broken");
                saliente += "float " + second[1] + ";\n"; 
            }else if(linea.matches(iniword)){
                String[] first = linea.split(";");
                String[] second = first[0].split("word");
                saliente += "string " + second[1] + ";\n"; 
            }else if(linea.matches(inicio)){
                saliente += "void setup() {\n"; 
            }else if(linea.matches(fin)){
                saliente += "}\n"; 
            }else if(linea.matches(sentif) || linea.matches(llavecierra) || linea.matches(sentfor) || linea.matches(sentwhile)
                    || linea.matches(sentswitch) || linea.matches(sentcase) || linea.matches(sentcut) || linea.matches(fb1)
                    || linea.matches(fb2) || linea.matches(fb3) || linea.matches(fb4) || linea.matches(fb5) || linea.matches(fb6)
                    || linea.matches(fb7) || linea.matches(fb8) || linea.matches(fb9) || linea.matches(fb10) || linea.matches(fb11)
                    || linea.matches(fb12) || linea.matches(fb13) || linea.matches(fb14) || linea.matches(fb15) || linea.matches(fb16)
                    || linea.matches(asignacion)||linea.matches(fb17)||linea.matches(fb18)||linea.matches(fb19)||
                    linea.matches(fb20)||linea.matches(fb21)||linea.matches(fb22)||linea.matches(fb23)||linea.matches(fb24)){
                saliente += linea + "\n"; 
            }else if(linea.matches(printerport)){
                String[] first = linea.split("[//(]");
                String[] second = first[1].split("[//)]");
                saliente += "pinMode("+second[0]+",OUTPUT);\n";
                salienteloop += "digitalWrite("+second[0]+",HIGH);\n"; 
                salienteloop += "delay(1000);\n"; 
                salienteloop += "digitalWrite("+second[0]+",LOW);\n"; 
                salienteloop += "delay(1000);\n";
            }
        }
        //SE ADJUNTA EL MÉTODO LOOP AL MÉTODO SETUP
        saliente += salienteloop + "}";
        codseg = saliente.split("\n");
        //SE CREAN TABULACIONES
        for(int i=0; i<codseg.length; i++){
            for(int j=0; j<tab; j++){
                codseg[i] = "\t"+codseg[i];
            }
            salientetab +=codseg[i]+"\n"; 
            if(codseg[i].contains("{")){tab++;}
            if(codseg[i].contains("}")){tab--;}
        }
        
        
        
        System.out.println("\n Código Intermedio Generado: \n"+saliente);
    }

}
