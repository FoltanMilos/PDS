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
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.knowm.xchart.XYChart;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
import semestralka1.Osoba;
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();

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
        jScrollPane3.setBounds(470, 0, 460, 440);

        jScrollPane4.setViewportView(jEditorPane1);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(0, 0, 480, 440);

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

        jMenuItem13.setText("Podiel na kontrolach");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

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

        jMenuItem5.setText("Zamestnanci");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuItem6.setText("Poruchy auta");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuItem7.setText("Kontroly");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Generatory");

        jMenuItem8.setText("Zamestnanci");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        jMenuItem9.setText("Osobne udaje");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem9);

        jMenuItem10.setText("Kontroly");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenuItem11.setText("Protokoly");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        jMenuItem12.setText("Vozidla");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem12);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //vytazenie vsetkych zamestnancov
        JSliderOnJOptionPane ret = new JSliderOnJOptionPane();
        int[] retval = ret.mJSliderOnJOptionPane(this);
        String odpoved = this.jadro.getDbManipulation().executeProcedure("analyzaVytazeniaZamestnancov("+retval[0]+","+retval[1]+")")  ;  //reportVytazeniaZamestnancov(retval[0],retval[1]);
        this.jEditorPane1.setContentType("text");
        this.jEditorPane1.setText(odpoved);
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

        String s = this.okno2(this.jadro.getDbManipulation().getZamestnanciNaVyber(),"Zamestnanci");
        if ((s != null) && (s.length() > 0)) {
            String[] ss = s.split("\\-");
            
            
            
            //celkove vytazenie zamestnanca
            double[] yData = new double[] { 56,25,32,38,21 };
            double[] xData = new double[] { 1998, 2003, 2008,2013,2018 };
            
            
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
            this.jEditorPane1.setText(this.jadro.getDbManipulation().reportVytazeniaZam(ss[1].trim()));
        }else{
            this.jEditorPane1.setText("Nebol vybraty zamestnanec!");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed
 
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.jEditorPane1.setText("Auta z stk");
        Osoba osoba = new Osoba("961003/6095".toCharArray(), "Milos", "Foltan", "1996-10-30".toCharArray());
        
        ResultSet executeQuery = this.jadro.getDbManipulation().executeQuery("select * from s_vozidlo");
        
        try {
            this.jTable2.setModel(TableModels.UniversalTableModel.buildTableModel(executeQuery));
        } catch (SQLException ex) {
            Logger.getLogger(HlavneOknoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        ResultSet executeQuery = this.jadro.getDbManipulation().executeQuery("select id_zamestnanca,meno,priezvisko from (select id_zamestnanca,meno,priezvisko, row_number() over(order by rod_cislo)"
                + " as rn from s_zamestnanec"
                + " join s_os_udaje using(rod_cislo)) where rn < 20");
        try {
            this.jTable2.setModel(TableModels.UniversalTableModel.buildTableModel(executeQuery));
        } catch (SQLException ex) {
            Logger.getLogger(HlavneOknoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        String s = this.okno2(this.jadro.getDbManipulation().getVehicles(),"Vozidlo");
        String podm = "";
        if ((s != null) && (s.length() > 0)) {
            String[] ss = s.split("\\-");
            podm = ss[0];
            

            ResultSet executeQuery = this.jadro.getDbManipulation().executeQuery("select id_kontroly,popis_typu as popisKontroly,"
                    + " s_stav_vozidla.popis as popisStavu"
                    + " from s_protokol join s_kontrola using "
                    + "(id_kontroly) join s_typ_kontroly using(id_typu) join s_stav_vozidla using(id_stavu) where id_vozidla =" + podm);

            try {
                this.jTable2.setModel(TableModels.UniversalTableModel.buildTableModel(executeQuery));
            } catch (SQLException ex) {
                Logger.getLogger(HlavneOknoGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
         String xml =  "";
        
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("output.html"));
            
            String lane = "";
            while((lane = in.readLine()) != null){
                xml += lane;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HlavneOknoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HlavneOknoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                 
                 
        this.jEditorPane1.setContentType("text/html");
         this.jEditorPane1.setText(xml);
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed

        //okno na pocet
        Object[] possibilities = {10,100,1000,100000};
        String s = (String)JOptionPane.showInputDialog(
                            this,
                            "Vyber pocet ",
                            "Customized Dialog",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            possibilities,
                            "ham");

        //If a string was returned, say so.
        //if ((s != null) && (s.length() > 0)) {
        //    String[] ss = s.split("\\ ");
        if(s != null){
             this.gener.generujZamestnancov(Integer.parseInt(s));// Integer.parseInt(ss[0])
        }
       // }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        //okno na pocet
        Object[] possibilities = {10,100,1000,100000};
        String s = (String)JOptionPane.showInputDialog(
                            this,
                            "Vyber pocet ",
                            "Customized Dialog",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            possibilities,
                            "ham");
        if(s != null){
         this.gener.generujObcanov(Integer.parseInt(s));// Integer.parseInt(ss[0])
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        //okno na pocet
        Object[] possibilities = {10,100,1000,100000};
        String s = (String)JOptionPane.showInputDialog(
                            this,
                            "Vyber pocet ",
                            "Customized Dialog",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            possibilities,
                            "ham");
        if(s != null){
         this.gener.generujKontroly(Integer.parseInt(s));// Integer.parseInt(ss[0])
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        //okno na pocet
        Object[] possibilities = {10,100,1000,100000};
        String s = (String)JOptionPane.showInputDialog(
                            this,
                            "Vyber pocet ",
                            "Customized Dialog",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            possibilities,
                            "ham");
        //TODO: GENEROVANIE PROTOKOLOV
        if(s != null){
            
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        //okno na pocet
        Object[] possibilities = {10,100,1000,100000};
        String s = (String)JOptionPane.showInputDialog(
                            this,
                            "Vyber pocet ",
                            "Customized Dialog",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            possibilities,
                            "ham");
        if(s != null){
            this.gener.generujVozidla(Integer.parseInt(s));// Integer.parseInt(ss[0])
        }
         
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed

        ResultSet executeQuery = this.jadro.getDbManipulation().executeQuery("select id_zamestnanca, meno, priezvisko, trunc(count(id_kontroly)/podiel_na_kontrolach(),2)*100 || '%'  as podielNaKontrolach from s_os_udaje join s_zamestnanec sz using(rod_cislo)\n" +
"        left join s_kontrola using (id_zamestnanca)\n" +
"            join s_typ_pozicie stp on(sz.id_typu=stp.id_typu)\n" +
"                where stp.id_typu=6 \n" +
                "and (datum_do is null or datum_do > sysdate)" +
"                    group by meno, priezvisko,  id_zamestnanca\n" +
"                        order by podielNaKontrolach desc");

        try {
            this.jTable2.setModel(TableModels.UniversalTableModel.buildTableModel(executeQuery));
        } catch (SQLException ex) {
            Logger.getLogger(HlavneOknoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    

    
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
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
