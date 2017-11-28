package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import utils.DrawUtils;
import java.awt.*;

public class CircleBody extends AbstractCustomBody {

    public CircleBody(Body body, float radious, Color color) {
        this.body = body;
        this.color = color;
        this.size = radious;
        BodyData bd = new BodyData(System.currentTimeMillis(),Constant.COMPONENT_CIRCLE);
        body.setUserData(bd);
    }

    @Override
    public void applyAngularImpulse() {

    }

    @Override
    public void drawSelf(Graphics g) {
        Vec2 vec2 = body.getPosition();
        float x = vec2.x - size;
        float y = vec2.y - size;
        int unitSize = Constant.BOARD_SIZE/Constant.GRID_COUNT;
        DrawUtils.drawCircle(x*Constant.RATE*unitSize,y*Constant.RATE*unitSize,g,size*Constant.RATE*unitSize);
    }

}
