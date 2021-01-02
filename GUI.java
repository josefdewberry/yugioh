package yugioh;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import yugioh.CardDisplay.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class GUI {
    
    public GUI() {

        JFrame frame = new JFrame();

        JTextArea textArea = new JTextArea(CardDisplay.allCardNames(), 5, 26);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);

        scrollPane.setBounds(497, 0, 304, 551);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Yu-Gi-Oh! Cards");
        frame.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);

        frame.add(scrollPane);
    }

    public static void main(String[] args) {
        new GUI();
    }
}