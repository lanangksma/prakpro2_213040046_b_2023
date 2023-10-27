package utils;

import entity.Biodata;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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
        } else if (!radio1.isSelected() && !radio1.isSelected()) {
            JOptionPane.showMessageDialog(null, "Jenis kelamin harus dipilih", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (textAreaAlamat.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Alamat tidak boleh kosong", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public ActionListener createSaveAction() {
        return e -> {
            int validation = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menyimpan data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (validation == JOptionPane.YES_OPTION) {
                String nama = textFieldNama.getText();
                String nomorHP = textFieldNomorHP.getText();
                String jenisKelamin = radio1.isSelected() ? "Laki-laki" : "Perempuan";
                String alamat = textAreaAlamat.getText();

                if (nama.isEmpty() || nomorHP.isEmpty() || jenisKelamin.isEmpty() || alamat.isEmpty() || !nomorHP.matches("[0-9]+")) {
                    warning();
                    return;
                }

                Biodata data = new Biodata(nama, nomorHP, jenisKelamin, alamat);
                tableModel.addRow(data.toArrayList());

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            } else {
                JOptionPane.showMessageDialog(null, "Anda membatalkan menyimpan data");
            }
        };
    }

}
