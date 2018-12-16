package TableModels;


import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author folko
 * TRIEDA JE MODELOM PRE TABULKU, DO KTOREJ SA VKLADAJU VOZDILA
 */
public class TableModelVehicles extends AbstractTableModel{
    private String[] collNames = {"Majitel","Max. Nosnost","Cena","Rok vyroby","Znacka"};
    private Object[][] data;

    public TableModelVehicles(Object[][] pData) {
        this.data = pData;
    }

    @Override
    public int getRowCount() {
        return this.data.length;
    }

    @Override
    public int getColumnCount() {
        return this.collNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.data[rowIndex][columnIndex];
    }
    
    @Override
    public String getColumnName(int col) {
      return this.collNames[col];
    }

    public String[] getCollNames() {
        return collNames;
    }

    public void setCollNames(String[] collNames) {
        this.collNames = collNames;
    }

    public Object[][] getData() {
        return data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }
    
    
}
