package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.dynamics.Body;

import javax.swing.*;
import java.awt.*;

/**
 * 挡板
 */
public class BaffleBody extends AbstractCustomBody {

    public BaffleBody(Body body, int type, float size,Color color) {
        this.type = type;
        this.size = size;
        this.body = body;
        this.color = color;
    }

    @Override
    public void drawSelf(Graphics g) {

    }
}
