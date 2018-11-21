/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralka1;

import generatorDat.GeneratorDat;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author folko
 */
public class Jadro {
    private DBmanipulation dbManipulation;
    private GeneratorDat generator;
    
    public Jadro() {
        try {
            this.dbManipulation = new DBmanipulation();
            this.generator = new GeneratorDat();
        } catch (IOException ex) {
            System.err.println("Chyba v jadre!");
            System.err.println(ex.toString());
        }
        
    }

    public DBmanipulation getDbManipulation() {
        return dbManipulation;
    }

    
    
}
