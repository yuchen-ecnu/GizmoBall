package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import utils.DrawUtils;

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
        body.setUserData(Constant.COMPONENT_TRIANGLE);
    }

    @Override
    public void drawSelf(Graphics g) {
        Vec2 vec2 = body.getPosition();
        float x = vec2.x - size;
        float y = vec2.y - size;
        int unitSize = Constant.BOARD_SIZE/Constant.GRID_COUNT;
        double angle = body.getAngle();
        DrawUtils.drawTriangle(x*Constant.RATE*unitSize,y*Constant.RATE*unitSize,g,size*Constant.RATE*unitSize*2,angle);
    }
}
