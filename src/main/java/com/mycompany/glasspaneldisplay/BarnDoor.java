/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.glasspaneldisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;

/**
 * Draw a two shows fake buttons, top and bottom, that show click area for a 
 * DecadeDigit and are drawn behind a JTextField which is contained by a glassPane.
 * 
 * Default color of line drawing is white.
 * Default color of fill is black.
 * 
 * @author Coz
 */
public class BarnDoor extends JPanel {
    private GeometryModel model;   
    //private  int rectX;
    //private  int rectY;
    private  int rectWidth; // Width of textField
    private  int rectHeight;// Height of textField
    private  Color outlineColor = Color.WHITE;
    private  Color fillColor = Color.BLACK;
    private  boolean hasFill = false;
    private  Dimension preferredSize;

    public BarnDoor(GeometryModel model, Dimension prefSize) {
        this.model = model;
        this.setPreferredSize(prefSize);
        preferredSize = prefSize;
        rectWidth = prefSize.width;
        rectHeight = prefSize.height;
    }
   
   public void setFillColor(Color c) {
       fillColor = c;
   }

    public void setOutlineColor(Color c) {
       outlineColor = c;
    }
   
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        model.draw(g);
    }
   
    public void addShapes() {
        // Painting coordinates are positive going to the right and down from
        // the top left corner of the space.
        // Fill the complete space occupied by the textField.
        Rectangle bounds = new Rectangle(0, 0, rectWidth, rectHeight);
        FilledRectangle filledRect =  new FilledRectangle(bounds, fillColor); 
        model.addGeometry((Geometry) filledRect);
           
        // Draw the upper button outline rectangle with inset of 5 percent of the 
        // fieldWidth.
        int inset = rectWidth/20;
        int boxHeight = (rectHeight/2)-(2*inset);
        int boxWidth = rectWidth-(2*inset);
        Rectangle upperBoxRect = new Rectangle(inset,inset,boxWidth,boxHeight);
        OutlineRectangle upperBox = new OutlineRectangle( upperBoxRect, outlineColor);
        model.addGeometry((Geometry) upperBox);
        // Draw the lower outline rectangle.        
        Rectangle lowerBoxRect = new Rectangle(inset, inset+rectHeight/2, 
                boxWidth, boxHeight);
        OutlineRectangle lowerBox = new OutlineRectangle(upperBoxRect, outlineColor);
        model.addGeometry((Geometry)lowerBox);
               
        // Draw the upper arrow triangle outline at 5 percent inset.
        inset = inset + inset;
        boxWidth = boxWidth - (2*inset);
        boxHeight = boxHeight - (2*inset);
        Rectangle upArrowRect = new Rectangle( inset, inset, boxWidth, boxHeight);
        UpwardOutlineTriangle upTriangle = new UpwardOutlineTriangle(upArrowRect, outlineColor);
        model.addGeometry(upTriangle);
        // Draw the lower arrow triangle outline.
        Rectangle downArrowRect = new Rectangle( inset, inset+rectHeight/2,
                    boxWidth, boxHeight);
        DownwardOutlineTriangle downTriangle = new DownwardOutlineTriangle(downArrowRect, outlineColor);
        model.addGeometry(downTriangle);

    }
}

