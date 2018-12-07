/**
 * 旋转
 */
package ViewIcon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class RotateIcon extends MyIcon {
    public RotateIcon(Color c) {
        super(c);
    }

    public int getIconHeight() {
        return 18;
    }

    public int getIconWidth() {
        return 17;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.black);
        g.drawArc(5, 5, getIconWidth(), getIconWidth(), 0, 270);
        g.drawLine(10, 18, 12, 22);
        g.drawLine(10, 24, 12, 22);
    }

}

