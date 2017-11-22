package entity;

import constant.Constant;
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

    public AbsorberBody(Body body, float radious,Color color) {
        this.size = radious;
        this.body = body;
        this.color = color;
        this.type = Constant.COMPONENT_ABSORBER;
    }

    @Override
    public void drawSelf(Graphics g) {
    }
}
