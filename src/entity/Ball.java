package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import utils.DrawUtils;

import java.awt.*;

/**
 * 球
 */
public class Ball extends AbstractCustomBody {

    public Ball(Body body, float radius, Color color) {
        this.size = radius;
        this.body = body;
        this.color = color;
        body.setUserData(Constant.COMPONENT_BALL);
    }

    @Override
    public void drawSelf(Graphics g) {
        Vec2 vec2 = body.getPosition();
        float size = this.size;
        float x = vec2.x-size;
        float y = vec2.y-size;
        int unitSize = Constant.BOARD_SIZE/Constant.GRID_COUNT;
        DrawUtils.drawBall(x*Constant.RATE*unitSize,y*Constant.RATE*unitSize,g);
    }
}
