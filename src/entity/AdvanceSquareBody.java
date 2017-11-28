package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.common.Vec2;
import utils.DrawUtils;
import org.jbox2d.dynamics.Body;

import java.awt.*;

public class AdvanceSquareBody extends AbstractCustomBody {

    public AdvanceSquareBody(Body body, float size, Color color) {
        this.size = size;
        this.color = color;
        this.body = body;
        BodyData bd = new BodyData(System.currentTimeMillis(),Constant.COMPONENT_ADVANCED_SQUARE);
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
        DrawUtils.drawStickSquare(x*Constant.RATE*unitSize,y*Constant.RATE*unitSize,g,size*Constant.RATE*unitSize*2);
    }

}
