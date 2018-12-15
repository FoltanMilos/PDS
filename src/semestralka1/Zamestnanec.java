/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralka1;

/**
 *
 * @author folko
 */
public class Zamestnanec {
    private String meno;
    private String priezvisko;
    private String datum_narodenia;
    private int pozicia;
    private String popis_pozicie;
    private String rod_cislo;
    private int id;
    private String dat_od;
    private String dat_do;

    public Zamestnanec(String rod_cislo, String meno, String priezvisko, String datum_narodenia, int pozicia, String popis_pozicie, int id, String dat_od, String dat_do) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.datum_narodenia = datum_narodenia;
        this.pozicia = pozicia;
        this.popis_pozicie = popis_pozicie;
        this.rod_cislo = rod_cislo;
        this.id = id;
        this.dat_od = dat_od;
        this.dat_do = dat_do;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public String getDatu_narodenia() {
        return datum_narodenia;
    }

    public void setDatu_narodenia(String datum_narodenia) {
        this.datum_narodenia = datum_narodenia;
    }

    public int getPozicia() {
        return pozicia;
    }

    public void setPozicia(int pozicia) {
        this.pozicia = pozicia;
    }

     public String getPopisPozicie() {
        return this.popis_pozicie;
    }

    public void setPopisPozicie(String popis) {
        this.popis_pozicie = popis;
    }   
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }    
    
    public String getDatOd() {
        return this.dat_od;
    }
    
    public void setDatOd(String dat_od) {
        this.dat_od = dat_od;
    }
     
    public String getDatDo() {
        return this.dat_do;
    }
    
    public void setDatDo(String dat_do) {
        this.dat_do = dat_do;
    }
    
    @Override
    public String toString() {
        return this.rod_cislo + " " + this.meno + " " + this.priezvisko + " " + this.datum_narodenia + " " + this.popis_pozicie ;
    }
    
    
}
