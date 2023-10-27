package view;

import javax.swing.*;

import entity.Biodata;
import utils.AddComponentsUtil;
import utils.TableUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BiodataView extends JFrame {

    public BiodataView() {

        // Menutup aplikasi saat mengklik tombol close
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelNama = new JLabel("Nama: ");
        labelNama.setBounds(15, 40, 350, 10);

        JTextField  textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        JLabel labelNomorHP = new JLabel("Nomor HP: ");
        labelNomorHP.setBounds(15, 100, 350, 10);

        JTextField textFieldNomorHP = new JTextField();
        textFieldNomorHP.setBounds(15, 120, 350, 30);

        JLabel labelJenisKelamin = new JLabel("Jenis Kelamin: ");
        labelJenisKelamin.setBounds(15, 160, 350, 10);

        JRadioButton radio1 = new JRadioButton("Laki-laki");
        radio1.setBounds(15, 170, 350, 30);

        JRadioButton radio2 = new JRadioButton("Perempuan");
        radio2.setBounds(15, 190, 350, 30);

        JLabel labelAlamat = new JLabel("Alamat: ");
        labelAlamat.setBounds(15, 230, 350, 10);

        JTextArea textAreaAlamat = new JTextArea();
        textAreaAlamat.setBounds(15, 250, 350, 100);
        textAreaAlamat.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);

        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(15, 370, 120, 40);
        btnSimpan.setLayout(new FlowLayout());

        JButton btnEdit = new JButton("Edit");
        btnEdit.setBounds(140, 370, 120, 40);

        JButton btnHapus = new JButton("Hapus");
        btnHapus.setBounds(265, 370, 120, 40);

        JButton btnSimpanFile = new JButton("Simpan Ke File");
        btnSimpanFile.setBounds(390, 370, 120, 40);

        javax.swing.JTable table = new javax.swing.JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(15, 420, 800, 300);

        TableUtil tableModel = new TableUtil();
        table.setModel(tableModel);

        btnSimpan.addActionListener(e -> {
            int validation = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menyimpan data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (validation == JOptionPane.YES_OPTION) {
                String nama = textFieldNama.getText();
                String nomorHP = textFieldNomorHP.getText();
                String jenisKelamin = radio1.isSelected() ? "Laki-laki" : "Perempuan";
                String alamat = textAreaAlamat.getText();

                Biodata data = new Biodata(nama, nomorHP, jenisKelamin, alamat);
                tableModel.addRow(data.toArrayList());

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            } else {
                JOptionPane.showMessageDialog(null, "Anda membatalkan menyimpan data");
            }
        });

        AddComponentsUtil addComponentsUtil = new AddComponentsUtil(this);
        addComponentsUtil.add(
                labelNama,
                textFieldNama,
                labelNomorHP,
                textFieldNomorHP,
                labelJenisKelamin,
                radio1,
                radio2,
                labelAlamat,
                textAreaAlamat,
                scrollPane,
                btnSimpan,
                btnEdit,
                btnHapus,
                btnSimpanFile
        );

        this.setSize(1000, 800);
        this.setLayout(null);
    }
}
