package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
import org.jbox2d.dynamics.Body;

import javax.swing.*;
import java.awt.*;

/**
 * 弹力板
 */
public class ElasticPlateBody extends AbstractCustomBody {

    public ElasticPlateBody(Body body, float size,Color color) {
        this.size = size;
        this.body = body;
        this.color = color;
        body.setUserData(Constant.COMPONENT_ELASTIC_PLATE);
    }

    @Override
    public void drawSelf(Graphics g) {

    }
}
