package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import utils.DrawUtils;

import javax.swing.*;
import java.awt.*;

/**
 * 弹力板
 */
public class ElasticPlateBody extends AbstractCustomBody {

    public ElasticPlateBody(Body body, float size,Color color) {
        this.size = size;
        this.body = body;
        this.color = color;
        body.setUserData(Constant.COMPONENT_ELASTIC_PLATE);
    }

    @Override
    public void drawSelf(Graphics g) {
        Vec2 vec2 = body.getPosition();
        float x = vec2.x - size;
        float y = vec2.y - size;
        int unitSize = Constant.BOARD_SIZE/Constant.GRID_COUNT;
        double angle = body.getAngle();
        DrawUtils.drawStick(x*Constant.RATE*unitSize,y*Constant.RATE*unitSize,g,size*Constant.RATE*unitSize*2,angle);
    }
}
