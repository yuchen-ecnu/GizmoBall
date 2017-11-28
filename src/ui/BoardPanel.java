package ui;

import constant.Constant;
import entity.base.AbstractCustomBody;
import listener.OperationListener;
import utils.DrawUtils;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * @description 显示窗口
 * @author Jack Chen
 * @date 2017/11/21
 */
public class BoardPanel extends JPanel {

	private OperationListener listener;
	private List<AbstractCustomBody> components;


	public BoardPanel(OperationListener listener) {
		this.listener = listener;
		this.components = new ArrayList<>();
		setBackground(Color.BLACK);
		setBounds(10, 10, Constant.BOARD_SIZE, Constant.BOARD_SIZE);
		setLayout(new GridLayout(200, 200, 0, 0));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				listener.onBorderClicked(e.getPoint());
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawBoard(g);
		drawComponent(g);
	}

	private void drawComponent(Graphics g) {
        for (AbstractCustomBody abstractCustomBody : components) {
        	if(abstractCustomBody.getBodyType() == Constant.COMPONENT_BALL){
        		abstractCustomBody.drawSelf(g);
			}
            abstractCustomBody.drawSelf(g);
        }
    }

	private void drawBoard(Graphics g) {
		g.setColor(Color.WHITE);
		//绘制列
		int size = Constant.BOARD_SIZE / Constant.GRID_COUNT;
		for (int i = 0; i < Constant.BOARD_SIZE; i += size) {
            g.drawLine(i, 0, i, Constant.BOARD_SIZE);
        }
		//绘制行
		for (int i = 0; i < Constant.BOARD_SIZE; i += size) {
            g.drawLine(0, i, Constant.BOARD_SIZE, i);
        }
	}


    public void repaintBoard(List<AbstractCustomBody> components) {
        this.components = components;
        repaint();
    }
}
