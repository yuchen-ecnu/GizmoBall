package entity;

import entity.base.AbstractCustomBody;
import org.jbox2d.dynamics.Body;

import javax.swing.*;
import java.awt.*;

/**
 * 挡板
 */
public class BaffleBody extends AbstractCustomBody {
    private int type;
    private float size;

    public BaffleBody(Body body, int type, float size,Color color) {
        this.type = type;
        this.size = size;
        this.body = body;
        this.color = color;
    }

    @Override
    public void drawSelf(JPanel boardPanel, Graphics g) {

    }
}
