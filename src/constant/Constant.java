package constant;

import java.awt.*;

/**
 * @description 常量
 * @author Jack Chen
 * @date 2017/11/21
 */
public class Constant {

    //比例尺
    public static final float RATE = 10;

    //迭代次数
    public static final int ITERA = 10;

    //模拟的频率
    public static final float TIME_STEP = 2.0f/60.0f;

    //绘制线程工作标志位
    public static final boolean DRAW_THREAD_FLAG = true;

    public static final int BOARD_SIZE = 600;
    public static final int GRID_COUNT = 20;

    public static final int WINDOW_MAIN_WIDTH = 852;
    public static final int WINDOW_MAIN_HEIGHT = 680;

    public static final int WINDOW_DONATE_WIDTH = 356;
    public static final int WINDOW_DONATE_HEIGHT = 562;
    public static final String IMG_DONATE = "donate.jpg";

    //颜色
    public static final Color CIRCLE_COLOR = new Color(98,169,241);
    public static final Color TRIANGLE_COLOR = new Color(247,126,110);
    public static final Color SQUARE_COLOR = new Color(1,177,175);
    public static final Color TRAPEZOID_COLOR = new Color(243,202,126);
    public static final Color BALL_COLOR = new Color(188,187,194);
    public static final Color STICK_SQUARE_COLOR = new Color(232,152,154);
    public static final Color STICK_COLOR = new Color(243,202,126);
}
