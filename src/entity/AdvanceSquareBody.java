package entity;

import entity.base.AbstractCustomBody;
import utils.ImageUtils;
import org.jbox2d.dynamics.Body;

import javax.swing.*;
import java.awt.*;

public class AdvanceSquareBody extends AbstractCustomBody {
    private float size;

    public AdvanceSquareBody(Body body, float size, Color color) {
        this.size = size;
        this.color = color;
        this.body = body;
    }

    @Override
    public void drawSelf(JPanel boardPanel, Graphics g) {
    }
}
