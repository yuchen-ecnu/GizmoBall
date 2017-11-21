package utils;

import ui.MainFrame;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @description 图片处理工具类
 * @author Jack Chen
 * @date 2017/11/21
 */
public class ImageUtils {
	
	/**
	 * 根据size及图片路径返回缩放后的Image
	 * @return 错误返回null
	 */
	public static ImageIcon getImage(String res,int width,int height){
		ImageIcon imageIcon =new ImageIcon(MainFrame.class.getResource("../"+res));
		Image image = imageIcon.getImage().getScaledInstance(width,height, Image.SCALE_DEFAULT);
		imageIcon.setImage(image);
		return imageIcon;
	}
}
