package ui;

import constant.Constant;
import entity.base.AbstractCustomBody;
import listener.OperationListener;
import utils.ScreenUtils;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * @description UI主界面
 * @author Jack Chen
 * @date 2017/11/21
 *
 */
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private BoardPanel boardPanel;
	private MenuBar menuBar;
	private OperationPanel operationPanel;
	private Point point = new Point();

	public MainFrame(OperationListener listener) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Constant.WINDOW_MAIN_WIDTH, Constant.WINDOW_MAIN_HEIGHT);
		Dimension midDimension = ScreenUtils.getScreenMidDimension(this);
		setLocation(midDimension.width, midDimension.height);

		menuBar = new MenuBar(listener);
		setJMenuBar(menuBar);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		boardPanel = new BoardPanel(listener);
		boardPanel.setLocation(10, 10);
		contentPane.add(boardPanel);
		boardPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				point = e.getPoint();
				listener.onBorderClicked(point,operationPanel.getComponentSize());
			}
		});

		operationPanel = new OperationPanel(listener);
		contentPane.add(operationPanel);
	}

	public void repaintBoardPanel(List<AbstractCustomBody> components){
		boardPanel.repaintBoard(components);
	}
}
