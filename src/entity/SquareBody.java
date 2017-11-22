package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import utils.DrawUtils;

import javax.swing.*;
import java.awt.*;


/**
 * @description 正方形 Body
 * @author Jack Chen
 * @date 2017/11/21
 */
public class SquareBody extends AbstractCustomBody{

    public SquareBody(Body body,float size, Color color) {
        this.body = body;
        this.color = color;
        this.size = size;
        this.type = Constant.COMPONENT_SQUARE;
    }

    @Override
    public void drawSelf(Graphics g) {
        Vec2 vec2 = body.getPosition();
        float x = vec2.x - size/2.0f;
        float y = vec2.y - size/2.0f;
        int unitSize = Constant.BOARD_SIZE/Constant.GRID_COUNT;
        DrawUtils.drawSquare(x*unitSize,y*unitSize,g,size*unitSize);
    }
}
