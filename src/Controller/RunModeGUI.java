package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


import View.*;
import Entity.Model;

public class RunModeGUI extends JFrame {

	private Board board;
	private JMenu fileMenu;
	private JMenuBar menubar;
	private JMenuItem Quit;
	private Model m;
//	private ActionListener listener;
//	private ShootBallListener listener1;
//	private SwitchToBuildListener listener2;
//	private QuitMenuListener quitMenuListener;

	public RunModeGUI(Model m) {

		super("Gizmoball");

		this.m = m;

		board = new Board(600, 600, m);
		fileMenu = new JMenu("Menu");
		menubar = new JMenuBar();
		menubar.add(fileMenu);
		setJMenuBar(menubar);
		Quit = new JMenuItem("Quit");
		fileMenu.add(Quit);
//		listener = new RunListener(m);
//		listener1 = new ShootBallListener(m);
//		listener2 = new SwitchToBuildListener(m, this);
//		quitMenuListener = new QuitMenuListener(m);

		setSize(517, 597);
		//setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cPane = getContentPane();

		Font gf = new Font("Arial", Font.BOLD, 12);

		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());


		JButton bt_start = new JButton("Start");
//		bt_start.addActionListener(listener);
		bt_start.setFont(gf);
		bt_start.setFocusable(false);
		buttons.add(bt_start);

		JButton bt_build = new JButton("Build");
//		bt_build.addActionListener(listener2);
		bt_build.setFont(gf);
		bt_build.setFocusable(false);
		buttons.add(bt_build);

		JButton bt_stop = new JButton("Stop");
		//bt_stop.addActionListener(listener);
		bt_stop.setFont(gf);
		bt_stop.setFocusable(false);
		buttons.add(bt_stop);



		cPane.add(buttons, BorderLayout.NORTH);
		cPane.add(board, BorderLayout.CENTER);

//
//		this.addKeyListener(listener1);

		setVisible(true);
	}

	public void close(){
		setVisible(false);
	}

}