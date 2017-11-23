package constant;

import utils.ImageUtils;

import java.awt.*;

/**
 * @description 常量
 * @author Jack Chen
 * @date 2017/11/21
 */
public class Constant {

    /**比例尺(网格 : 模拟)*/
    public static final float RATE = 1.0f / 10.0f;

    /**模拟的频率*/
    public static final float TIME_STEP = 1.0f / 30.0f;
    public static final int VELOCITY_ITERATION = 6;
    public static final int POSITION_ITERATION = 2;

    /**绘制线程工作标志位*/
    public static boolean DRAW_THREAD_FLAG = false;

    public static final int BOARD_SIZE = 600;
    public static final int GRID_COUNT = 20;

    public static final int BALL_SIZE = BOARD_SIZE/GRID_COUNT;
    public static final int COMPONENT_DESTINY = 100;

    public static final int WINDOW_MAIN_WIDTH = 852;
    public static final int WINDOW_MAIN_HEIGHT = 680;

    public static final int WINDOW_DONATE_WIDTH = 356;
    public static final int WINDOW_DONATE_HEIGHT = 562;
    public static final String IMG_DONATE = "donate.jpg";

    /**Gizmo类型定义*/
    public static final int COMPONENT_CIRCLE = 1;
    public static final int COMPONENT_TRIANGLE = 2;
    public static final int COMPONENT_SQUARE = 3;
    public static final int COMPONENT_TRAPEZOID = 4;
    public static final int COMPONENT_BALL = 5;
    public static final int COMPONENT_ADVANCED_SQUARE = 6;
    public static final int COMPONENT_ELASTIC_PLATE = 7;
    public static final int COMPONENT_LEFT_BAFFLE = 8;
    public static final int COMPONENT_RIGHT_BAFFLE = 9;
    public static final int COMPONENT_ABSORBER = 10;

    /**操作类型定义*/
    public static final int COMPONENT_ROTATION = 11;
    public static final int COMPONENT_DELETE = 12;

    /**游戏操作定义*/
    public static final int OPERATION_PLAY = 0;
    public static final int OPERATION_PAUSE = 1;

    /**颜色常量*/
    public static final Color COLOR_CIRCLE = new Color(98,169,241);
    public static final Color COLOR_TRIANGLE = new Color(247,126,110);
    public static final Color COLOR_SQUARE = new Color(1,177,175);
    public static final Color COLOR_TRAPEZOID = new Color(243,202,126);
    public static final Color COLOR_BALL = new Color(188,187,194);
    public static final Color COLOR_ADVANCE_SQUARE = new Color(232,152,154);
    public static final Color COLOR_STICK = new Color(243,202,126);

    public static final Image IMAGE_BALL = ImageUtils.getImageNotIcon("ball.png",BALL_SIZE,BALL_SIZE);
}
