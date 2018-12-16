/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import generatorDat.GeneratorDat;
//import it.grabz.grabzit.GrabzItClient;

import java.io.File;
import TableModels.TableModelVehicles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.knowm.xchart.XYChart;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import semestralka1.Jadro;
/**
 *
 * @author folko
 */
public class HlavneOknoGUI extends javax.swing.JFrame {
    private Jadro jadro;
    private GeneratorDat gener;
    /**
     * Creates new form HlavneOknoGUI
     */
    public HlavneOknoGUI() {
        this.jadro = new Jadro();
        
        try {
            this.gener = new GeneratorDat();
        } catch (IOException ex) {
            Logger.getLogger(HlavneOknoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(870, 410, 62, 32);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(250, 10, 350, 370);

        jButton2.setText("GenerujZamest");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(30, 240, 190, 32);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "100", "100000" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(40, 200, 120, 26);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "100", "100000" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(40, 280, 120, 26);

        jButton3.setText("Generuj Vozidla");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(20, 360, 180, 32);

        jButton4.setText("jButton3");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(60, 310, 77, 32);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(610, 0, 320, 410);

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

        jMenu4.setText("PDF report");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Pohľady");

        jMenuItem4.setText("Vozidla stk");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuBar1.add(jMenu5);

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
         try{
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(odpoved));
	Document doc = dBuilder.parse(is);
        
        doc.getDocumentElement().normalize();
        NodeList rows = doc.getElementsByTagName("ROW");
        String[] data = new String[4];
        for(int i = 0; i < rows.getLength(); i++){
           Node row = rows.item(i);
           if(row.getNodeType() == Node.ELEMENT_NODE){
               Element el = (Element) row;
               data[0] = el.getElementsByTagName("MENO").item(0).getTextContent();
               data[1] = el.getElementsByTagName("PRIEZVISKO").item(0).getTextContent();
               data[2] = el.getElementsByTagName("ROD_CISLO").item(0).getTextContent();
               data[3] = el.getElementsByTagName("POCET").item(0).getTextContent();
           }
            
        }
        
        for(String i: data){
            System.out.println(i);
        }
        }catch(Exception e){
            System.out.println("error happened: No data to display");
        }
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    private void parseXMLToPDF(String xml){
        xml = "<?xml version=\"1.0\"?>\n" +
            "<ROWSET>\n" +
            " <ROW>\n" +
            "  <ROK>2018</ROK>\n" +
            "  <ID_KONTROLY>1</ID_KONTROLY>\n" +
            "  <ZACIATOK_KONTROLY>12-14 12:18:20</ZACIATOK_KONTROLY>\n" +
            "  <KONIEC_KONTROLY>12-14 12:18:20</KONIEC_KONTROLY>\n" +
            "  <TYP_KONTROLY>Technicka kontrola - osobne</TYP_KONTROLY>\n" +
            " </ROW>\n" +
            " <ROW>\n" +
            "  <ROK>2018</ROK>\n" +
            "  <ID_KONTROLY>2</ID_KONTROLY>\n" +
            "  <ZACIATOK_KONTROLY>12-14 12:18:35</ZACIATOK_KONTROLY>\n" +
            "  <KONIEC_KONTROLY>12-14 12:18:35</KONIEC_KONTROLY>\n" +
            "  <TYP_KONTROLY>Technicka kontrola - osobne</TYP_KONTROLY>\n" +
            " </ROW>\n" +
            "</ROWSET>\n";
 
        try{
        File file = new File("tmp.html");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
	Document doc = dBuilder.parse(is);
        org.jsoup.nodes.Document html = Jsoup.parse(file,"UTF-8","");
        doc.getDocumentElement().normalize();
        NodeList rows = doc.getElementsByTagName("ROW");
        for(int i = 0 ; i < rows.getLength(); i++){
            String[] data = new String[5];
               Node row = rows.item(i);
               if(row.getNodeType() == Node.ELEMENT_NODE){
                   Element el = (Element) row;
                   data[0] = el.getElementsByTagName("ROK").item(0).getTextContent();
                   data[1] = el.getElementsByTagName("ID_KONTROLY").item(0).getTextContent();
                   data[2] = el.getElementsByTagName("ZACIATOK_KONTROLY").item(0).getTextContent();
                   data[3] = el.getElementsByTagName("KONIEC_KONTROLY").item(0).getTextContent();
                   data[4] = el.getElementsByTagName("TYP_KONTROLY").item(0).getTextContent();
               }
            Elements table = html.select("tbody");
            org.jsoup.nodes.Element content = table.get(1);
            org.jsoup.nodes.Element contentRow = html.createElement("tr");
            for(String item : data){
                org.jsoup.nodes.Element col = html.createElement("td");
                col.appendText(item);
                contentRow.appendChild(col);
            }
            content.appendChild(contentRow);
            
        }
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File("output.html")));
        writer.write(html.html());
        writer.close();
        /*
        GrabzItClient grabzIt = new GrabzItClient("", "");
        grabzIt.HTMLToPDF(html.html());
        grabzIt.SaveTo("output.pdf");
        */
        }catch(Exception e){
            System.out.println("error happened: No data to display");
             System.err.println(e.getMessage());
        }
        
        
    }
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
        
        
        
        String s = this.okno2(this.jadro.getDbManipulation().getZamestnanci(""), "Zamestnanci");
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.gener.generujZamestnancov(Integer.parseInt(this.jComboBox1.getSelectedItem().toString()));
        //sss
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed
 
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.parseXMLToPDF("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.jTextArea1.setText("Auta z stk");
        Object[][] data = new Object[][]{{"Auto1","Auto1","Auto1","Auto1","Auto1"},{"Auto2","Auto2","Auto2","Auto2","Auto2"}};
        
        TableModelVehicles tblModel = new TableModelVehicles(data);
        this.jTable2.setModel(tblModel);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
