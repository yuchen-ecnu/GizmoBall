package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import utils.DrawUtils;
import utils.ImageUtils;

import javax.swing.*;
import java.awt.*;

public class CircleBody extends AbstractCustomBody {
    private float radious;

    public CircleBody(Body body, float radious, Color color) {
        this.radious = radious;
        this.color = color;
        this.size = size;
    }

    public CircleBody(Color color,int size){
        this.color = color;
        this.size = size;
    }

    @Override
    public void drawSelf(JPanel boardPanel, Graphics g) {
        DrawUtils.drawCircle(30,30,g,getSize());
    }
}
