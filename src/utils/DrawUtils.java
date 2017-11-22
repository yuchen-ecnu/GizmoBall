package utils;

import constant.Constant;

import java.awt.*;

public class DrawUtils {

    public static void drawCircle(float x,float y, Graphics g,float radious) {
        g.setColor(Constant.COLOR_CIRCLE);
        g.fillOval((int) x,(int) y, (int) radious, (int) radious);
    }

    public static void drawSquare(float x,float y, Graphics g,float size) {
        g.setColor(Constant.COLOR_SQUARE);
        g.fillRect((int) x,(int) y,(int) size,(int) size);
    }
}
