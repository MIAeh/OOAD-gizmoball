package Controller;

import java.awt.*;

import javax.swing.*;

//import View.BuildGUI;
import Entity.Model;
import View.*;

public class BuildModeGUI extends JFrame{

//    private Board board;
//    private Grid grid;
    private JMenu fileMenu;
    private JMenuBar menubar;
    private Board board;
    private Grid grid;
    private Model m;
    private JMenuItem Clear, Load, Save, Quit;
    private OperationListener operationListener;
    private EntityListener entityListener;
    private EntityListener el;
    private OperationListener ol;
    private MsListener mouseListener;
    private JLayeredPane lpane = new JLayeredPane();
    private String path = "";


    public BuildModeGUI(Model m) {
        super("Gizmoball");
        this.m = m;
        grid = new Grid(20,20);
        board = new Board(600, 600, m);
        fileMenu = new JMenu("Menu");

        /**
         * 选项栏：清除、加载、保存、退出布局
         */
        menubar = new JMenuBar();
        menubar.add(fileMenu);
        setJMenuBar(menubar);
        Clear = new JMenuItem("Clear");
        fileMenu.add(Clear);
        Load = new JMenuItem("Load");
        fileMenu.add(Load);
        Save = new JMenuItem("Save");
        fileMenu.add(Save);
        Quit = new JMenuItem("Quit");
        fileMenu.add(Quit);
        mouseListener = new MsListener(this, m);
        System.out.println("Succeed in showing menu");


        /**
         * 设置尺寸
         */
        
        lpane.setBounds(0, 0, 500, 500);
        board.setOpaque(true);
        board.setBounds(0, 0, 500, 500);
        lpane.add(board, new Integer(1), 0);
        lpane.add(grid, new Integer(0), 0);


        setSize(517, 612);
        //setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cPane = getContentPane();

        /**
         * 绑定一系列listener监听器
         */
        operationListener = new OperationListener(m);
        entityListener = new EntityListener(m);
        Clear.addActionListener(operationListener);
        Load.addActionListener(operationListener);
        Save.addActionListener(operationListener);
        Quit.addActionListener(operationListener);
        System.out.println("succeed in binding operationListener");

        /**
         * 设置Gizmo在build模式下的buttons
         */
        Font gf = new Font("Arial", Font.BOLD, 12);
        JPanel buttons = new JPanel();
        //格状布局
        buttons.setLayout(new GridLayout(2,6));

        /**
         * @param bt_run 运行按钮
         */
        JButton bt_run = new JButton("Run");
        bt_run.addActionListener(operationListener);
        bt_run.setFocusable(false);
        bt_run.setFont(gf);
        buttons.add(bt_run);

        /**
         * @param bt_delete 删除按钮
         */
        JButton bt_delete = new JButton("Delete");
        //ImageIcon ic_delete = new ImageIcon("/icons/bt-delete.png");
        //bt_delete.setIcon(ic_delete);
        bt_delete.setPreferredSize(new Dimension(20, 20));
        bt_delete.addActionListener(operationListener);
        bt_delete.setFocusable(false);
       // bt_delete.setBackground(Color.BLUE);
        buttons.add(bt_delete);


        /**
         * @param bt_rotate 旋转按钮
         */
        JButton bt_rotate = new JButton("Rotate");
       // ImageIcon ic_rotate = new ImageIcon("/icons/bt-rotate.png");
        //bt_rotate.setIcon(ic_rotate);
        bt_rotate.setPreferredSize(new Dimension(20, 20));
        bt_rotate.addActionListener(entityListener);
        bt_rotate.setFocusable(false);
        buttons.add(bt_rotate);

        /**
         * @param bt_move 移动按钮
         */
        JButton bt_move = new JButton("Move");
        bt_move.setPreferredSize(new Dimension(20, 20));
        bt_move.addActionListener(entityListener);
        bt_move.setFocusable(false);
        buttons.add(bt_move);

        /**
         * @param bt_square 方形障碍物
         */
        JButton bt_square = new JButton("Square");
        //ImageIcon ic_square = new ImageIcon("../icons/ic-square.png");
       // bt_square.setIcon(ic_square);
        bt_square.setPreferredSize(new Dimension(20, 20));
        bt_square.addActionListener(entityListener);
        bt_square.setFocusable(false);
        buttons.add(bt_square);

        /**
         * @param bt_triangle 三角形障碍物
         */
        JButton bt_triangle = new JButton("Triangle");
       // ImageIcon ic_triangle = new ImageIcon("../icons/ic-triangle.png");
        //bt_triangle.setIcon(ic_triangle);
        bt_triangle.setPreferredSize(new Dimension(20, 20));
        bt_triangle.addActionListener(entityListener);
        bt_triangle.setFocusable(false);
        buttons.add(bt_triangle);

        /**
         * @param bt_circle 圆形障碍物
         */
        JButton bt_circle = new JButton("Circle");
        //ImageIcon ic_circle = new ImageIcon("../icons/ic-circle.png");
        //bt_circle.setIcon(ic_circle);
        bt_circle.setPreferredSize(new Dimension(20, 20));
        bt_circle.addActionListener(entityListener);
        bt_circle.setFocusable(false);
        buttons.add(bt_circle);

        /**
         * @param bt_absorber 吸收板
         */
        JButton bt_absorber = new JButton("Absorber");
        //ImageIcon ic_absorber = new ImageIcon("../icons/ic-absorber.png");
        //bt_absorber.setIcon(ic_absorber);
        bt_absorber.setPreferredSize(new Dimension(20, 20));
        bt_absorber.addActionListener(entityListener);
        bt_absorber.setFocusable(false);
        buttons.add(bt_absorber);


        /**
         * @param bt_lflipper 左侧挡板
         */
        JButton bt_lflipper = new JButton("LFlipper");
        //ImageIcon ic_lflipper = new ImageIcon("../icons/ic-left-flipper.png");
        //bt_lflipper.setIcon(ic_lflipper);
        bt_lflipper.setPreferredSize(new Dimension(20, 20));
        bt_lflipper.addActionListener(entityListener);
        bt_lflipper.setFocusable(false);
        buttons.add(bt_lflipper);

        /**
         * @param bt_rflipper 右侧挡板
         */
        JButton bt_rflipper = new JButton("RFlipper");
       // ImageIcon ic_rflipper = new ImageIcon("../icons/ic-right-flipper.png");
        //bt_rflipper.setIcon(ic_rflipper);
        bt_rflipper.setPreferredSize(new Dimension(20, 20));
        bt_rflipper.addActionListener(entityListener);
        bt_rflipper.setFocusable(false);
        buttons.add(bt_rflipper);

        /**
         * @param ball 小球
         */
        JButton ball = new JButton("Ball");
       // ImageIcon ic_ball = new ImageIcon("../icons/ic-ball.png");
        //ball.setIcon(ic_ball);
        ball.setPreferredSize(new Dimension(20, 20));
        ball.addActionListener(entityListener);
        ball.setFocusable(false);
        buttons.add(ball);

        cPane.add(buttons, BorderLayout.NORTH);
        cPane.add(lpane, BorderLayout.CENTER);


//        this.addKeyListener(listener1);
        setVisible(true);
        System.out.println("Succeed in showing button");
        
    }

    public void close(){
        setVisible(false);
    }
    
}