package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;
import utils.DrawUtils;
import utils.ImageUtils;
import org.jbox2d.dynamics.Body;

import javax.swing.*;
import java.awt.*;

public class AdvanceSquareBody extends AbstractCustomBody {

    public AdvanceSquareBody(Body body, float size, Color color) {
        this.size = size;
        this.color = color;
        this.body = body;
        body.setUserData(Constant.COMPONENT_ADVANCED_SQUARE);
    }

    @Override
    public void drawSelf(Graphics g) {
        Vec2 vec2 = body.getPosition();
        float x = vec2.x - size;
        float y = vec2.y - size;
        int unitSize = Constant.BOARD_SIZE/Constant.GRID_COUNT;
        DrawUtils.drawStickSquare(x*Constant.RATE*unitSize,y*Constant.RATE*unitSize,g,size*Constant.RATE*unitSize*2);
    }

//    @Override
//    public void rotation(World world) {
//        //Do nothing
//    }
}
