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
package com.deimos.compilador.utils.editor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

/**
 *  Track the movement of the Caret by painting a background line at the
 *  current caret position.
 */
public class LinePainter 
        implements Highlighter.HighlightPainter, CaretListener, MouseListener, MouseMotionListener {
    
    private JTextComponent component;
    private Color color;
    private Rectangle lastView;

    /**
     *  The line color will be calculated automatically by attempting
     *  to make the current selection lighter by a factor of 1.2.
     *
     *  @param component text component that requires background line painting
     */
    public LinePainter(JTextComponent component) {
        this(component, null);
        setLighter(component.getSelectionColor());
    }

    /**
     *  Manually control the line color
     *
     *  @param component  text component that requires background line painting
     *  @param color      the color of the background line
     */
    public LinePainter(JTextComponent component, Color color) {
        this.component = component;
        setColor( color );

        //  Add listeners so we know when to change highlighting

        component.addCaretListener( this );
        component.addMouseListener( this );
        component.addMouseMotionListener( this );

        //  Turn highlighting on by adding a dummy highlight

        try {
            component.getHighlighter().addHighlight(0, 0, this);
        }
        catch(BadLocationException ble) {}
    }

    /**
     *  You can reset the line color at any time
     *
     *  @param color  The color of the background line
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     *  Calculate the line color by making the selection color lighter
     *
     *  @param color  The color of the background line
     */
    public void setLighter(Color color) {
        int red   = Math.min(255, (int)(color.getRed() * 1.2));
        int green = Math.min(255, (int)(color.getGreen() * 1.2));
        int blue  = Math.min(255, (int)(color.getBlue() * 1.2));
        setColor(new Color(red, green, blue));
    }

    //  Paint the background highlight

    public void paint(Graphics g, int p0, int p1, Shape bounds, JTextComponent c)
    {
        try{
            Rectangle r = c.modelToView(c.getCaretPosition());
            g.setColor( color );
            g.fillRect(0, r.y, c.getWidth(), r.height);

            if (lastView == null){
                lastView = r;
            }
        } catch(BadLocationException ble) { System.out.println(ble); }
    }

    /**
    *   Caret position has changed, remove the highlight
    */
    private void resetHighlight()
    {
        //  Use invokeLater to make sure updates to the Document are completed,
        //  otherwise Undo processing causes the modelToView method to loop.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    int offset =  component.getCaretPosition();
                    Rectangle currentView = component.modelToView(offset);

                    //  Remove the highlighting from the previously highlighted line
                    if (lastView.y != currentView.y) {
                        component.repaint(0, lastView.y, component.getWidth(), lastView.height);
                        lastView = currentView;
                    }
                }
                catch(BadLocationException ble) {}
            }
        });
    }

    /**
     * 
     * Implements CaretListener
     * 
     */ 
    public void caretUpdate(CaretEvent e) {
        resetHighlight();
    }
    /**
     * 
     *  Implements MouseListener
     * 
     */
    public void mousePressed(MouseEvent e){
        resetHighlight();
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    /**
     * 
     * Implement MouseMotionListener
     * 
     */
    public void mouseDragged(MouseEvent e) {
        resetHighlight();
    }

    public void mouseMoved(MouseEvent e) {}
}