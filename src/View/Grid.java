package View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 显示不同mode下的button
 */
public class Grid extends JPanel {

    JButton[][] grid;

    public Grid(int width, int length){
        this.setSize(500,500);
        this.setLayout(new GridLayout(width,length));
        //根据每个button的大小分配grid
        grid = new JButton[width][length];
        for(int y=0; y<length; y++){
            for(int x=0; x<width; x++){
                grid[x][y]=new JButton("("+x+","+y+")");
                grid[x][y].setVisible(false);
                this.add(grid[x][y]); //adds button to grid
            }
        }
    }
}

