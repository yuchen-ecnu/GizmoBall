package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.dynamics.Body;

import javax.swing.*;
import java.awt.*;


/**
 * @description 正方形 Body
 * @author Jack Chen
 * @date 2017/11/21
 */
public class SquareBody extends AbstractCustomBody{


    public SquareBody(Body body, Color color,int size) {
        this.body = body;
        this.color = color;
        this.size = size;
    }

    public SquareBody(Color color,int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public void drawSelf(JPanel boardPanel, Graphics g) {
        g.setColor(Constant.SQUARE_COLOR);

    }
}
