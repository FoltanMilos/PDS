/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralka1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author folko
 */
public class DBmanipulation {
    private String urlAddress;
    private String meno;
    private String heslo;
    private Connection conn;
    private DriverManager dataHandler;
    private Statement st;
    
    
    /**
     * Konstruktor aj vytvori connection
     */
    public DBmanipulation(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.toString());
        }
        this.urlAddress = "jdbc:oracle:thin:@Obelix.fri.uniza.sk:1521:orcl";
        this.meno = "foltan8";
        this.heslo = "hesloFOLTAN";
        try {
            this.conn = DriverManager.getConnection(this.urlAddress, this.meno,this.heslo);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            String sql;
            sql = "SELECT * FROM student";
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        
        try {
            while(rs.next()){
               // System.out.println(rs.getInt("os_cislo"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        } 
        
        
        
    }
    
    
    
    
    
    
    
    public void insert(String tabulka, Object object){
        try {
            st = conn.createStatement();
        } catch (SQLException ex) {
            System.err.println("nepodarilo sa vytvorit statement! (INSERT)");
            System.err.println(ex.toString());
        }
        String sql = "";
        sql = "INSERT into " + tabulka + " values('" + String.valueOf(((Osoba)object).getRod_cislo()) + "','" + 
                ((Osoba)object).getMeno() + "','"+ ((Osoba)object).getPriezvisko() + "',to_date('" + 
                String.valueOf(((Osoba)object).getDatumNarodenia()) + "','YYYY-MM-DD')" + ",new t_adresa(null,null,null));";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.err.println("chyba pri vykonani statementu! (INSERT)");
            System.err.println(ex.toString());
        }
        
        System.out.println("Vlozeny!" + object.toString());
    }
    
    
    public Object[] getZamestnanci(String where){
        ArrayList<Object> list = new ArrayList<Object>();
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            String sql;
            sql = "Select rod_cislo,meno, priezvisko,dat_narodenia,id_typu, popis, id_zamestnanca, dat_od, nvl(dat_do,\"\") from s_os_udaje "
                    + "join s_zamestnanec using(rod_cislo) join s_typ_pozicie using(id_typu)" + where;
            rs = st.executeQuery(sql);
            
           // sql = "Select * from s_os_udaje";
                    
            //rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        try {
            while(rs.next()){
                // System.out.println(rs.getInt("os_cislo"));
                Zamestnanec zamestnanec = new Zamestnanec(rs.getString("rod_cislo"),rs.getString("meno"), rs.getString("priezvisko"),
                        rs.getString("dat_narodenia") , rs.getInt("id_typu"), rs.getString("popis"), rs.getInt("id_zamestnanca"), 
                        rs.getString("dat_od"), rs.getString("dat_do"));
                list.add(zamestnanec.toString());
               
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        } 
        return list.toArray();
    }
    
    //autor mato, potrebujem rodne cisla
    public Object[] getOsoby(){
        ArrayList<Object> list = new ArrayList<Object>();
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            String sql;
            sql = "Select rod_cislo,meno, priezvisko,dat_narodenia from s_os_udaje";
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        try {
            int i = 0;
            while(i < 101){
                rs.next();
                Osoba osoba = new Osoba(rs.getString("rod_cislo").toCharArray(),rs.getString("meno"), rs.getString("priezvisko"),
                        rs.getString("dat_narodenia").toCharArray());
                list.add(osoba);
                i++;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        } 
        return list.toArray();
    }
    
    
    /**
     * Napis si cele meno procedury, aj s parametrami ktore tam vstupuju SYNTAKTICKY
     * Ako kebz si to pustal v sql, priklad parametru: analyzaVytazeniaZamestnancov(2001,2010) 
     * @param callableFullProcNameAndParams
     * @return 
     */
    public String executeProcedure(String callableFullProcNameAndParams){
        String command = "";
        try {
            command =   "{ ? = call "+callableFullProcNameAndParams + "}";
            CallableStatement stmt = conn.prepareCall(command);
            stmt.registerOutParameter(1, Types.CLOB);
            stmt.execute();
            
            Clob clob = stmt.getClob(1);
            
             if(clob != null){
                 /*
                 Vracia prekonvertovany string
                 */
               return this.convertCLOBtoString(clob); 
            }else{
                
               return "Nenasli sa zaznami v procedure!";
            }
        } catch (SQLException ex) {
            System.err.println("chyba pri vykonani procedury! (exec proc - " + callableFullProcNameAndParams + "");
            System.err.println("Command --> " + command);
            System.err.println(ex.toString());
        }
        //nemalo bz sa vratit null        
        return null;
    }
    
 
    
    /**
     * Convert clob to string
     * @param clob - clob from DB
     * @return string, ak nieco nevyjde vrati NULL
     */
    private String convertCLOBtoString(Clob clob){
        StringBuilder sb = new StringBuilder();
        try { 
            Reader reader = clob.getCharacterStream();
            BufferedReader br = new BufferedReader(reader);
            
            int b = 0;
            while(-1 != (b = br.read()))
            {
                sb.append((char)b);
            }
            
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DBmanipulation.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DBmanipulation.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return sb.toString();
    }
    
    
    /**
     * report vytazenia jedneho zamestnanca za cele casove obdobie
     * @param rod_cislo
     * @param rok_od
     * @param rok_do
     * @return 
     */
    public String reportVytazeniaZam(String rod_cislo){
        try {
            ResultSet rs = null;
            String sql = "";
            
            CallableStatement stmt = conn.prepareCall("{ ? = call analyzaVytazeniaZam('"+rod_cislo+"')}");
            stmt.registerOutParameter(1, Types.CLOB);
            
            stmt.execute();
            
            Clob clob = stmt.getClob(1);
            if(clob != null){
               return this.convertCLOBtoString(clob); 
            }else{
                
               return "Nenasli sa ziadny zamestnanci v danom rozsahu!";
            }
            
        } catch (SQLException ex) {
            System.err.println("chyba pri vykonani procedury!");
            System.err.println(ex.toString());
        }
        //null ked sa odchyta vynimka
        return null;
    }
    
    
    
    
}
