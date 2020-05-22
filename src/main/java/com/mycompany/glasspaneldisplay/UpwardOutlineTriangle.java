/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.glasspaneldisplay;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;

/**
 * Represents outline of equilateral triangle with point at the top
 * (arrow points up).
 *
 * @author Coz
 */
public class UpwardOutlineTriangle extends Geometry {
    int[] x;
    int[] y;
    public UpwardOutlineTriangle(Rectangle bounds, Color outlineColor) {
        super(bounds, outlineColor, false, 3, "Upward Outline Triangle");
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(usedColor);
        // Equilateral triangle with point at the top.
        x[0] = bounds.x+bounds.width/2; // apex
        y[0] = bounds.y;
        x[1] = bounds.x+bounds.width;
        y[1] = bounds.y+bounds.height;
        x[2] = bounds.x;
        y[2] = y[1];
        Polygon p = new Polygon(x,y,sides);
        g.drawPolygon(p);          
    }
}
