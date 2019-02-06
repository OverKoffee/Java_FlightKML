import javax.swing.*;
import java.awt.*;

public class FTLobby {
    private JFrame frame;
    private JTextField aircraftType = new JTextField("");
    private JTextArea aircraftCoords = new JTextArea("");

    public FTLobby(){
        frame = new JFrame("Lobby");
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
        panel.add(aircraftType);
        panel.add(aircraftCoords);
        return panel;
    }

    public void configureComponents(){
        aircraftType.setBackground(Color.darkGray);
        aircraftCoords.setBackground(Color.magenta);
    }
}
