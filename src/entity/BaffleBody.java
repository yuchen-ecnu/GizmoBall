package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import utils.DrawUtils;

import javax.swing.*;
import java.awt.*;

/**
 * 挡板
 */
public class BaffleBody extends AbstractCustomBody {

    public BaffleBody(Body body, int type, float size,Color color) {
        this.size = size;
        this.body = body;
        this.color = color;
        BodyData bd = new BodyData(System.currentTimeMillis(),type);
        body.setUserData(bd);
    }

    @Override
    public void applyAngularImpulse() {
        body.applyAngularImpulse(1000000.0f * (getBodyType() == Constant.COMPONENT_LEFT_BAFFLE ? -1 : 1));
    }

    @Override
    public void drawSelf(Graphics g) {
        Vec2 vec2 = body.getPosition();

        float a = body.getAngle();
        System.out.println(vec2);
        int unitSize = Constant.BOARD_SIZE/Constant.GRID_COUNT;
        if(getBodyType() == Constant.COMPONENT_LEFT_BAFFLE) {
            float x = (float) (vec2.x + size*Math.sin(a));
            float y = (float) (vec2.y - size*Math.cos(a));
            x = x - size/8;

            DrawUtils.drawLeftFlipper(x * Constant.RATE * unitSize, y * Constant.RATE * unitSize,
                    a, g, size * Constant.RATE * unitSize * 2);
        } else {
            float x = (float) (vec2.x + size*Math.sin(a));
            float y = (float) (vec2.y - size*Math.cos(a));
            x = x + size/8;
            DrawUtils.drawRightFlipper(x * Constant.RATE * unitSize, y * Constant.RATE * unitSize,
                    a, g, size * Constant.RATE * unitSize * 2);
        }
    }

}
