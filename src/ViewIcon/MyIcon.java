/**
 * 所有具体图表类的抽象父类，继承自Icon
 */
package ViewIcon;

import javax.swing.*;
import java.awt.*;

/**
 * @param color - 图标颜色
 * 重载Icon中获取长、宽的方法getIconHeight()与getIconWidth()
 * 抽象方法 paintIcon(Component c, Graphics g, int x, int y) 进行绘制工具栏中的图标显示方法
 *
 */
public abstract class MyIcon implements Icon {
    protected Color color;
    public MyIcon(Color c) {
        color = c;
    }

    @Override
    public int getIconHeight() {
        return 0;
    }

    @Override
    public int getIconWidth() {
        return 0;
    }

    public abstract void paintIcon(Component c, Graphics g, int x, int y);
}
