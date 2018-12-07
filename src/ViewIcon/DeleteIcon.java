/**
 * 删除键
 */
package ViewIcon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;

public class DeleteIcon extends MyIcon {
    public DeleteIcon(Color c) {
        super(c);
    }

    public int getIconHeight() {
        return 18;
    }

    public int getIconWidth() {
        return 17;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int pad = 5;
        g.setColor(Color.red);
        g.drawLine(pad, pad, c.getWidth() - pad, c.getHeight() - pad);
        g.drawLine(c.getWidth() - pad, pad, pad, c.getHeight() - pad);
    }

}

