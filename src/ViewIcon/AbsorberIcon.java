/**
 * 定义吸收板Absorber
 */
package ViewIcon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class AbsorberIcon extends MyIcon {
    public AbsorberIcon(Color c) {
        super(c);
    }

    public int getIconWidth() {
        return 60;
    }

    public int getIconHeight() {
        return 20;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);
        g.fillRect(x, y, getIconWidth(), getIconHeight());
    }


}