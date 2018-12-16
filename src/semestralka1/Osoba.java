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
public class Osoba {
    private char[] rod_cislo;
    private String meno;
    private String priezvisko;
    private char[] datumNarodenia;     //YYYY-MM-DD

    public Osoba(char[] rod_cislo, String meno, String priezvisko, char[] datumNarodenia) {
        this.rod_cislo = rod_cislo;
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.datumNarodenia = datumNarodenia;
    }

    public Osoba() {
    }
    

    public char[] getRod_cislo() {
        return rod_cislo;
    }

    public void setRod_cislo(char[] rod_cislo) {
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

    public char[] getDatumNarodenia() {
        return datumNarodenia;
    }

    public void setDatumNarodenia(char[] datumNarodenia) {
        this.datumNarodenia = datumNarodenia;
    }

    @Override
    public String toString() {
        return "Osoba{" + "rod_cislo=" + String.valueOf(this.rod_cislo) + ", meno=" + meno + ", priezvisko=" + priezvisko + ", datumNarodenia=" + String.valueOf(this.datumNarodenia) + '}';
    }
    
    public String[] toTableModel(){
        return new String[]{this.meno,this.priezvisko,this.meno,this.priezvisko,this.meno};
    }
    
}
