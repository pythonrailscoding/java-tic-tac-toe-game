import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player_1_turn;
    boolean it_is_not_tie = true;

    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic-Tac-Toe");
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);
        title_panel.add(textField);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        for(int count=0; count < 9; count++) {
            buttons[count] = new JButton();
            button_panel.add(buttons[count]);
            buttons[count].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[count].setFocusable(false);
            buttons[count].addActionListener(this);
            buttons[count].setEnabled(false);
        }

        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<9; i++) {
            if(e.getSource() == buttons[i]) {
                if(player_1_turn) {
                    if(buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player_1_turn = false;
                        textField.setText("O-Turn");
                    }
                } else {
                    if(buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player_1_turn = true;
                        textField.setText("X-Turn");
                    }
                }
                check();
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
            for(int i=0; i<9; i++) {
                buttons[i].setEnabled(false);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            textField.setText("Loading...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            textField.setText("Determining Turns..");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(random.nextInt(2)==0) {
            player_1_turn = true;
            textField.setText("X-Turn");
            for(int i=0; i<9; i++) {
                buttons[i].setEnabled(true);
            }
        } else {
            player_1_turn = false;
            textField.setText("O-Turn");
            for(int i=0; i<9; i++) {
                buttons[i].setEnabled(true);
            }
        }
    }

    public void check() {
        if(
                (buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && buttons[2].getText().equals("X")
        ) {
            XWins(0, 1, 2);
        }
        else if(
                (buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && buttons[5].getText().equals("X")
        ) {
            XWins(3, 4, 5);
        }
        else if(
                (buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && buttons[8].getText().equals("X")
        ) {
            XWins(6, 7, 8);
        }
        else if(
                (buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && buttons[6].getText().equals("X")
        ) {
            XWins(0, 3, 6);
        }
        else if(
                (buttons[1].getText().equals("X")) && (buttons[4].getText().equals("X")) && buttons[7].getText().equals("X")
        ) {
            XWins(1, 4, 7);
        }
        else if(
                (buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && buttons[8].getText().equals("X")
        ) {
            XWins(2, 5, 8);
        }
        else if(
                (buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && buttons[8].getText().equals("X")
        ) {
            XWins(0, 4, 8);
        }
        else if(
                (buttons[2].getText().equals("X")) && (buttons[4].getText().equals("X")) && buttons[6].getText().equals("X")
        ) {
            XWins(2, 4, 6);
        }
        else if(
                (buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && buttons[2].getText().equals("O")
        ) {
            OWins(0, 1, 2);
        }
        else if(
                (buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O")) && buttons[5].getText().equals("O")
        ) {
            OWins(3, 4, 5);
        }
        else if(
                (buttons[6].getText().equals("O")) && (buttons[7].getText().equals("O")) && buttons[8].getText().equals("O")
        ) {
            OWins(6, 7, 8);
        }
        else if(
                (buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && buttons[6].getText().equals("O")
        ) {
            OWins(0, 3, 6);
        }
        else if(
                (buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && buttons[7].getText().equals("O")
        ) {
            OWins(1, 4, 7);
        }
        else if(
                (buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && buttons[8].getText().equals("O")
        ) {
            OWins(2, 5, 8);
        }
        else if(
                (buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && buttons[8].getText().equals("O")
        ) {
            OWins(0, 4, 8);
        }
        else if(
                (buttons[2].getText().equals("O")) && (buttons[4].getText().equals("O")) && buttons[6].getText().equals("O")
        ) {
            OWins(2, 4, 6);
        }
        else if(it_is_not_tie) {
            if (
                    (!buttons[0].getText().isEmpty()) &&
                    (!buttons[1].getText().isEmpty()) &&
                    (!buttons[2].getText().isEmpty()) &&
                    (!buttons[3].getText().isEmpty()) &&
                    (!buttons[4].getText().isEmpty()) &&
                    (!buttons[5].getText().isEmpty()) &&
                    (!buttons[6].getText().isEmpty()) &&
                    (!buttons[7].getText().isEmpty())
            ) {
                itIsTie();
            }
        }
    }

    public void XWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0; i<9; i++) {
            buttons[i].setEnabled(false);
        }

        textField.setText("X-Wins!!!!!");
        textField.setForeground(Color.WHITE);
        textField.setBackground(new Color(255, 0, 0));
        it_is_not_tie = false;
    }

    public void OWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0; i<9; i++) {
            buttons[i].setEnabled(false);
        }

        textField.setText("O-Wins!!!!!");
        textField.setForeground(Color.WHITE);
        textField.setBackground(new Color(0, 0, 255));
        it_is_not_tie = true;
    }
    public void itIsTie() {
        textField.setText("It's a Tie");
        textField.setForeground(Color.WHITE);

        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
    }
}
