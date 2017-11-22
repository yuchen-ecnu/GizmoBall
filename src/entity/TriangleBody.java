package entity;

import entity.base.AbstractCustomBody;
import org.jbox2d.dynamics.Body;

import javax.swing.*;
import java.awt.*;

/**
 * 三角形
 */
public class TriangleBody extends AbstractCustomBody {
    private float size;

    public TriangleBody(Body body, float size, Color color) {
        this.size = size;
        this.color = color;
        this.body = body;
    }

    @Override
    public void drawSelf(JPanel boardPanel, Graphics g) {

    }
}
