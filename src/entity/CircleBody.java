package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import utils.ImageUtils;

import javax.swing.*;
import java.awt.*;

public class CircleBody extends AbstractCustomBody {

    public CircleBody(Body body,Color color,int size){
        this.body = body;
        this.color = color;
        this.size = size;
    }

    public CircleBody(Color color,int size){
        this.color = color;
        this.size = size;
    }

    @Override
    public void drawSelf(JPanel boardPanel, Graphics g) {
        g.setColor(Constant.CIRCLE_COLOR);
        g.fillOval(30,30,(Constant.BOARD_SIZE / Constant.GRID_COUNT)*size ,(Constant.BOARD_SIZE / Constant.GRID_COUNT)*size);
    }
}
