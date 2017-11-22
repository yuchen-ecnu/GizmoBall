package utils;

import constant.Constant;

import javax.swing.*;
import java.awt.*;

public class DrawUtils {

    public static void drawCircle(int x,int y, Graphics g,int size) {
        g.setColor(Constant.CIRCLE_COLOR);
        g.fillOval(x,y,(Constant.BOARD_SIZE / Constant.GRID_COUNT)*size ,(Constant.BOARD_SIZE / Constant.GRID_COUNT)*size);
    }
    public static void drawSquare(int x,int y, Graphics g,int size) {
        g.setColor(Constant.SQUARE_COLOR);
        g.fillRect(x,y,(Constant.BOARD_SIZE / Constant.GRID_COUNT)*size ,(Constant.BOARD_SIZE / Constant.GRID_COUNT)*size);
    }
}
