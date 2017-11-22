package entity.base;

import org.jbox2d.dynamics.Body;

import javax.swing.*;
import java.awt.*;

/**
 * @description 抽象基类，封装JBOX物理引擎中的Body
 * (注：物理引擎仅提供模拟运动过程，还需要封装部分绘制的属性; eg：color)
 *
 * @author Jack Chen
 * @date 2017/11/21
 */
public abstract class AbstractCustomBody {
    protected Body body;      //JBox2D物理引擎中的刚体(Body)
    protected Color color;      //刚体的颜色
    protected int size;       //物体的大小为size*格子边长

    public int getSize() {
        return size;
    }

    public abstract void drawSelf(JPanel boardPanel, Graphics g);
}
