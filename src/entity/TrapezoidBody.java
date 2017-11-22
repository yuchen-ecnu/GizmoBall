package entity;

import entity.base.AbstractCustomBody;
import org.jbox2d.dynamics.Body;

import javax.swing.*;
import java.awt.*;

public class TrapezoidBody extends AbstractCustomBody {
    private float size;

    public TrapezoidBody(Body body, float size, Color color) {
        this.size = size;
        this.color = color;
        this.body = body;
    }

    @Override
    public void drawSelf(JPanel boardPanel, Graphics g) {

    }
}
