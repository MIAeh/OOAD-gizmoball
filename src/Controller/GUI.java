package Controller;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import Controller.OperationListener;
import Entity.Model;
import View.*;

public class GUI extends JFrame {

    private Board board;
    private JMenu fileMenu;
    private JMenuBar menubar;
    private Model m;
//    private ActionListener listener;
//    private ShootBallListener listener1;

    public GUI(Model m) {

        super("Gizmoball");

        this.m = m;

        board = new Board(600, 600, m);
        fileMenu = new JMenu("Menu");
        menubar = new JMenuBar();
        menubar.add(fileMenu);
        setJMenuBar(menubar);
//        listener = new RunListener(m);
//        listener1 = new ShootBallListener(m);

        setSize(517, 597);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cPane = getContentPane();

        Font gf = new Font("Arial", Font.BOLD, 12);

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());

        JButton bt_start = new JButton("Start");
//        bt_start.addActionListener(listener);
        bt_start.setFont(gf);
        bt_start.setFocusable(false);
        buttons.add(bt_start);

//        JButton bt_shoot = new JButton("Shoot ball");
////        bt_shoot.addActionListener(listener);
//        bt_shoot.setFont(gf);
//        bt_shoot.setFocusable(false);
//        buttons.add(bt_shoot);

        cPane.add(buttons, BorderLayout.NORTH);
        cPane.add(board, BorderLayout.CENTER);

//        this.addKeyListener(listener1);

        setVisible(true);
    }

}