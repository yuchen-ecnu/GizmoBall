package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import utils.DrawUtils;
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
        body.setUserData(Constant.COMPONENT_ABSORBER);
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
        DrawUtils.drawAbsorber(x*Constant.RATE*unitSize,y*Constant.RATE*unitSize,g,size*Constant.RATE*unitSize*2);
    }
//
//    @Override
//    public void rotation(World world) {
//        //Do nothing
//    }
}
