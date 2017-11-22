package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.dynamics.Body;

import javax.swing.*;
import java.awt.*;

/**
 * 圆形
 */
public class CircleBody extends AbstractCustomBody {
    private float radious;

    public CircleBody(Body body, float radious, Color color) {
        this.radious = radious;
        this.color = color;
        this.body = body;
    }

    @Override
    public void drawSelf(JPanel boardPanel, Graphics g) {
        g.setColor(Constant.CIRCLE_COLOR);
        g.fillOval(30,30,(Constant.BOARD_SIZE / Constant.GRID_COUNT)*size ,(Constant.BOARD_SIZE / Constant.GRID_COUNT)*size);
    }
}
