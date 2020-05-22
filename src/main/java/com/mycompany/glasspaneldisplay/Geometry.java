/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.glasspaneldisplay;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Coz
 */


public abstract class Geometry {
    Rectangle bounds;
    Color usedColor;
    boolean doFill;
    int sides;
    String name;
    public Geometry(Rectangle bounds, Color color, boolean isFilled, int qtySides, String geoName) {
        this.bounds = bounds;           
        usedColor = color;
        doFill = isFilled;
        sides = qtySides;
        name = geoName;
    }
    public abstract void draw(Graphics g);
}

