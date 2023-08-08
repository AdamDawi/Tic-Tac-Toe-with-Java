import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener
{
    Font fontButton = new Font("Ink Free", Font.BOLD, 80);
    JButton[] buttons = new JButton[9];
    Random random = new Random();
    /* 
    turn = 0 -> X
    turn = 1 -> O
    */
    private int turn;
    private int turns=0;

    public GamePanel()
    {
        this.setLayout(new GridLayout(3, 3));
        
        for(int i=0; i<9; i++)
        {
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            buttons[i].setFocusable(false);
            buttons[i].setFont(fontButton);
            this.add(buttons[i]);
        }

        StartGame();
    }

    public void StartGame()
    {
        setFirstTurnLabel();
    }

    public void restartGame()
    {
        setFirstTurnLabel();
        turns=0;
        for(int i=0; i<9; i++)
        {
            buttons[i].setEnabled(true);
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setText("");
        } 
        GameFrame.label.setForeground(Color.BLACK); 
    }

    public void setFirstTurnLabel()
    {
        turn = random.nextInt(2);
        GameFrame.label.setText("Turn: " + getTurnLabel());
    }

    public void setNextTurnLabel()
    {
        turn = turn==0 ? 1 : 0;
        GameFrame.label.setText("Turn: " + getTurnLabel());
    }

    public String getTurnLabel()
    {
        if(turn == 0) return "X";
        return "O";
    }

    public void checkWin()
    {
        if(buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O") oWins(0, 1, 2);
        else if(buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O") oWins(3, 4, 5);
        else if(buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O") oWins(6, 7, 8);
        else if(buttons[0].getText() == "O" && buttons[3].getText() == "O" && buttons[6].getText() == "O") oWins(0, 3, 6);
        else if(buttons[1].getText() == "O" && buttons[4].getText() == "O" && buttons[7].getText() == "O") oWins(1, 4, 7);
        else if(buttons[2].getText() == "O" && buttons[5].getText() == "O" && buttons[8].getText() == "O") oWins(2, 5, 8);
        else if(buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O") oWins(0, 4, 8);
        else if(buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O") oWins(2, 4, 6);
        else if(buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X") xWins(0, 1, 2);
        else if(buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X") xWins(3, 4, 5);
        else if(buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X") xWins(6, 7, 8);
        else if(buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X") xWins(0, 3, 6);
        else if(buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X") xWins(1, 4, 7);
        else if(buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X") xWins(2, 5, 8);
        else if(buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X") xWins(0, 4, 8);
        else if(buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X") xWins(2, 4, 6);
        else if(turns==9) draw();
    }
    public void endGame()
    {
        for(int i=0; i<9; i++) buttons[i].setEnabled(false);
        int option = JOptionPane.showConfirmDialog(getComponentPopupMenu(), "Restart?","Tic-Tac-Toe", JOptionPane.YES_NO_OPTION); 
        if(option==0) restartGame();
    }

    public void xWins(int a, int b, int c)
    {
        GameFrame.label.setForeground(Color.green);
        GameFrame.label.setText("PLAYER X IS WINNER!");
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        endGame();
    }

    public void oWins(int a, int b, int c)
    {
        GameFrame.label.setForeground(Color.green);
        GameFrame.label.setText("PLAYER O IS WINNER!");
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        endGame();
    }

    public void draw()
    {
        GameFrame.label.setForeground(Color.DARK_GRAY);
        GameFrame.label.setText("DRAW!");
        endGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(((JButton)e.getSource()).getText() == "")
        {
            ((JButton)e.getSource()).setText(getTurnLabel());

            if(turn == 0) ((JButton)e.getSource()).setForeground(Color.BLUE);
            else ((JButton)e.getSource()).setForeground(Color.RED);

            turns++;
            setNextTurnLabel();
            checkWin();
        }
    }
    
}
