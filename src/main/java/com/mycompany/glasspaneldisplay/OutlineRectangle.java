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
    
public class OutlineRectangle extends Geometry {
    public OutlineRectangle(Rectangle bounds, Color outlineColor) {
        super(bounds, outlineColor, false, 4, "Outline Rectangle");
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(usedColor);
        g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);            
    }
}

