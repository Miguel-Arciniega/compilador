/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deimos.compiler.util;

import java.awt.Color;

/**
 *
 * @author arcin
 */

/**
 *
 * PaintRequest POJO
 *
 */
public class PaintRequest {

    private final int posini;
    private final int posfin;
    private final Color color;

    public PaintRequest(int posini, int posfin, Color color) {
        this.posini = posini;
        this.posfin = posfin;
        this.color = color;
    }

    public int getPosini() {
        return posini;
    }

    public int getPosfin() {
        return posfin;
    }

    public Color getColor() {
        return color;
    }
}
