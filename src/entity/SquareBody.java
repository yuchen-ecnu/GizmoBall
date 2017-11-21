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
    private float radius;      //圆形半径

    public SquareBody(Body body, float radius, int color) {
        this.radius = radius;
        this.body = body;
        this.color = color;
    }

    @Override
    public void drawSelf(Canvas canvas, Paint paint) {

    }
}
