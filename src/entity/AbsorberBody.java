package entity;

import entity.base.AbstractCustomBody;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import utils.ImageUtils;

import javax.swing.*;
import java.awt.*;

/**
 * 吸收器
 */
public class AbsorberBody extends AbstractCustomBody {
    private float radious;

    public AbsorberBody(Body body, float radious,Color color) {
        this.radious = radious;
        this.body = body;
        this.color = color;
    }

    @Override
    public void drawSelf(JPanel boardPanel, Graphics g) {
    }
}
