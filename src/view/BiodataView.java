package view;

import javax.swing.*;

import entity.Biodata;
import utils.ActionManagerUtil;
import utils.components.AddComponentsManagerUtil;
import utils.components.ComponentManagerUtil;
import utils.TableManagerUtil;

public class BiodataView extends JFrame {
    private ComponentManagerUtil componentManager;
    private ActionManagerUtil actionManager;
    private JLabel labelNama, labelNomorHP, labelJenisKelamin, labelAlamat;
    private JTextField textFieldNama, textFieldNomorHP;
    private JRadioButton radio1, radio2;
    private JTextArea textAreaAlamat;
    private JScrollPane scrollPane;
    private JButton btnSimpan, btnEdit, btnHapus, btnSimpanFile;
    private JTable table;
    private TableManagerUtil tableUtil;
    private TableManagerUtil tableModel;

    public BiodataView() {
        componentManager = new ComponentManagerUtil();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents();
        addActionListeners();
        addComponentsToFrame();
        this.setSize(1000, 800);
        this.setLayout(null);
    }

    public void initializeComponents() {
        labelNama = componentManager.createLabel("Nama: ", 15, 40);
        textFieldNama = componentManager.createTextField(15, 60);

        labelNomorHP = componentManager.createLabel("Nomor HP: ", 15, 100);
        textFieldNomorHP = componentManager.createTextField(15, 120);

        labelJenisKelamin = componentManager.createLabel("Jenis Kelamin: ", 15, 160);
        radio1 = componentManager.createRadioButton("Laki-laki", 15, 170);
        radio2 = componentManager.createRadioButton("Perempuan", 15, 190);

        labelAlamat = componentManager.createLabel("Alamat: ", 15, 230);
        textAreaAlamat = componentManager.createTextArea(15, 250);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);

        btnSimpan = componentManager.createButton("Simpan", 15, 370);
        btnEdit = componentManager.createButton("Edit", 140, 370);
        btnHapus = componentManager.createButton("Hapus", 265, 370);
        btnSimpanFile = componentManager.createButton("Simpan Ke File", 390, 370);

        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(15, 420, 800, 300);

        tableModel = new TableManagerUtil();
        table.setModel(tableModel);
    }

    public void addActionListeners() {
        actionManager = new ActionManagerUtil(
                textFieldNama,
                textFieldNomorHP,
                radio1,
                textAreaAlamat,
                tableModel
        );

        btnSimpan.addActionListener(actionManager.createSaveAction());
    }

    public void addComponentsToFrame() {
        AddComponentsManagerUtil addComponentsUtil = new AddComponentsManagerUtil(this);

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
    }
}
