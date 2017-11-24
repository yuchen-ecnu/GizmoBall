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

    public static void drawStickSquare(float x,float y, Graphics g,float size) {
        g.setColor(Constant.COLOR_ADVANCE_SQUARE);
        g.fillRect((int) x,(int) y,(int) size,(int) size);
    }

    public static void drawStick(float x,float y, Graphics g,float size,double angle){
        g.setColor(Constant.COLOR_STICK);

        double trueAngle = angle % (2*Math.PI);
        if(trueAngle < (Math.PI/2)){
            g.fillRect((int) x,(int)(y + size*7/16),(int) size,(int) (size/8));
        }else if(trueAngle < (Math.PI)){
            g.fillRect((int) (x + size*7/16),(int) y,(int) (size/8),(int) size);
        }else if(trueAngle < (Math.PI*3/2)){
            g.fillRect((int) x,(int)(y + size*7/16),(int) size,(int) (size/8));
        }else{
            g.fillRect((int) (x + size*7/16),(int) y,(int) (size/8),(int) size);
        }
    }

    public static void drawAbsorber(float x,float y,Graphics g,float size){
        g.setColor(Color.white);
        g.fillRect((int) x,(int) y,(int) size,(int) size);
        g.setColor(Color.red);
        g.drawOval((int) (x + size/4),(int) (y + size/4),(int) (size/2),(int) (size/2));
    }

    public static void drawLeftFlipper(float x,float y,Graphics g,float size){
        g.setColor(Color.orange);
        g.fillRect((int) x,(int) y,(int)(size/6),(int) size);
        g.setColor(Color.white);
        g.fillOval((int) x,(int) y,(int)(size/6),(int) (size/6));
    }

    public static void drawRightFlipper(float x,float y,Graphics g,float size){
        g.setColor(Color.orange);
        g.fillRect((int) (x + size*5/6),(int) y,(int)(size/6),(int) size);
        g.setColor(Color.white);
        g.fillOval((int) (x + size*5/6),(int) y,(int)(size/6),(int) (size/6));
    }

    public static void drawTriangle(float x,float y,Graphics g,float size,double angle){
        g.setColor(Constant.COLOR_TRIANGLE);
        int px1,px2,px3,py1,py2,py3;
        double trueAngle = angle % (2*Math.PI);
        if(trueAngle < (Math.PI/2)){
            px1 = (int) x;
            px2 = (int) x;
            px3 = (int) (x + size);
            py1 = (int) y;
            py2 = (int) (y + size);
            py3 = (int) y;
        }else if(trueAngle < (Math.PI)){
            px1 = (int) x;
            px2 = (int) (x + size);
            px3 = (int) (x + size);
            py1 = (int) y;
            py2 = (int) (y + size);
            py3 = (int) y;
        }else if(trueAngle < (Math.PI*3/2)){
            px1 = (int) x;
            px2 = (int) (x + size);
            px3 = (int) (x + size);
            py1 = (int) (y + size);
            py2 = (int) (y + size);
            py3 = (int) y;
        }else{
            px1 = (int) x;
            px2 = (int) x;
            px3 = (int) (x + size);
            py1 = (int) y;
            py2 = (int) (y + size);
            py3 = (int) (y + size);
        }
        int px[] = {px1,px2,px3,px1};
        int py[] = {py1,py2,py3,py1};
        g.fillPolygon(px,py,3);
    }


    public static void drawTrapezoid(float x,float y,Graphics g,float size,double angle){
        g.setColor(Constant.COLOR_TRAPEZOID);
        int px1,px2,px3,px4,py1,py2,py3,py4;
        double trueAngle = angle % (2*Math.PI);
        if(trueAngle < (Math.PI/2)){
            px1 = (int) (x + size/4) ;
            px2 = (int) x;
            px3 = (int) (x + size);
            px4 = (int) (x + size*3/4);
            py1 = (int) y;
            py4 = (int) y;
            py2 = (int) (y + size);
            py3 = (int) (y + size);
        }else if(trueAngle < (Math.PI)){
            px1 = (int) x;
            px2 = (int) x;
            px3 = (int) (x + size);
            px4 = (int) (x + size);
            py1 = (int) (y + size/4);
            py2 = (int) (y + size*3/4);
            py3 = (int) (y + size);
            py4 = (int) y;
        }else if(trueAngle < (Math.PI*3/2)){
            px1 = (int) x ;
            px2 = (int) (x + size/4);
            px3 = (int) (x + size*3/4);
            px4 = (int) (x + size);
            py1 = (int) y;
            py2 = (int) (y + size);
            py3 = (int) (y + size);
            py4 = (int) y;
        }else{
            px1 = (int) x;
            px2 = (int) x;
            px3 = (int) (x + size);
            px4 = (int) (x + size);
            py1 = (int) y;
            py2 = (int) (y + size);
            py3 = (int) (y + size*3/4);
            py4 = (int) (y + size/4);
        }
        int px[] = {px1,px2,px3,px4,px1};
        int py[] = {py1,py2,py3,py4,py1};
        g.fillPolygon(px,py,4);
    }

    public static void drawBall(float x,float y, Graphics g) {
        g.drawImage(Constant.IMAGE_BALL,(int)x,(int)y,null);
    }
}
