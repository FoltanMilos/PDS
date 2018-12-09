/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorDat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import semestralka1.DBmanipulation;
import semestralka1.Osoba;

/**
 *
 * @author folko
 */
public class GeneratorDat {
    private Random rnd;
    private int test;
    private String[] menaMuzi;
    private String[] menaZeny;
    private String[] priezviska;
    private String[] auta;
    private String[] autobusy;
    private String[] kamiony;
    private String[] icoAutobusy = {"00000000000", "11111111111", "22222222222", "33333333333", "44444444444"};
    private String[] icoKamiony = {"55555555555", "66666666666", "77777777777", "88888888888", "99999999999"};
    private String[] prevadzkovateliaAutobusy = {"SAD Zvolen", "SAD Zilina", "SAD Matrin", "SAD Zarnovica", "SAD Bratislava"};
    private String[] prevadzkovateliaKamiony ={"Foltan Transport a.s.", "Sarina Cargo s.r.o.", "Kotora Trucking v.o.s.", "Paliesek Shipping k.s.", "Jednotne rolnicke druzstvo Dolna Ves"};
    private DBmanipulation db;
    //sss
    public GeneratorDat() throws FileNotFoundException, IOException {
        this.rnd = new Random();
        //this.rnd.setSeed(10);
        this.menaMuzi = new String[195];
        this.menaZeny = new String[218];
        this.priezviska = new String[50];
        this.auta = new String[33];
        this.autobusy = new String[9];
        this.kamiony = new String[9];
        this.db = new DBmanipulation();
        //nacitanie mien
        String csvFile = "GeneratorMena.txt";
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String line =  "";
        int i = 0;
        int k = 0;
        while ((line = reader.readLine()) != null) {
            String[] params = line.split(",");
            if(params[1].trim().charAt(params[1].trim().length()-1) == 'a'){
                this.menaZeny[k] = params[1].trim(); 
                k++;
            }else{
                this.menaMuzi[i] = params[1].trim();
                i++;
            }
        }
        //nacitanie priezvisk
        i = 0;
        csvFile = "GeneratorPriezviska.txt";
        reader = new BufferedReader(new FileReader(csvFile));
        while ((line = reader.readLine()) != null) {
            String[] params = line.split(",");
            this.priezviska[i] = params[1];
            i++;
        }
        //nacitanie aut autor:mato
        csvFile = "GeneratorAuta.txt";
        reader = new BufferedReader(new FileReader(csvFile));
        while ((line = reader.readLine()) != null) {
            String[] params = line.split(",");
            this.auta = params;
        }
        //nacitanie autobusov autor:mato
        csvFile = "GeneratorAutobusy.txt";
        reader = new BufferedReader(new FileReader(csvFile));
        while ((line = reader.readLine()) != null) {
            String[] params = line.split(",");
            this.autobusy = params;
        }      
        //nacitanie kamionov autor:mato
        csvFile = "GeneratorKamiony.txt";
        reader = new BufferedReader(new FileReader(csvFile));
        while ((line = reader.readLine()) != null) {
            String[] params = line.split(",");
            this.kamiony = params;
        }           
        //test
        //this.generujZamestnancov(50);
        //this.generujObcanov(100000);
        //this.generujZamestnancov(10);
    }
    
    public void generujObcanov(int pocet){
        BufferedWriter writer = null;
        String csvFile = "Osoby.dat";
        try {
                writer = new BufferedWriter(new FileWriter(csvFile));
            } catch (IOException ex) {
                Logger.getLogger(GeneratorDat.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        for (int i = 0; i < pocet; i++) {
            BufferedReader reader = null;
            Osoba osoba = new Osoba();
            this.generujAtributy(osoba);
            //this.db.insert("s_os_udaje", osoba);
            
            String line;
            
            String sql = String.valueOf(osoba.getRod_cislo()) + "," + 
                osoba.getMeno() + ","+ osoba.getPriezvisko() + "," + 
                String.valueOf(osoba.getDatumNarodenia()) + "," + "new t_adresa(null,null,null));\n";
            try {
                writer.write(sql);
            } catch (IOException ex) {
                Logger.getLogger(GeneratorDat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(GeneratorDat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * Metoda vygeneruje rodne cislo
     */
    private void generujAtributy(Osoba osoba){
        char[] rodCis = new char[11];
        //rok -- len pre 20storocie
        int rok = this.rnd.nextInt(50) + 50;
        rodCis[0] = Integer.toString(rok).toCharArray()[0];
        rodCis[1] = Integer.toString(rok).toCharArray()[1];
        //mesiac
        int mesiac = 0;
        //vygeneruje zenu na 50%
        if(this.rnd.nextInt() > 5){
            mesiac = this.rnd.nextInt(12)+1 + 50;
            //meno
            osoba.setMeno(this.menaZeny[this.rnd.nextInt(this.menaZeny.length-1)]);
        }else{
            //meno
            osoba.setMeno(this.menaMuzi[this.rnd.nextInt(this.menaMuzi.length-1)]);
            mesiac = this.rnd.nextInt(12)+1;
        }
        //osetrenie pre mesiace do 10
        if(Integer.toString(mesiac).toCharArray().length < 2){
            rodCis[2] = '0';
            rodCis[3] = Integer.toString(mesiac).toCharArray()[0];
        }else{
            rodCis[2] = Integer.toString(mesiac).toCharArray()[0];
            rodCis[3] = Integer.toString(mesiac).toCharArray()[1];  
        }
        //den
        int den = this.rnd.nextInt(31)+1;
        //ak vygeneruje do 10 treba pridat 0
        if(Integer.toString(den).toCharArray().length < 2){
            rodCis[4] = '0';
            rodCis[5] = Integer.toString(den).toCharArray()[0];
        }else{
            rodCis[4] = Integer.toString(den).toCharArray()[0];
            rodCis[5] = Integer.toString(den).toCharArray()[1];
        }
        //lomka
        rodCis[6] = '\\';
        //4cisla za rc
        int cislo = this.rnd.nextInt(9999)+1000;
        int j = 0;
        for (int i = 7; i < 11; i++) {
            rodCis[i] = Integer.toString(cislo).toCharArray()[j];
            j++;
        }
        //pridanie rod_cisla
        osoba.setRod_cislo(rodCis);
        rok += 1900;
        mesiac = mesiac % 50;
        char[] cc =new char[]{Integer.toString(rok).toCharArray()[0],
        Integer.toString(rok).toCharArray()[1],Integer.toString(rok).toCharArray()[2],
        Integer.toString(rok).toCharArray()[3],'-',
        Integer.toString(mesiac).toCharArray().length < 2 ? '0' : Integer.toString(mesiac).toCharArray()[0],
        Integer.toString(mesiac).toCharArray().length < 2 ? Integer.toString(mesiac).toCharArray()[0] : Integer.toString(mesiac).toCharArray()[1],
        '-',rodCis[4],rodCis[5]};
        osoba.setDatumNarodenia(cc);
        
        //priezvisko
        osoba.setPriezvisko(this.priezviska[this.rnd.nextInt(this.priezviska.length-1)]);
        System.out.println(osoba.toString());
    }
    
    //generator zamestnancov autor:Mato
    public void generujZamestnancov(int pocet) {
        Object[] osoby = this.db.getOsoby();
        BufferedWriter writer = null;
        String csvFile = "Zamestnanci.dat";
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
        } catch (IOException ex) {
            Logger.getLogger(GeneratorDat.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Upratovačka, Údržbár, Vrátnik, Skladník, Zamestnanec, Vedúci oddelenia, Zákaznícka podpora, Manažér, Účtovník
        double[] vahy = {0.1, 0.15, 0.17, 0.22, 0.82, 0.85, 0.92, 0.95};
        for(int i = 1; i <= pocet; i++){
            char[] dat_narodenia = ((Osoba)osoby[i]).getDatumNarodenia();
            int id_pozicie;
            if (i == 1) {
                id_pozicie = 1;
            } else {
                double rand = this.rnd.nextDouble();
                id_pozicie = 10;
                for(int j = 1; j < vahy.length; j++) {
                    if (rand >= vahy[j]){
                        id_pozicie = 10-j;
                        break;
                    }
                }
            }
            int rok_narodenia = 1900 + (Character.getNumericValue(dat_narodenia[2]))*10 + Character.getNumericValue(dat_narodenia[3]);    
            int datum_od = rok_narodenia + 18 + this.rnd.nextInt(10);
            char[] dat_od = String.valueOf(datum_od).toCharArray();
            char[] datum_od_chararr = dat_narodenia.clone();
            for(int j = 0; j < dat_od.length; j++) {
                datum_od_chararr[j] = dat_od[j];
            }
            int datum_do = 0;
            String datum_do_string = "";
            double rand = this.rnd.nextDouble();
            if (rand > 0.5) {
                datum_do = datum_od + this.rnd.nextInt(15)+1;
                char[] dat_do = String.valueOf(datum_do).toCharArray();
                char[] datum_do_chararr = dat_narodenia.clone();
                for(int j = 0; j < dat_do.length; j++) {
                    datum_do_chararr[j] = dat_do[j];
                }
                datum_do_string = String.valueOf(datum_do_chararr);
            }
            String sql = String.valueOf(i) + "|" + String.valueOf(((Osoba)osoby[i]).getRod_cislo()) + "|" + 
                String.valueOf(id_pozicie) + "|" + String.valueOf(datum_od_chararr) + "|" + 
                datum_do_string + "|\n";
            try {
                writer.write(sql);
            } catch (IOException ex) {
                Logger.getLogger(GeneratorDat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(GeneratorDat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // autor mato
    public void generujVozidla(int pocet) {
        Object[] osoby = this.db.getOsoby();
        BufferedWriter writer = null;
        String csvFile = "VozdiaInsert.sql";
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
        } catch (IOException ex) {
            Logger.getLogger(GeneratorDat.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 1; i <= pocet; i++){
            String param1 = String.valueOf(((Osoba)osoby[rnd.nextInt(osoby.length)]).getRod_cislo());
            String trieda;
            int nosnost;
            int cena;
            String znacka;
            String mesiac = "0";
            int cislo = this.rnd.nextInt(12)+1;
            mesiac = (cislo < 10)? mesiac+String.valueOf(cislo):String.valueOf(cislo);
            String datum_vyroby = String.valueOf(this.rnd.nextInt(28)+1990) + "-" + mesiac + "-01";
            String nieAutoParam = "";
            double rand = this.rnd.nextDouble();
            if (rand < 0.25){
                trieda = "kamion";
                int randInt = this.rnd.nextInt(this.icoKamiony.length);
                nosnost = 5000 + this.rnd.nextInt(10)*100;
                cena = 30000 + this.rnd.nextInt(20)*1000;
                param1 = this.icoKamiony[randInt];
                znacka = this.kamiony[this.rnd.nextInt(kamiony.length)];
                nieAutoParam += ","+String.valueOf(this.rnd.nextInt(10)*100 + 3000); //kapacita nakladu
                nieAutoParam += ","+String.valueOf(this.rnd.nextInt(10)*10 + 500); //kapacita nadrze
                nieAutoParam += ",'"+this.prevadzkovateliaKamiony[randInt]+"'";
            } else if (rand < 0.5){
                trieda = "autobus";
                int randInt = this.rnd.nextInt(icoAutobusy.length);
                nosnost = 3000 + this.rnd.nextInt(10)*100;
                cena = 10000 + this.rnd.nextInt(10)*1000;
                param1 = this.icoAutobusy[randInt];
                znacka = this.autobusy[this.rnd.nextInt(this.autobusy.length)];
                nieAutoParam += ","+String.valueOf(this.rnd.nextInt(20) + 40); //kapacita sedenie
                nieAutoParam += ","+String.valueOf(this.rnd.nextInt(15) + 30); //kapacita statie
                nieAutoParam += ",'"+this.prevadzkovateliaKamiony[randInt]+"'";
            } else {
                trieda = "auto";
                nosnost = 1000 + this.rnd.nextInt(10)*50;
                cena = 5000 + this.rnd.nextInt(100)*100;
                znacka = this.auta[this.rnd.nextInt(this.auta.length)];
            }
                String sql = "insert into s_vozidlo values(new s_trieda_"+trieda+"('"+param1+"',"+nosnost+","+cena+","+znacka+","+datum_vyroby+nieAutoParam+"));\n";
            try {
                writer.write(sql);
            } catch (IOException ex) {
                Logger.getLogger(GeneratorDat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(GeneratorDat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
