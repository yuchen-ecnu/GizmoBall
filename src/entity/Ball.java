package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.dynamics.Body;

import javax.swing.*;
import java.awt.*;

/**
 * 球
 */
public class Ball extends AbstractCustomBody {

    public Ball(Body body, float radius, Color color) {
        this.size = radius;
        this.body = body;
        this.color = color;
        this.type = Constant.COMPONENT_BALL;
    }

    @Override
    public void drawSelf(Graphics g) {
    }
}
