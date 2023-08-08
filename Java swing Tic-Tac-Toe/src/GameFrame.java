import java.awt.Font;
import javax.swing.*;

public class GameFrame extends JFrame
{
    static public JLabel label = new JLabel("Player turn: ");
    JPanel panel = new GamePanel();

    GameFrame()
    {
        label.setFont(new Font("Ink Free", Font.BOLD, 30));
        label.setBounds(5, 0, 500, 50);
        panel.setBounds(0, 50, 500, 500);

        this.setLayout(null);
        this.setSize(516, 590);
        this.add(label);
        this.add(panel);
        this.setTitle("Tic-Tac-Toe");
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        
        this.setVisible(true);
    }

    
}
