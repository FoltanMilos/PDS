/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.knowm.xchart.XYChart;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import semestralka1.Jadro;
import org.w3c.dom.NodeList;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import jdk.internal.org.xml.sax.InputSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.xml.sax.SAXException;

/**
 *
 * @author folko
 */
public class HlavneOknoGUI extends javax.swing.JFrame {
    private Jadro jadro;
    /**
     * Creates new form HlavneOknoGUI
     */
    public HlavneOknoGUI() {
        this.jadro = new Jadro();
        
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(650, 450));
        setMinimumSize(new java.awt.Dimension(650, 450));
        setPreferredSize(new java.awt.Dimension(650, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(580, 360, 62, 32);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 20, 355, 270);

        jMenu2.setText("Menu");

        jMenuItem2.setText("Kolacovy");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reporty");

        jMenuItem1.setText("VytazenostZamestnancov");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem3.setText("Celkove vytazenie zamestnanca");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //vytazenie vsetkych zamestnancov
        JSliderOnJOptionPane ret = new JSliderOnJOptionPane();
        int[] retval = ret.mJSliderOnJOptionPane(this);
        String odpoved = this.jadro.getDbManipulation().executeProcedure("analyzaVytazeniaZamestnancov("+retval[0]+","+retval[1]+")")  ;  //reportVytazeniaZamestnancov(retval[0],retval[1]);
        this.jTextArea1.setText(odpoved);
        //tu parsuj XML
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        double[] yData = new double[] { 56,25,32,38,21 };
        double[] xData = new double[] { 1998, 2003, 2008,2013,2018 };

        // Create Chart
        XYChart chart = QuickChart.getChart("Vykonnost zamestnancov", "X", "Y", "y(x)", xData, yData);

        // Show it
        
        Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
           new SwingWrapper(chart).displayChart();
        }

        });
        t.start();
        
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        //celkove vytazenie zamestnanca
        double[] yData = new double[] { 56,25,32,38,21 };
        double[] xData = new double[] { 1998, 2003, 2008,2013,2018 };

        // Create Chart
        
        
        
        String s = this.okno2(this.jadro.getDbManipulation().getZamestnanci(), "Zamestnanci");
        if ((s != null) && (s.length() > 0)) {
            String[] ss = s.split("\\ ");
            XYChart chart = QuickChart.getChart("Vykonnost zamestnanca " + ss[2] + " " + ss[3],
                    "X", "Y", "y(x)", xData, yData);

            Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                
                SwingWrapper swingWrapper = new SwingWrapper(chart); //.displayChart();
                JFrame displayChart = swingWrapper.displayChart();
                displayChart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
            }

            });
            t.start();
            this.jTextArea1.setText(this.jadro.getDbManipulation().reportVytazeniaZam(ss[1].trim()));
        }else{
            this.jTextArea1.setText("Nebol vybraty zamestnanec!");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(HlavneOknoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HlavneOknoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HlavneOknoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HlavneOknoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new HlavneOknoGUI().setVisible(true);
                
            }
        });
    }
    
    public String okno2(Object[] pole,String param){
        return (String)JOptionPane.showInputDialog(
                        this,
                        "Vyberte obcana\n"
                        + "\"zo zoznamu " + param +":\"",
                        "Customized Dialog",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        pole,
                        "Najprv vytvorte obcanov!");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
