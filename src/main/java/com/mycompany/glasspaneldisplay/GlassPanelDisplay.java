/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.glasspaneldisplay;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * This is a prototype demo of a static background drawn on a JFrame content pane
 * and a dynamic foreground drawn on a JFrame glass pane.
 * 
 * In application, the foreground is a DecadeDigit that listens for mouse clicks
 * in the top half of textField to increment digit and the bottom half to
 * decrement digit.  This gives the appearance of a custom JSpinner without using
 * display space for the spinner buttons.
 * 
 * @author Coz
 */
public class GlassPanelDisplay extends javax.swing.JFrame {

    /**
     * Creates new form GlassPanelDisplay
     */
    public GlassPanelDisplay() {
        initComponents();
    }
    /**
     * For the given JLabel, use the label dimensions and font metrics to 
     * determine the maximum font size that will fit.
     * 
     * @param label the JLabel text field 
     * 
     * @return The maximum font size in font points
     */
    public static int computeMaxFontSize(JLabel label) {
        // Given the label dimensions, the text, and the font, 
        // what is the font size that will fit?
        
        // Compute the font size to fit into the label size.
        Font labelFont = label.getFont();
        String labelText = label.getText();

        int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = label.getWidth();

        // Find out how much the font can grow in width.
        double widthRatio = (double)componentWidth / (double)stringWidth;
        System.out.println("widthRatio of "+labelFont.getName()+" is " + String.valueOf(widthRatio) );
        int newFontSize = (int)(labelFont.getSize() * widthRatio);
        int componentHeight = label.getHeight();

        // Pick a new font size so it will not be larger than the height of label.
        int fontSizeToUse = Math.min(newFontSize, componentHeight);
        System.out.println("Font size to use is "+ String.valueOf(fontSizeToUse));
        return fontSizeToUse;
    }

    public void setUpPanes() {
        GlassPanelDisplay mf = this;
        String version = new String("1.0.0");
        setTitle("Glass Panel Display Demo version "+version);
        mf.setSize(400, 400);
        mf.setLocationRelativeTo(null);
        mf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mf.setGlassPane(new JPanel());
        
        // We are drawing the digit on the glass pane.
        // We are drawing the barnDoor on the content pane.
        int boundsX = 10;
        int boundsY = 10;
        int boundsWidth = 80;
        int boundsHeight = 120;
        Rectangle labelRect = new Rectangle(boundsX,boundsY,boundsWidth,boundsHeight);
        
        JLabel label = new JLabel();
        label.setBounds(labelRect);
        Font font = new Font("Lucida Grande", Font.PLAIN, 12);
        label.setFont(font);
        label.setText("8");
       int fontSizeToUse = computeMaxFontSize(label); 
        
        // Set the label's font size to the newly determined size.
        label.setFont(new Font(font.getName(), Font.PLAIN, fontSizeToUse));
        
        label.setForeground(Color.GREEN);
        label.setBorder(new LineBorder(Color.BLACK, 1));
        Rectangle bounds = label.getBounds();
        boundsX = bounds.x;
        boundsY = bounds.y;
        boundsWidth = bounds.width;
        boundsHeight = bounds.height;
        label.setPreferredSize(label.getSize());
        float xL = label.getAlignmentX();
        float yL = label.getAlignmentY();
        Rectangle rectL = label.getBounds();
        Dimension dimPrefSizeL = label.getPreferredSize();
        JPanel glassPane = (JPanel) mf.getGlassPane();
        glassPane.setLayout(new FlowLayout());
        glassPane.add(label);
        //MUST HAVE THE FOLLOWING LINE FOR GLASS PANE TO BE TRANSPARENT!
        glassPane.setOpaque(false);
        
        Container content = mf.getContentPane();
        content.setBackground(Color.WHITE);
        content.setLayout(new FlowLayout());

        // Now draw the BarnDoor on the content pane.
        // Use exact same rectangle used for the JLabel.
        GeometryModel model = new GeometryModel();
        Dimension dim = new Dimension(rectL.width, rectL.height);
        BarnDoor door = new BarnDoor(model, dim);
        door.addShapes();
        content.add(door);
        content.setVisible(true);
        
        mf.getGlassPane().setVisible(true);

    }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GlassPanelDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GlassPanelDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GlassPanelDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GlassPanelDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GlassPanelDisplay frame = new GlassPanelDisplay();
                frame.setUpPanes();
                

                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
