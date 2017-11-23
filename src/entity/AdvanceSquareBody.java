package entity;

import constant.Constant;
import entity.base.AbstractCustomBody;
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
    }
}
