package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.dynamics.Body;

import javax.swing.*;
import java.awt.*;

/**
 * 三角形
 */
public class TriangleBody extends AbstractCustomBody {

    public TriangleBody(Body body, float size, Color color) {
        this.size = size;
        this.color = color;
        this.body = body;
        this.type = Constant.COMPONENT_TRIANGLE;
    }

    @Override
    public void drawSelf(Graphics g) {

    }
}
