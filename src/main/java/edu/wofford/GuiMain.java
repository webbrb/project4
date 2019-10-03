package edu.wofford;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;


public class GuiMain extends JFrame implements ActionListener {
    private JLabel result;
    private JButton location00;
    private JButton location01;
    private JButton location02;
    private JButton location10;
    private JButton location11;
    private JButton location12;
    private JButton location20;
    private JButton location21;
    private JButton location22;

    private enum Move {Xmove, Omove};
    private Move PlayersMove;

    JFrame frame = new JFrame("Tic Tac Toe");

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == result){
            System.out.println("result button clicked");
        }
        else if (event.getSource() == location00){
            if((PlayersMove == Move.Xmove) && location00.getText().equals("")){
                location00.setText("X");
            }
        }
        else if (event.getSource() == location00) {
            if((PlayersMove == Move.Omove) && location00.getText().equals(""){
                location00.setText("O");
            }
        }



    }
    
    public GuiMain() {
        setTitle("Tic Tac Toe");
        setLayout(new GridLayout(3,3));
        location00 = new JButton("");
        location00.addActionListener(this);
        location01 = new JButton("");
        location01.addActionListener(this);
        location02 = new JButton("");
        location02.addActionListener(this);
        location10 = new JButton("");
        location10.addActionListener(this);
        location11 = new JButton("");
        location11.addActionListener(this);
        location12 = new JButton("");
        location12.addActionListener(this);
        location20 = new JButton("");
        location20.addActionListener(this);
        location21 = new JButton("");
        location21.addActionListener(this);
        location22 = new JButton("");
        location22.addActionListener(this);

        add(location00);
        add(location01);
        add(location02);
        add(location10);
        add(location11);
        add(location12);
        add(location20);
        add(location21);
        add(location22);
        pack();

    }

    
	public static void main(String[] args) {
	    GuiMain window = new GuiMain();
        window.setVisible(true);
	}
}