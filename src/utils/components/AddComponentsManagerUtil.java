package utils.components;

import javax.swing.*;

public class AddComponentsManagerUtil {
    private JFrame frame;

    public AddComponentsManagerUtil(JFrame frame){
        this.frame = frame;
    }

    public void add(JComponent... components){
        for (JComponent component : components) {
            frame.add(component);
        }
    }
}

