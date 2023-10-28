package utils;

import javax.swing.*;
import java.util.ArrayList;

public class InputDialogManagerUtil {
    public ArrayList<String> showEditDialog(ArrayList<String> existingValue) {
        JTextField fieldNama = new JTextField(existingValue.get(1));
        JTextField fieldNoHP = new JTextField(existingValue.get(2));
        JRadioButton radio1 = new JRadioButton("Laki-laki", existingValue.get(3).equals("Laki-laki"));
        JRadioButton radio2 = new JRadioButton("Perempuan", existingValue.get(3).equals("Perempuan"));

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);

        JTextArea textAreaAlamat = new JTextArea(existingValue.get(4), 5, 20);
        textAreaAlamat.setLineWrap(true);
        textAreaAlamat.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textAreaAlamat);

        Object[] message = {
                "Nama:", fieldNama,
                "No HP:", fieldNoHP,
                "Jenis Kelamin:", radio1, radio2,
                "Alamat:", scrollPane
        };

        int option;
        ArrayList<String> newValue;

        do {
            option = JOptionPane.showConfirmDialog(null, message, "Edit", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.CANCEL_OPTION) {
                return null; // Pengguna membatalkan dialog
            }

            newValue = new ArrayList<>();
            newValue.add(fieldNama.getText());
            newValue.add(fieldNoHP.getText());
            newValue.add(radio1.isSelected() ? "Laki-laki" : "Perempuan");
            newValue.add(textAreaAlamat.getText());

            if (newValue.get(0).isEmpty() || newValue.get(1).isEmpty() || newValue.get(2).isEmpty() || newValue.get(3).isEmpty() || !newValue.get(1).matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null, "Harap isi semua data\nNomor HP harus angka");
            }
        } while (newValue.get(0).isEmpty() || newValue.get(1).isEmpty() || newValue.get(2).isEmpty() || newValue.get(3).isEmpty() || !newValue.get(1).matches("[0-9]+"));

        return newValue;
    }
}
