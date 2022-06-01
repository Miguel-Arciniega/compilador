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
public class Patterns {
    public static final String DECLARATION = "(int|float|string)(\\s*)(\\w)+(\\s*)=(.+);";
    public static final String ASSIGNMET = "(\\w)+(\\s*)=(.+);";
    public static final String INIT_METHOD = ".*init.*";
    public static final String ITERATE_METHOD = ".*iterate.*";
    public static final String MODE_FUNC = ".*mode.*";
    public static final String A_WRITE_FUNC = ".*aWrite.*";
    public static final String WAIT_FUNC = ".*wait.*";
    public static final String PRINT_FUNC = ".*print.*";
    public static final String IF_STATEMENT = ".*if.*";
    public static final String CLOSING_BRACKER = ".*}.*";
}