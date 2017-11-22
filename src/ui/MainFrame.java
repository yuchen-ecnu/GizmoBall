package ui;

import constant.Constant;
import entity.base.AbstractCustomBody;
import listener.OperationListener;
import utils.ImageUtils;
import utils.ScreenUtils;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @description 主窗口
 * @author Jack Chen
 * @date 2017/11/21
 *
 * //TODO: 优化代码
 */
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private BoardPanel boardPanel;
	private MenuBar menuBar;
	private OperationPanel operationPanel;
	private Point point = new Point();

	/**
	 * Create the frame.
	 */
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
				listener.onItemPositionListener(point);
			}
		});

		operationPanel = new OperationPanel(listener);
		contentPane.add(operationPanel);
	}

	public void draw(AbstractCustomBody abstractCustomBody,Point point){
		boardPanel.draw(abstractCustomBody,point);
	}
}
