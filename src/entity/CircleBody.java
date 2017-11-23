package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.dynamics.Body;
import utils.DrawUtils;
import java.awt.*;

public class CircleBody extends AbstractCustomBody {

    public CircleBody(Body body, float radious, Color color) {
        this.color = color;
        this.size = radious;
        body.setUserData(Constant.COMPONENT_CIRCLE);
    }

    @Override
    public void drawSelf(Graphics g) {
        DrawUtils.drawCircle(30,30,g,size);
    }
}
