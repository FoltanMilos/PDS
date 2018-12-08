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
    private DBmanipulation db;

    public GeneratorDat() throws FileNotFoundException, IOException {
        this.rnd = new Random();
        //this.rnd.setSeed(10);
        this.menaMuzi = new String[195];
        this.menaZeny = new String[218];
        this.priezviska = new String[50];
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
        Object[] osoby = db.getOsoby();
        BufferedWriter writer = null;
        String csvFile = "Zamestnanci.dat";
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
        } catch (IOException ex) {
            Logger.getLogger(GeneratorDat.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 1; i <= pocet; i++){
            //Upratovačka, Údržbár, Vrátnik, Skladník, Zamestnanec, Vedúci oddelenia, Zákaznícka podpora, Manažér, Účtovník
            double[] vahy = {0.1, 0.15, 0.17, 0.22, 0.82, 0.85, 0.92, 0.95};
            char[] dat_narodenia = ((Osoba)osoby[i]).getDatumNarodenia();
            char[] rod_cislo = ((Osoba)osoby[i]).getRod_cislo();
            int id_pozicie;
            if (i == 1) {
                id_pozicie = 1;
            } else {
                double rand = rnd.nextDouble();
                id_pozicie = 10;
                for(int j = 1; j < vahy.length; j++) {
                    if (rand >= vahy[j]){
                        id_pozicie = 10-j;
                        break;
                    }
                }
            }
            int rok_narodenia = 1900 + (int)dat_narodenia[8]*10 + (int)dat_narodenia[9];
            int datum_od = rok_narodenia + 18 + rnd.nextInt(10);
            int datum_do = 0;
            double rand = rnd.nextDouble();
            if (rand > 0.5) {
                datum_do = datum_od + rnd.nextInt(30);
            }
            String datum_do_string = (datum_do == 0) ? "" : String.valueOf(datum_od%100);
            String sql = String.valueOf(i) + "|" + String.valueOf(rod_cislo) + "|" + 
                String.valueOf(id_pozicie) + "|" + String.valueOf(datum_od%100) + "|" + 
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
}
