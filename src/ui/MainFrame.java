package ui;

import constant.Constant;
import utils.ImageUtils;
import utils.ScreenUtils;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
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
		JMenuItem mNew = new JMenuItem("New");
		JMenuItem m_open = new JMenuItem("Open");
		JMenuItem mSave = new JMenuItem("Save");
		JMenuItem mExit = new JMenuItem("Exit");
		JMenu mnSetting = new JMenu("Setting");
		JCheckBoxMenuItem mCheckcollision = new JCheckBoxMenuItem("Collision Effect");
		JMenu mnHelp = new JMenu("Help");
		JMenuItem mntmAbout = new JMenuItem("About");

		menuBar.add(mnFile);
		mnFile.add(mNew);
		mnFile.add(m_open);
		mnFile.add(mSave);
		mnFile.add(mExit);

		menuBar.add(mnSetting);
		mnSetting.add(mCheckcollision);

		menuBar.add(mnHelp);
		mnHelp.add(mntmAbout);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		BoardPanel boardPanel = new BoardPanel();
		boardPanel.setLocation(10, 10);
		contentPane.add(boardPanel);

		JPanel operationPanel = new JPanel();
		operationPanel.setBackground(Color.WHITE);
		operationPanel.setBounds(633, 10, 191, 610);
		contentPane.add(operationPanel);
		operationPanel.setLayout(null);

		JPanel advanceCompPanel = new JPanel();
		advanceCompPanel.setBackground(Color.WHITE);
		advanceCompPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Advance Component", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		advanceCompPanel.setBounds(10, 184, 160, 171);
		operationPanel.add(advanceCompPanel);
		advanceCompPanel.setLayout(null);

		JButton button3 = new JButton("");
		button3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button3.setContentAreaFilled(false);
		button3.setOpaque(false);
		button3.setBackground(Color.WHITE);
		button3.setBounds(31, 21, 40, 40);
		button3.setIcon(ImageUtils.getImage("stick_square.png", 30, 30));
		advanceCompPanel.add(button3);

		JButton button_4 = new JButton("");
		button_4.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_4.setContentAreaFilled(false);
		button_4.setOpaque(false);
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(95, 21, 40, 40);
		button_4.setIcon(ImageUtils.getImage("stick.png", 30, 30));
		advanceCompPanel.add(button_4);

		JButton button_5 = new JButton("");
		button_5.setToolTipText("left board");
		button_5.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_5.setContentAreaFilled(false);
		button_5.setOpaque(false);
		button_5.setBackground(Color.WHITE);
		button_5.setBounds(31, 71, 40, 40);
		button_5.setIcon(ImageUtils.getImage("left_flipper.png", 30, 30));
		advanceCompPanel.add(button_5);

		JButton button_6 = new JButton("");
		button_6.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_6.setContentAreaFilled(false);
		button_6.setOpaque(false);
		button_6.setBackground(Color.WHITE);
		button_6.setBounds(95, 71, 40, 40);
		button_6.setIcon(ImageUtils.getImage("right_flipper.png", 30, 30));
		advanceCompPanel.add(button_6);

		JButton button_9 = new JButton("");
		button_9.setToolTipText("Absorber,used to recycle balls");
		button_9.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_9.setContentAreaFilled(false);
		button_9.setOpaque(false);
		button_9.setBackground(Color.WHITE);
		button_9.setBounds(31, 121, 40, 40);
		button_9.setIcon(ImageUtils.getImage("absorber.png", 30, 30));
		advanceCompPanel.add(button_9);

		JButton button_10 = new JButton("");
		button_10.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_10.setContentAreaFilled(false);
		button_10.setOpaque(false);
		button_10.setBackground(Color.WHITE);
		button_10.setBounds(95, 121, 40, 40);
		advanceCompPanel.add(button_10);

		JPanel basicCompoPanel = new JPanel();
		basicCompoPanel.setBorder(new TitledBorder(null, "Basic Component", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		basicCompoPanel.setBackground(Color.WHITE);
		basicCompoPanel.setBounds(10, 10, 160, 171);
		operationPanel.add(basicCompoPanel);
		basicCompoPanel.setLayout(null);

		JButton btnTrian = new JButton("");
		btnTrian.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnTrian.setContentAreaFilled(false);
		btnTrian.setOpaque(false);
		btnTrian.setBackground(Color.WHITE);
		btnTrian.setBounds(28, 20, 40, 40);
		btnTrian.setIcon(ImageUtils.getImage("circle.png", 30, 30));
		basicCompoPanel.add(btnTrian);

		JButton button = new JButton("");
		button.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setBackground(Color.WHITE);
		button.setBounds(92, 20, 40, 40);
		button.setIcon(ImageUtils.getImage("triangle.png", 30, 30));
		basicCompoPanel.add(button);

		JButton button_1 = new JButton("");
		button_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_1.setContentAreaFilled(false);
		button_1.setOpaque(false);
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(92, 70, 40, 40);
		button_1.setIcon(ImageUtils.getImage("trapezoid.png", 30, 30));
		basicCompoPanel.add(button_1);

		JButton button_2 = new JButton("");
		button_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_2.setContentAreaFilled(false);
		button_2.setOpaque(false);
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(28, 70, 40, 40);
		button_2.setIcon(ImageUtils.getImage("square.png", 30, 30));
		basicCompoPanel.add(button_2);

		JButton button_7 = new JButton("");
		button_7.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_7.setContentAreaFilled(false);
		button_7.setOpaque(false);
		button_7.setBackground(Color.WHITE);
		button_7.setBounds(28, 120, 40, 40);
		button_7.setIcon(ImageUtils.getImage("ball.png", 30, 30));
		basicCompoPanel.add(button_7);

		JButton button_8 = new JButton("");
		button_8.setBorder(new LineBorder(Color.LIGHT_GRAY));
		button_8.setContentAreaFilled(false);
		button_8.setOpaque(false);
		button_8.setBackground(Color.WHITE);
		button_8.setBounds(92, 120, 40, 40);
		basicCompoPanel.add(button_8);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 365, 160, 235);
		operationPanel.add(panel);

		JButton btnRotation = new JButton();
		btnRotation.setOpaque(false);
		btnRotation.setContentAreaFilled(false);
		btnRotation.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnRotation.setBackground(Color.WHITE);
		btnRotation.setBounds(29, 53, 40, 40);
		btnRotation.setIcon(ImageUtils.getImage("rotation.png", 30, 30));
		panel.add(btnRotation);

		JButton btnDel = new JButton();
		btnDel.setOpaque(false);
		btnDel.setContentAreaFilled(false);
		btnDel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnDel.setBackground(Color.WHITE);
		btnDel.setBounds(89, 53, 40, 40);
		btnDel.setIcon(ImageUtils.getImage("delete.png", 30, 30));
		panel.add(btnDel);

		JButton btnPlay = new JButton("Play");
		btnPlay.setOpaque(false);
		btnPlay.setContentAreaFilled(false);
		btnPlay.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnPlay.setBackground(Color.WHITE);
		btnPlay.setBounds(29, 103, 100, 30);
		btnPlay.setIcon(ImageUtils.getImage("start.png", 20, 20));
		panel.add(btnPlay);

		JButton btnDonate = new JButton("Donate");
		btnDonate.setBounds(29, 183, 100, 28);
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
		btnPause.setBounds(29, 143, 100, 28);
		btnPause.setIcon(ImageUtils.getImage("pause.png", 20, 20));
		panel.add(btnPause);

		JSpinner bodySize = new JSpinner();
		bodySize.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		bodySize.setBounds(69, 21, 60, 22);
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(bodySize, "0");
        bodySize.setEditor(editor);
        JFormattedTextField textField = ((JSpinner.NumberEditor) bodySize.getEditor()).getTextField();
        textField.setEditable(true);
        DefaultFormatterFactory factory = (DefaultFormatterFactory) textField .getFormatterFactory();
        NumberFormatter formatter = (NumberFormatter) factory.getDefaultFormatter();
        formatter.setAllowsInvalid(false);
		panel.add(bodySize);

		JLabel lblSize = new JLabel("Size:");
		lblSize.setBounds(29, 24, 40, 15);
		panel.add(lblSize);
	}
}
