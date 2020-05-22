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
 * Represents outline of equilateral triangle with point at the bottom 
 * (arrow points down).
 * 
 * @Author Coz
 */
public class DownwardOutlineTriangle extends Geometry {
    int[] x = new int[3];
    int[] y = new int[3];
    public DownwardOutlineTriangle(Rectangle bounds, Color outlineColor) {
        super(bounds, outlineColor, false, 3, "Downward Outline Triangle");
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(usedColor);
        // Equilateral triangle with point at the bottom.
        x[0] = bounds.x + bounds.width/2; // rock-bottom
        y[0] = bounds.y + bounds.height;
        x[1] = bounds.x + bounds.width;
        y[1] = bounds.y;
        x[2] = bounds.x;
        y[2] = y[1];
        Polygon p = new Polygon(x,y,3);
        g.drawPolygon(p);
    }                
}

