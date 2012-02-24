/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package callejero;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author roberto
 * @author cristian
 * @author alvaro
 * @author hui
 * 
 */
public class Mapa extends javax.swing.JFrame {

    
    private final ArrayList<Cruce> cruces = new ArrayList<Cruce>();
    
    
    /**
     * Creates new form Mapa
     */
    public Mapa() {
        initComponents();
    }
    
    public void addCruce ( Cruce c) {
        this.cruces.add(c);
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(8));
        
        for (final Cruce c : cruces) {
            c.paint(g);
            c.drawCruce(g);
        }
    }
    
    public void test1() {
        Cruce c1 = new Cruce (20,40);
        Cruce c2 = new Cruce (60,40);
        Cruce c3 = new Cruce (20,80);
        Cruce c4 = new Cruce (60,80);

        this.addCruce(c1);
        this.addCruce(c2);
        this.addCruce(c3);
        this.addCruce(c4);

        c1.addNeighbor(c2);
        c1.addNeighbor(c3);
        c2.addNeighbor(c4);
        c3.addNeighbor(c4);
                
        Ruta r = new Ruta(c1,c4);
        r.calcular();
        r.draw(this);
    }
    
    public void test2() {
        Cruce c_prev = null;
        for (int i = 20; i < 800; i += 40) {
            for (int j = 30; j < 800; j += 40) {
                Cruce c = new Cruce (i,j);
                this.addCruce(c);
                if (c_prev != null) {
                    c.addNeighbor(c_prev);
                }
                c_prev = c;
            }
        }
        
        Ruta r = new Ruta(cruces.get(5),cruces.get(35));
        r.calcular();
        r.draw(this);
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
        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(800, 800));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        final Mapa mapa = new Mapa();
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                mapa.setVisible(true);
               
                mapa.test2();
            }
        });
        
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
