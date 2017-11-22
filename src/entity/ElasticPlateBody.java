package entity;

import entity.base.AbstractCustomBody;
import org.jbox2d.dynamics.Body;

import javax.swing.*;
import java.awt.*;

/**
 * 弹力板
 */
public class ElasticPlateBody extends AbstractCustomBody {
    private float size;

    public ElasticPlateBody(Body body, float size,Color color) {
        this.size = size;
        this.body = body;
        this.color = color;
    }

    @Override
    public void drawSelf(JPanel boardPanel, Graphics g) {

    }
}
