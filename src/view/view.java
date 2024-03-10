package view;

import javax.swing.*;
import controller.controller;

public class view {
public static void main(String[] args) {
        JFrame frame = new JFrame("Scholar Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        JLabel querySearchLabel = new JLabel("Título:");
        JTextField querySearchField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        panel.add(querySearchLabel);
        panel.add(querySearchField);
        panel.add(searchButton);

        frame.add(panel);
        frame.setVisible(true);

        controller controllerInstance = new controller();

        searchButton.addActionListener(e -> {
            String apiKey = "3d6be67e2ca53c5d98397368a4a2b3587c4963d3e5c9f5126ad18f3efc83ef23";
            controllerInstance.fetchScholarData(apiKey, querySearchField.getText());
        });
    }
}
