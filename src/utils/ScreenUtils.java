package utils;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JDialog;

/**
 * @description 屏幕处理工具类
 * @author Jack Chen
 * @date 2017/11/21
 */
public class ScreenUtils {
	//获取屏幕中心Dimension(For Frame)
    public static Dimension getScreenMidDimension(Frame frame) {
    	int windowWidth = frame.getWidth(); // 获得窗口宽   
    	int windowHeight = frame.getHeight(); // 获得窗口高   
    	Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包   
    	Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸   
    	int screenWidth = screenSize.width; // 获取屏幕的宽   
    	int screenHeight = screenSize.height; // 获取屏幕的高
    	return new Dimension(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);
    }

	//获取屏幕中心Dimension(For Dialog)
    public static Dimension getScreenMidDimension(JDialog frame) {
    	int windowWidth = frame.getWidth(); // 获得窗口宽   
    	int windowHeight = frame.getHeight(); // 获得窗口高   
    	Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包   
    	Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸   
    	int screenWidth = screenSize.width; // 获取屏幕的宽   
    	int screenHeight = screenSize.height; // 获取屏幕的高
    	return new Dimension(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);
    }
}
