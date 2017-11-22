package entity;

import entity.base.AbstractCustomBody;
import org.jbox2d.dynamics.Body;

import java.awt.*;


/**
 * @description 正方形 Body
 * @author Jack Chen
 * @date 2017/11/21
 */
public class SquareBody extends AbstractCustomBody{


    public SquareBody(Body body, int color) {
        this.body = body;
        this.color = color;
    }

    @Override
    public void drawSelf(Canvas canvas, Paint paint) {

    }
}
