package utils;

import entity.Biodata;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ActionManagerUtil {
    private JTextField textFieldNama, textFieldNomorHP;
    private JRadioButton radio1;
    private JTextArea textAreaAlamat;
    private TableManagerUtil tableModel;

    public ActionManagerUtil(JTextField textFieldNama, JTextField textFieldNomorHP, JRadioButton radio1, JTextArea textAreaAlamat, TableManagerUtil tableModel) {
        this.textFieldNama = textFieldNama;
        this.textFieldNomorHP = textFieldNomorHP;
        this.radio1 = radio1;
        this.textAreaAlamat = textAreaAlamat;
        this.tableModel = tableModel;
    }

    public void warning() {
        if (textFieldNama.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (textFieldNomorHP.getText().isEmpty() || !textFieldNomorHP.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Nomor HP tidak boleh kosong dan Harus Angka", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else if (textAreaAlamat.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Alamat tidak boleh kosong", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Biodata.txt"));

            ArrayList <ArrayList<String>> data = tableModel.getData();

            for (ArrayList<String> row : data) {
                for (String cell : row) {
                    writer.write(cell + "\t");
                }
                writer.newLine();
            }

            writer.close();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke file\nCek file Biodata.txt di folder project");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan ke file");
        }
    }

    public ActionListener createSaveAction() {
        return e -> {
            warning();

            String nama = textFieldNama.getText();
            String nomorHP = textFieldNomorHP.getText();
            String jenisKelamin = radio1.isSelected() ? "Laki-laki" : "Perempuan";
            String alamat = textAreaAlamat.getText();

            if (nama.isEmpty() || nomorHP.isEmpty() || alamat.isEmpty() || !nomorHP.matches("[0-9]+")) {
                return;
            }

            int validation = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menyimpan data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (validation == JOptionPane.YES_OPTION) {
                Biodata data = new Biodata(nama, nomorHP, jenisKelamin, alamat);
                tableModel.addRow(data.toArrayList());

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            } else {
                JOptionPane.showMessageDialog(null, "Anda membatalkan menyimpan data");
            }
            textFieldNama.setText("");
            textFieldNomorHP.setText("");
            textAreaAlamat.setText("");
        };
    }

    public ActionListener createEditAction() {
        return e -> {
            String idString = JOptionPane.showInputDialog("Masukkan ID yang ingin diedit:");
            if(idString != null) {
                int id = Integer.parseInt(idString) - 1;
                if(id >= 0 && id < tableModel.getRowCount()) {
                    ArrayList<String> existingValue = tableModel.getRow(id);

                    InputDialogManagerUtil dialogManager = new InputDialogManagerUtil();
                    ArrayList<String> newValue = dialogManager.showEditDialog(existingValue);

                    if(newValue != null) {

                        if (newValue.get(0).isEmpty() || newValue.get(1).isEmpty() || newValue.get(2).isEmpty() || newValue.get(3).isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Harap isi semua data");
                        }
                        newValue.add(0, idString);

                        tableModel.editRow(id, newValue);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"ID tidak valid");
                }
            }
        };
    }

    public ActionListener createSaveFileAction() {
        return e -> {
            int validation = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menyimpan data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (validation == JOptionPane.YES_OPTION) {
                saveToFile();
            } else {
                JOptionPane.showMessageDialog(null, "Anda membatalkan menyimpan data");
            }
        };
    }

    public ActionListener createClearAction() {
        return e -> {
            int validation = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus semua data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (validation == JOptionPane.YES_OPTION) {
                tableModel.clearTable();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            } else {
                JOptionPane.showMessageDialog(null, "Anda membatalkan menghapus data");
            }
        };
    }

}
