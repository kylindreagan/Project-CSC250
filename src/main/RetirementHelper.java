/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JTextField;

/**
 *
 * @author kylin
 */
public class RetirementHelper {
    public static void clearAllTextFields(Container container) {
        for (Component component : container.getComponents()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            } else if (component instanceof Container) {
                // Recursively check nested containers (if any)
                clearAllTextFields((Container) component);
            }
        }
    }
}
