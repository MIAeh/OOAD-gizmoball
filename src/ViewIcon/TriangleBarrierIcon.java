/**
 * 三角形挡板
 */
package ViewIcon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class TriangleBarrierIcon extends MyIcon {

    public TriangleBarrierIcon(Color c) {
        super(c);
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        /**
         * @param triangle 默认边长为10,10,10_/2的直角三角形
         */
        Point p1 = new Point(5, 5);
        Point p2 = new Point(5, 15);
        Point p3 = new Point(15, 5);
        int[] xs = {p1.x, p2.x, p3.x};
        int[] ys = {p1.y, p2.y, p3.y};
        Polygon triangle = new Polygon(xs, ys, 3);
        g.setColor(color);
        g.fillPolygon(triangle);
    }

}

