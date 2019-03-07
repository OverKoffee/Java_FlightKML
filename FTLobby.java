/*

Class updated by Redmal on 3/6/2019.

 */

import javax.swing.*;
import java.awt.*;

public class FTLobby {
    private JFrame frame;
    private JTextField coords_A = new TextPrompt<JTextField>("Enter first " +
                                                        "coords...", new JTextField("")).getTextPrompt();
    private JTextField coords_B = new TextPrompt<JTextField>("Enter second " +
                                                        "coords...", new JTextField("")).getTextPrompt();
    private JTextArea aircraftCoords = new TextPrompt<JTextArea>("Enter list " +
                                                        "list of coords...", new JTextArea("")).getTextPrompt();
    private JButton btn_GetKML = new JButton("Get KML");
    private BuildKML buildKML;

    public FTLobby(){
        frame = new JFrame("Flight Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(addLobbyComponents(), BorderLayout.CENTER);
        frame.setSize(500,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel addLobbyComponents(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        configureComponents();
        panel.add(coords_A);
        panel.add(coords_B);
        panel.add(aircraftCoords);
        panel.add(btn_GetKML);
        return panel;
    }

    public void configureComponents(){
        // first and second set of coordinates
        coords_A.setBackground(Color.WHITE);
        coords_A.setColumns(15);

        coords_B.setBackground(Color.WHITE);
        coords_B.setColumns(15);

        // list of coordinates
        aircraftCoords.setBackground(Color.lightGray);
        aircraftCoords.setColumns(31);
        aircraftCoords.setRows(5);

        // button to create and access a built KML file
        btn_GetKML.setPreferredSize(new Dimension(342, 40));
        btn_GetKML.addActionListener(e -> {
            buildKML = new BuildKML(aircraftCoords.getText());
        });
    }
}
