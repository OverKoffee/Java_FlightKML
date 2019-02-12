import javax.swing.*;
import java.awt.*;

public class FTLobby {
    private JFrame frame;
    private JTextField coords_A = new JTextField("This is my first set of coords.");
    private JTextField coords_B = new JTextField("This is my second set of coords.");
    private JTextArea aircraftCoords = new JTextArea("This is my textarea.", 5, 31);
    private JButton btn_GetKML = new JButton("Get KML");

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
        return panel;
    }

    public void configureComponents(){
        coords_A.setBackground(Color.WHITE);
        coords_A.setColumns(15);

        coords_B.setBackground(Color.WHITE);
        coords_B.setColumns(15);

        aircraftCoords.setBackground(Color.lightGray);
    }
}
