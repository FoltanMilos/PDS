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
    private String datu_narodenia;
    private String pozicia;
    private String rod_cislo;

    public Zamestnanec(String meno, String priezvisko, String datu_narodenia, String pozicia,String rod_cislo) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.datu_narodenia = datu_narodenia;
        this.pozicia = pozicia;
        this.rod_cislo = rod_cislo;
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
        return datu_narodenia;
    }

    public void setDatu_narodenia(String datu_narodenia) {
        this.datu_narodenia = datu_narodenia;
    }

    public String getPozicia() {
        return pozicia;
    }

    public void setPozicia(String pozicia) {
        this.pozicia = pozicia;
    }

    @Override
    public String toString() {
        return rod_cislo + " " + meno + " " + priezvisko + " " + datu_narodenia + " " + pozicia ;
    }
    
    
}
