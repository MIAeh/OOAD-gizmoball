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
<<<<<<< HEAD
         * @param triangle 默认边长为10,10,10_/2的直角三角形
=======
         * @param triangle 榛樿杈归暱涓�10,10,10_/2鐨勭洿瑙掍笁瑙掑舰
>>>>>>> e1c1b7c93046cfe5fdc0762274bd497697c63b8b
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

