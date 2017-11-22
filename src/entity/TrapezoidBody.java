package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.dynamics.Body;

import javax.swing.*;
import java.awt.*;

public class TrapezoidBody extends AbstractCustomBody {

    public TrapezoidBody(Body body, float size, Color color) {
        this.size = size;
        this.color = color;
        this.body = body;
        this.type = Constant.COMPONENT_TRAPEZOID;
    }

    @Override
    public void drawSelf(Graphics g) {

    }
}
