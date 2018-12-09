package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import Entity.Absorber;
import Entity.Ball;
import Entity.CircleBarrier;
//import View.BuildGUI;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

public class BuildModeGUI extends JFrame{

//    private Board board;
//    private Grid grid;
    private JMenu fileMenu;
    private JMenuBar menuBar;
    private JMenuItem Clear, Load, Save, Quit;
    private JLayeredPane lpane = new JLayeredPane();
    private String path = "";
    private OperationListener operationListener;
    private EntityListener entityListener;
    private Model m;

    EntityListener el;
    OperationListener ol;


    public BuildModeGUI(Model m) {
        super("Gizmoball");

        this.m = m;
        fileMenu = new JMenu("Menu");

        /**
         * 选项栏：清除、加载、保存、退出布局
         */
        menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        Clear = new JMenuItem("Clear");
        fileMenu.add(Clear);
        Load = new JMenuItem("Load");
        fileMenu.add(Load);
        Save = new JMenuItem("Save");
        fileMenu.add(Save);
        Quit = new JMenuItem("Quit");
        fileMenu.add(Quit);

        System.out.println("Succeed in showing menu");
        /**
         * 绑定一系列listener监听器
         */
        operationListener = new OperationListener(m);
        Clear.addActionListener(operationListener);
        Load.addActionListener(operationListener);
        Save.addActionListener(operationListener);
        Quit.addActionListener(operationListener);
        System.out.println("succeed in binding operationListener");


        /**
         * 设置尺寸
         */


        /**
         * 设置Gizmo在build模式下的buttons
         */
        JPanel buttons = new JPanel();
        //格状布局
        buttons.setLayout(new GridLayout(2,6));

        /**
         * @param bt_run 运行按钮
         */
        JButton bt_run = new JButton("Run");
        bt_run.addActionListener(entityListener);
        bt_run.setFocusable(false);
        buttons.add(bt_run);


        /**
         * @param bt_delete 删除按钮
         */
        JButton bt_delete = new JButton("Delete");
        ImageIcon ic_delete = new ImageIcon("/icons/bt-delete.png");
        bt_delete.setIcon(ic_delete);
        bt_delete.setPreferredSize(new Dimension(20, 20));
        bt_delete.addActionListener(entityListener);
        bt_delete.setFocusable(false);
        bt_delete.setBackground(Color.BLUE);
        buttons.add(bt_delete);


        /**
         * @param bt_rotate 旋转按钮
         */
        JButton bt_rotate = new JButton("Rotate");
        ImageIcon ic_rotate = new ImageIcon("/icons/bt-rotate.png");
        bt_rotate.setIcon(ic_rotate);
        bt_rotate.setPreferredSize(new Dimension(20, 20));
        bt_rotate.addActionListener(entityListener);
        bt_rotate.setFocusable(false);
        buttons.add(bt_rotate);

        /**
         * @param bt_move 移动按钮
         */
        JButton bt_move = new JButton("Rotate");
        ImageIcon ic_move = new ImageIcon("/icons/bt-move.png");
        bt_move.setIcon(ic_move);
        bt_move.setPreferredSize(new Dimension(20, 20));
        bt_move.addActionListener(entityListener);
        bt_move.setFocusable(false);
        buttons.add(bt_move);

        /**
         * @param bt_square 方形障碍物
         */
        JButton bt_square = new JButton("Square");
        ImageIcon ic_square = new ImageIcon("/icons/ic-square.png");
        bt_square.setIcon(ic_square);
        bt_square.setPreferredSize(new Dimension(20, 20));
        bt_square.addActionListener(entityListener);
        bt_square.setFocusable(false);
        buttons.add(bt_square);

        /**
         * @param bt_triangle 三角形障碍物
         */
        JButton bt_triangle = new JButton("Triangle");
        ImageIcon ic_triangle = new ImageIcon("/icons/ic-triangle.png");
        bt_triangle.setIcon(ic_triangle);
        bt_triangle.setPreferredSize(new Dimension(20, 20));
        bt_triangle.addActionListener(entityListener);
        bt_triangle.setFocusable(false);
        buttons.add(bt_triangle);

        /**
         * @param bt_circle 圆形障碍物
         */
        JButton bt_circle = new JButton("Circle");
        ImageIcon ic_circle = new ImageIcon("/icons/ic-circle.png");
        bt_circle.setIcon(ic_circle);
        bt_circle.setPreferredSize(new Dimension(20, 20));
        bt_circle.addActionListener(entityListener);
        bt_circle.setFocusable(false);
        buttons.add(bt_circle);

        /**
         * @param bt_absorber 吸收板
         */
        JButton bt_absorber = new JButton("Absorber");
        ImageIcon ic_absorber = new ImageIcon("/icons/ic-absorber.png");
        bt_absorber.setIcon(ic_absorber);
        bt_absorber.setPreferredSize(new Dimension(20, 20));
        bt_absorber.addActionListener(entityListener);
        bt_absorber.setFocusable(false);
        buttons.add(bt_absorber);


        /**
         * @param bt_lflipper 左侧挡板
         */
        JButton bt_lflipper = new JButton("LFlipper");
        ImageIcon ic_lflipper = new ImageIcon("/icons/ic-left-flipper.png");
        bt_lflipper.setIcon(ic_lflipper);
        bt_lflipper.setPreferredSize(new Dimension(20, 20));
        bt_lflipper.addActionListener(entityListener);
        bt_lflipper.setFocusable(false);
        buttons.add(bt_lflipper);

        /**
         * @param bt_rflipper 右侧挡板
         */
        JButton bt_rflipper = new JButton("RFlipper");
        ImageIcon ic_rflipper = new ImageIcon("/icons/ic-right-flipper.png");
        bt_rflipper.setIcon(ic_rflipper);
        bt_rflipper.setPreferredSize(new Dimension(20, 20));
        bt_rflipper.addActionListener(entityListener);
        bt_rflipper.setFocusable(false);
        buttons.add(bt_rflipper);

        /**
         * @param ball 小球
         */
        JButton ball = new JButton("Ball");
        ImageIcon ic_ball = new ImageIcon("/icons/ic-ball.png");
        ball.setIcon(ic_ball);
        ball.setPreferredSize(new Dimension(20, 20));
        ball.addActionListener(entityListener);
        ball.setFocusable(false);
        buttons.add(ball);

        setVisible(true);
        System.out.println("Succeed in showing button");
        
        
        
    }

    public void close(){
        setVisible(false);
    }
    

}







//package Controller;
//
//import java.util.ArrayList;
//
//import Entity.Absorber;
//import Entity.Ball;
//import Entity.CircleBarrier;
//import Entity.RotatedFlipper;
//import Entity.SquareBarrier;
//import Entity.StaticFlipper;
//import Entity.TriangleBarrier;
//import ViewIcon.Board;
//
//
//
//public class BuildModeGUI {
//
//	private Board board;
//	private ArrayList<Absorber> absorbers;
//	private ArrayList<Ball> balls;
//	private ArrayList<CircleBarrier> circleBarriers;
//	private ArrayList<RotatedFlipper> rotatedFlipers;
//	private ArrayList<SquareBarrier> squareBarriers;
//	private ArrayList<StaticFlipper> staticFlippers;
//	private ArrayList<TriangleBarrier> triangleBarriers;
//	
//	//初始化界面
//	public BuildModeGUI() {
//		
//		board = new Board();
//		
//		absorbers = new ArrayList<>();
//		balls = new ArrayList<>();
//		circleBarriers = new ArrayList<>();
//		rotatedFlipers = new ArrayList<>();
//		squareBarriers = new ArrayList<>();
//		staticFlippers = new ArrayList<>();
//		triangleBarriers = new ArrayList<>();
//	}
//	
//	
//	
//	public ArrayList<Absorber> getAbsorbers() {
//		return absorbers;
//	}
//
//	public void addAbsorbers(Absorber absorber) {
//		this.absorbers.add(absorber);
//	}
//
//	public ArrayList<Ball> getBalls() {
//		return balls;
//	}
//
//	public void addBalls(Ball ball) {
//		this.balls.add(ball);
//	}
//
//	public ArrayList<CircleBarrier> getCircleBarriers() {
//		return circleBarriers;
//	}
//
//	public void addCircleBarriers(CircleBarrier circleBarrier) {
//		this.circleBarriers.add(circleBarrier);
//	}
//
//	public ArrayList<RotatedFlipper> getRotatedFlipers() {
//		return rotatedFlipers;
//	}
//
//	public void addRotatedFlipers(RotatedFlipper rotatedFliper) {
//		this.rotatedFlipers.add(rotatedFliper);
//	}
//
//	public ArrayList<SquareBarrier> getSquareBarriers() {
//		return squareBarriers;
//	}
//
//	public void addSquareBarriers(SquareBarrier squareBarrier) {
//		this.squareBarriers.add(squareBarrier);
//	}
//
//	public ArrayList<StaticFlipper> getStaticFlippers() {
//		return staticFlippers;
//	}
//
//	public void addStaticFlippers(StaticFlipper staticFlipper) {
//		this.staticFlippers.add(staticFlipper);
//	}
//
//	public ArrayList<TriangleBarrier> getTriangleBarriers() {
//		return triangleBarriers;
//	}
//
//	public void addTriangleBarriers(TriangleBarrier triangleBarrier) {
//		this.triangleBarriers.add(triangleBarrier);
//	}
//
//	public void designMode() {
//		
//	}
//	

    //停止游戏
//	public void stopBalls(){
//		for(Ball b : balls){
//			b.setStopped();
//		}
//	}
//	
    //小球开始运动，游戏开始
//	public void startBalls(){
//			for(Ball b : balls){
//				b.start();
//			}
//	}
//
//}
