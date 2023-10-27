package utils.components;

import javax.swing.*;
import java.awt.*;

public class ComponentManagerUtil {
    public JLabel createLabel(String text, int x, int y){
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 350, 10);
        return label;
    }

    public JTextField createTextField(int x, int y){
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 350, 30);
        return textField;
    }

    public JRadioButton createRadioButton(String text, int x, int y){
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setBounds(x, y, 350, 30);
        return radioButton;
    }

    public JTextArea createTextArea(int x, int y){
        JTextArea textArea = new JTextArea();
        textArea.setBounds(x, y, 350, 100);
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return textArea;
    }

    public JButton createButton(String text, int x, int y){
        JButton button = new JButton(text);
        button.setBounds(x, y, 120, 40);
        return button;
    }
}
