package entity;

import entity.base.AbstractCustomBody;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import utils.ImageUtils;

import javax.swing.*;
import java.awt.*;

/**
 * 球
 */
public class Ball extends AbstractCustomBody {
    private float radius;

    public Ball(Body body, float radius, Color color) {
        this.radius = radius;
        this.body = body;
        this.color = color;
    }

    @Override
    public void drawSelf(JPanel boardPanel, Graphics g) {
    }
}
