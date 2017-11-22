package ui;

import constant.Constant;
import entity.CircleBody;
import entity.SquareBody;
import org.jbox2d.dynamics.Body;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * @description 显示窗口
 * @author Jack Chen
 * @date 2017/11/21
 */
public class BoardPanel extends JPanel {

	public BoardPanel() {
		setBackground(Color.BLACK);
		setBounds(10, 10, Constant.BOARD_SIZE, Constant.BOARD_SIZE);
		setLayout(new GridLayout(200, 200, 0, 0));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		//绘制列
		int size = Constant.BOARD_SIZE / Constant.GRID_COUNT ; 
		for(int i =0;i<Constant.BOARD_SIZE;i+=size){
			g.drawLine(i, 0, i, Constant.BOARD_SIZE);
		}
		//绘制行
		for(int i =0;i<Constant.BOARD_SIZE;i+=size){
			g.drawLine(0, i, Constant.BOARD_SIZE, i);
		}

        SquareBody circleBody = new SquareBody(Constant.CIRCLE_COLOR,2);
        circleBody.drawSelf(this,g);
	}
	

}
