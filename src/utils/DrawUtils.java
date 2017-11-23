package utils;

import constant.Constant;

import java.awt.*;

public class DrawUtils {

    public static void drawCircle(float x,float y, Graphics g,float radious) {
        g.setColor(Constant.COLOR_CIRCLE);
        g.fillOval((int) x,(int) y, (int) radious*2, (int) radious*2);
    }

    public static void drawSquare(float x,float y, Graphics g,float size) {
        g.setColor(Constant.COLOR_SQUARE);
        g.fillRect((int) x,(int) y,(int) size,(int) size);
    }

    public static void drawBall(float x,float y, Graphics g) {
        g.drawImage(Constant.IMAGE_BALL,(int)x,(int)y,null);
    }
}
