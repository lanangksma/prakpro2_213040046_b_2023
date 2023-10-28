package utils;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableManagerUtil extends AbstractTableModel {

    private String[] columnNames = {"ID", "Nama", "No HP", "Jenis Kelamin", "Alamat"};
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        List<String> rowItem = data.get(rowIndex);
        return rowItem.get(columnIndex);
    }

    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void addRow(ArrayList<String> value) {
        value.add(0, String.valueOf(data.size() + 1));

        data.add(value);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void editRow(int rowIndex, ArrayList<String> newValue) {
        if(rowIndex >= 0 && rowIndex < getRowCount()) {
            data.set(rowIndex, newValue);
            fireTableRowsUpdated(rowIndex, rowIndex);
        }
    }

    public ArrayList<ArrayList<String>> getData() {
        return data;
    }

    public ArrayList<String> getRow(int rowIndex) {
        return data.get(rowIndex);
    }

    public void clearTable() {
        int rowCount = getRowCount();
        if(rowCount > 0) {
            data.clear();
            fireTableRowsDeleted(0, rowCount - 1);
        }
    }

}
