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

import javax.swing.*;

public class BuildModeGUI extends JFrame {

//    private Board board;
//    private Grid grid;
    private JMenu fileMenu;
    private JMenuBar menuBar;
    private JMenuItem Clear, Load, Save, Quit;
    private JLayeredPane lpane = new JLayeredPane();
    private String path = "";




    public BuildGUI(Model m) {

        super("Gizmoball");

//        this.m = m;
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

        /**
         * 绑定一系列listener监听器
         */




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
//        bt_run.addActionListener(listener2);
        bt_run.setFocusable(false);
        buttons.add(bt_run);


        /**
         * @param bt_delete 删除按钮
         */
        JButton bt_delete = new JButton("Delete");
        ImageIcon ic_delete = new ImageIcon("/icons/bt-delete.png");
        bt_delete.setIcon(ic_delete);
//        bt_delete.addActionListener(listener3);
        bt_delete.setFocusable(false);
        bt_delete.setBackground();
        buttons.add(bt_delete);


        /**
         * @param bt_rotate 旋转按钮
         */
        JButton bt_rotate = new JButton("Rotate");
        ImageIcon ic_rotate = new ImageIcon("/icons/bt-rotate.png");
        bt_delete.setIcon(ic_rotate);
//        bt_rotate.addActionListener(listener3);
        bt_rotate.setFocusable(false);
        buttons.add(bt_rotate);

        /**
         * @param bt_move 移动按钮
         */
        JButton bt_move = new JButton("Rotate");
        ImageIcon ic_move = new ImageIcon("/icons/bt-move.png");
        bt_delete.setIcon(ic_move);
//        bt_move.addActionListener(listener3);
        bt_move.setFocusable(false);
        buttons.add(bt_move);

        /**
         * @param bt_square 方形障碍物
         */
        JButton bt_square = new JButton("Square");
        ImageIcon ic_square = new ImageIcon("/icons/ic-square.png");
        bt_delete.setIcon(ic_square);
//        bt_square.addActionListener(listener3);
        bt_square.setFocusable(false);
        buttons.add(bt_square);

        /**
         * @param bt_triangle 三角形障碍物
         */
        JButton bt_triangle = new JButton("Triangle");
        ImageIcon ic_triangle = new ImageIcon("/icons/ic-triangle.png");
        bt_delete.setIcon(ic_triangle);
//        bt_triangle.addActionListener(listener3);
        bt_triangle.setFocusable(false);
        buttons.add(bt_triangle);

        /**
         * @param bt_circle 圆形障碍物
         */
        JButton bt_circle = new JButton("Circle");
        ImageIcon ic_circle = new ImageIcon("/icons/ic-circle.png");
        bt_delete.setIcon(ic_circle);
//        bt_circle.addActionListener(listener3);
        bt_circle.setFocusable(false);
        buttons.add(bt_circle);

        /**
         * @param bt_absorber 吸收板
         */
        JButton bt_absorber = new JButton("Absorber");
        ImageIcon ic_absorber = new ImageIcon("/icons/ic-absorber.png");
        bt_delete.setIcon(ic_absorber);
//        bt_absorber.addActionListener(listener3);
        bt_absorber.setFocusable(false);
        buttons.add(bt_absorber);


        /**
         * @param bt_lflipper 左侧挡板
         */
        JButton bt_lflipper = new JButton("LFlipper");
        ImageIcon ic_lflipper = new ImageIcon("/icons/ic-left-flipper.png");
        bt_delete.setIcon(ic_lflipper);
//        bt_lflipper.addActionListener(listener3);
        bt_lflipper.setFocusable(false);
        buttons.add(bt_lflipper);

        /**
         * @param bt_rflipper 右侧挡板
         */
        JButton bt_rflipper = new JButton("RFlipper");
        ImageIcon ic_rflipper = new ImageIcon("/icons/ic-right-flipper.png");
        bt_delete.setIcon(ic_rflipper);
//        bt_rflipper.addActionListener(listener3);
        bt_rflipper.setFocusable(false);
        buttons.add(bt_rflipper);

        /**
         * @param ball 小球
         */
        JButton ball = new JButton("Ball");
        ImageIcon ic_ball = new ImageIcon("/icons/ic-ball.png");
        bt_delete.setIcon(ic_ball);
//        ball.addActionListener(listener3);
        ball.setFocusable(false);
        buttons.add(ball);

        setVisible(true);
    }

    public void close(){
        setVisible(false);
    }
}
