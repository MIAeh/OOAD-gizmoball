package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Entity.*;

public class Board extends JPanel implements Observer {

    protected int w;
    protected int h;
    protected Model m;

    public Board(int wid, int hei, Model m) {
        this.w = wid;
        this.h = hei;
        this.m = m;
        m.addObserver(this);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.lightGray);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        ArrayList<Ball> balls = m.getBall();
        for (Ball b : balls) {
            if (b != null) {
                g2.setColor(b.getColour());
                int x = (int) (b.getExactX() - b.getRadius());
    			int y = (int) (b.getExactY() - b.getRadius());
//                int x = (int) (b.getVx() - b.getRadius());
//                int y = (int) (b.getVy() - b.getRadius());
                int width = (int) (2 * b.getRadius());
                g2.fillOval(x, y, width, width);
            }
        }

        ArrayList<CircleBarrier> circles = m.getCBumper();
        for (CircleBarrier c : circles) {
            if (c != null) {
                g2.setColor(c.getColour());
                int x1 = (int) (c.getX() - c.getRadius());
                int y1 = (int) (c.getY() - c.getRadius());
                int width1 = (int) (2 * c.getRadius());
                g2.fillOval(x1, y1, width1, width1);
            }
        }

        ArrayList<SquareBarrier> sqaures = m.getSBumper();
        for (SquareBarrier s : sqaures) {
            if (s != null) {
                for (int i = 0; i < s.getCircles().size(); i++) {
                    g2.setColor(s.getColour());
                    int x3 = (int) (s.getCircles().get(i).getCenter().getX() - s.getRadius());
                    int y3 = (int) (s.getCircles().get(i).getCenter().getY() - s.getRadius());
                    int width3 = (int) (2 * s.getRadius());
                    g2.fillOval(x3, y3, width3, width3);

                }

                g2.setColor(Color.black);

                g2.fillRect((int) s.getCircles().get(3).getCenter().getX(),
                        (int) s.getCircles().get(3).getCenter().getY() ,(int) s.getW() , (int) s.getW());
            }

        }

        int[] yArray = new int[3];
        int[] xArray = new int[3];

        ArrayList<TriangleBarrier> triangles = m.getTB();
        for (TriangleBarrier t : triangles) {
            if (t != null) {
                for (int i = 0; i < t.getCircles().size(); i++) {

                    g2.setColor(t.getColour());
                    int x3 = (int) (t.getCircles().get(i).getCenter().getX() - t.getRadius());
                    int y3 = (int) (t.getCircles().get(i).getCenter().getY() - t.getRadius());
                    yArray[i] = (int) (t.getCircles().get(i).getCenter().getY());
                    xArray[i] = (int) (t.getCircles().get(i).getCenter().getX());
                    int width3 = (int) (2 * t.getRadius());
                    g2.fillOval(x3, y3, width3, width3);
                }
                Polygon poly = new Polygon(xArray, yArray, 3);

                AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(( 0)), t.getExactX(), t.getExactY());
                Shape triangle = at.createTransformedShape(poly);


                g2.fill(triangle);

            }

        }
        ArrayList<StaticFlipper> sflippers = m.getRF();
        for (StaticFlipper sf : sflippers) {
            if (sf != null) {
                RoundRectangle2D rightFlipper = new RoundRectangle2D.Double(sf.getXpos(), sf.getYpos(),
                        sf.getWidth(), 10, 10, 50);
                for (int i = 0; i < sf.getCircles().size(); i++) {
                    g2.setColor(sf.getColour());
                    int x3 = (int) (sf.getCircles().get(i).getCenter().getX() - 5);
                    int y3 = (int) (sf.getCircles().get(i).getCenter().getY() - 5);
                    int width3 = (int) (2 * 5);
                    g2.fillOval(x3, y3, width3, width3);

                }

                AffineTransform rightAffineTransform = AffineTransform.getRotateInstance(Math.toRadians(( -1 * sf.getDegree())), sf.getXpos()+5, sf.getYpos()+5);
                Shape rightRotatedShape = rightAffineTransform.createTransformedShape(rightFlipper);

                g2.fill(rightRotatedShape);
            }

        }

        ArrayList<Absorber> absorbers = m.getAbsorb();
        for (Absorber ab : absorbers) {
            if (ab != null) {
                g2.setColor(ab.getColour());
                g2.fillRect((int)ab.getX(), (int)ab.getY(), (int)ab.getWidth(), 50);
            }

        }

        if(m.getRunMode() == false){
            for (int i = 0; i <= getSize().width; i += 25)
            {
                g2.drawLine(i, 0, i, getSize().height);
                g2.setColor(Color.BLACK);
            }

            for (int i = 0; i <= getSize().height; i += 25)
            {
                g2.drawLine(0,i, getSize().width, i);
                g2.setColor(Color.BLACK);
            }
        }

    }

    @Override
    public void update(Observable arg0, Object arg1) {
        repaint();

    }
}