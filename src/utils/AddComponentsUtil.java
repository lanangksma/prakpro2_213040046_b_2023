package utils;

import javax.swing.*;

public class AddComponentsUtil {
    private JFrame frame;

    public AddComponentsUtil(JFrame frame){
        this.frame = frame;
    }

    public void add(JComponent... components){
        for (JComponent component : components) {
            frame.add(component);
        }
    }
}

