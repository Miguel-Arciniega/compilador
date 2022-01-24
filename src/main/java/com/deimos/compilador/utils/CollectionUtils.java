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

import java.util.Collection;
import com.deimos.compilador.model.errors.CompilationError;
import java.util.List;

/**
 *
 * @author Deimos
 */
public class CollectionUtils {

    /**
     *
     * @param collection
     */
    public static boolean isEmpty(Collection collection){
        return collection == null ? true : collection.isEmpty();
    }
    
    /**
     *
     * @param collection
     */
    public static boolean isNotEmpty(Collection collection){
        return collection == null ? false : !collection.isEmpty();
    }
    
    /**
     *
     * @param errors
     * @param begin
     * @param end
     */
    public static void errorQuickSort(List<CompilationError> errors, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(errors, begin, end);
        errorQuickSort(errors, begin, pivot-1);
        errorQuickSort(errors, pivot+1, end);
    }
    
    private static int partition(List<CompilationError> errors, int begin, int end) {

        int pivot = end;
        int counter = begin;
        CompilationError temp = new CompilationError();  
        
        for (int i = begin; i < end; i++) {
            if (errors.get(i).getErrorLine() < errors.get(pivot).getErrorLine()) {
                setList(temp, errors.get(counter));
                setList(errors.get(counter), errors.get(i));
                setList(errors.get(i), temp);
                counter++;
            }
        }
        setList(temp, errors.get(pivot));
        setList(errors.get(pivot), errors.get(counter));
        setList(errors.get(counter), temp);

        return counter;
    }
    
    private static CompilationError setList(CompilationError errorToBeSet, CompilationError errorToSet){
        errorToBeSet.setType(errorToSet.getType());
        errorToBeSet.setErrorId(errorToSet.getErrorId());
        errorToBeSet.setErrorLine(errorToSet.getErrorLine());
        errorToBeSet.setErrorMessage(errorToSet.getErrorMessage());
        errorToBeSet.setErrorContent(errorToSet.getErrorContent());
        
        return errorToBeSet;
    }
}
