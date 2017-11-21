package ui;

import constant.Constant;
import utils.ImageUtils;
import utils.ScreenUtils;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @description 主窗口
 * @author Jack Chen
 * @date 2017/11/21
 *
 * //TODO: 优化代码
 */
public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Constant.WINDOW_MAIN_WIDTH, Constant.WINDOW_MAIN_HEIGHT);
		Dimension midDimension = ScreenUtils.getScreenMidDimension(this);
		setLocation(midDimension.width, midDimension.height);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem m_new = new JMenuItem("New");
		mnFile.add(m_new);
		
		JMenuItem m_open = new JMenuItem("Open");
		mnFile.add(m_open);
		
		JMenuItem m_save = new JMenuItem("Save");
		mnFile.add(m_save);
		
		JMenuItem m_exit = new JMenuItem("Exit");
		mnFile.add(m_exit);
		
		JMenu mnSetting = new JMenu("Setting");
		menuBar.add(mnSetting);
		
		JCheckBoxMenuItem m_checkCollision = new JCheckBoxMenuItem("Collision Effect");
		mnSetting.add(m_checkCollision);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BoardPanel boardPanel = new BoardPanel();
		contentPane.add(boardPanel);
		
		JPanel operationPanel = new JPanel();
		operationPanel.setBackground(Color.WHITE);
		operationPanel.setBounds(633, 10, 191, 610);
		contentPane.add(operationPanel);
		operationPanel.setLayout(null);
		
		JPanel basicCompPanel = new JPanel();
		basicCompPanel.setBackground(Color.WHITE);
		basicCompPanel.setBorder(new TitledBorder(null, "Basic Component", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		basicCompPanel.setBounds(10, 202, 160, 182);
		operationPanel.add(basicCompPanel);
		basicCompPanel.setLayout(null);
		
		JButton button_3 = new JButton("");
		button_3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_3.setContentAreaFilled(false);
		button_3.setOpaque(false);
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(30, 27, 40, 40);
		basicCompPanel.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_4.setContentAreaFilled(false);
		button_4.setOpaque(false);
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(94, 27, 40, 40);
		basicCompPanel.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_5.setContentAreaFilled(false);
		button_5.setOpaque(false);
		button_5.setBackground(Color.WHITE);
		button_5.setBounds(30, 77, 40, 40);
		basicCompPanel.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_6.setContentAreaFilled(false);
		button_6.setOpaque(false);
		button_6.setBackground(Color.WHITE);
		button_6.setBounds(94, 77, 40, 40);
		basicCompPanel.add(button_6);
		
		JButton button_9 = new JButton("");
		button_9.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_9.setContentAreaFilled(false);
		button_9.setOpaque(false);
		button_9.setBackground(Color.WHITE);
		button_9.setBounds(30, 132, 40, 40);
		basicCompPanel.add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_10.setContentAreaFilled(false);
		button_10.setOpaque(false);
		button_10.setBackground(Color.WHITE);
		button_10.setBounds(94, 132, 40, 40);
		basicCompPanel.add(button_10);
		
		JPanel AdvanCompPanel = new JPanel();
		AdvanCompPanel.setBorder(new TitledBorder(null, "Basic Component", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		AdvanCompPanel.setBackground(Color.WHITE);
		AdvanCompPanel.setBounds(10, 10, 160, 182);
		operationPanel.add(AdvanCompPanel);
		AdvanCompPanel.setLayout(null);
		
		JButton btnTrian = new JButton("");
		btnTrian.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnTrian.setContentAreaFilled(false);
		btnTrian.setOpaque(false);
		btnTrian.setBackground(Color.WHITE);
		btnTrian.setBounds(28, 32, 40, 40);
		AdvanCompPanel.add(btnTrian);
		
		JButton button = new JButton("");
		button.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setBackground(Color.WHITE);
		button.setBounds(92, 32, 40, 40);
		AdvanCompPanel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_1.setContentAreaFilled(false);
		button_1.setOpaque(false);
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(92, 82, 40, 40);
		AdvanCompPanel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_2.setContentAreaFilled(false);
		button_2.setOpaque(false);
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(28, 82, 40, 40);
		AdvanCompPanel.add(button_2);
		
		JButton button_7 = new JButton("");
		button_7.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_7.setContentAreaFilled(false);
		button_7.setOpaque(false);
		button_7.setBackground(Color.WHITE);
		button_7.setBounds(28, 132, 40, 40);
		AdvanCompPanel.add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_8.setContentAreaFilled(false);
		button_8.setOpaque(false);
		button_8.setBackground(Color.WHITE);
		button_8.setBounds(92, 132, 40, 40);
		AdvanCompPanel.add(button_8);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 395, 160, 205);
		operationPanel.add(panel);
		
		JButton btnRotation = new JButton();
		btnRotation.setOpaque(false);
		btnRotation.setContentAreaFilled(false);
		btnRotation.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnRotation.setBackground(Color.WHITE);
		btnRotation.setBounds(30, 30, 40, 40);
		btnRotation.setIcon(ImageUtils.getImage("rotation.png", 30, 30));
		panel.add(btnRotation);
		
		JButton btnDel = new JButton();
		btnDel.setOpaque(false);
		btnDel.setContentAreaFilled(false);
		btnDel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnDel.setBackground(Color.WHITE);
		btnDel.setBounds(90, 30, 40, 40);
		btnDel.setIcon(ImageUtils.getImage("delete.png", 30, 30));
		panel.add(btnDel);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setOpaque(false);
		btnPlay.setContentAreaFilled(false);
		btnPlay.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnPlay.setBackground(Color.WHITE);
		btnPlay.setBounds(30, 80, 100, 30);
		btnPlay.setIcon(ImageUtils.getImage("start.png", 20, 20));
		panel.add(btnPlay);
		
		JButton btnDonate = new JButton("Donate");
		btnDonate.setBounds(30, 160, 100, 28);
		btnDonate.setIcon(ImageUtils.getImage("donate.png", 20, 20));
		panel.add(btnDonate);
		btnDonate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DonateDialog dialog = new DonateDialog(MainFrame.this);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		btnDonate.setOpaque(false);
		btnDonate.setContentAreaFilled(false);
		btnDonate.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnDonate.setBackground(Color.WHITE);
		
		JButton btnPause = new JButton("Pause");
		btnPause.setOpaque(false);
		btnPause.setContentAreaFilled(false);
		btnPause.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnPause.setBackground(Color.WHITE);
		btnPause.setBounds(30, 120, 100, 28);
		btnPause.setIcon(ImageUtils.getImage("pause.png", 20, 20));
		panel.add(btnPause);
	}
}
