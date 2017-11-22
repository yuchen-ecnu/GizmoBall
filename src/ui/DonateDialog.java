package ui;

import constant.Constant;
import utils.ImageUtils;
import utils.ScreenUtils;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextArea;

/**
 * @description 捐赠Dialog
 * @author Jack Chen
 * @date 2017/11/21
 */
public class DonateDialog extends JDialog {

	private final JPanel contentPanel;
	private JLabel picContent;
	private JTextArea donatetext;
	
	
	/**
	 * Create the dialog.
	 */
	public DonateDialog() {
		setResizable(false);
		setSize(Constant.WINDOW_DONATE_WIDTH, Constant.WINDOW_DONATE_HEIGHT);
		Dimension midDimension = ScreenUtils.getScreenMidDimension(this);
		setLocation(midDimension.width, midDimension.height);
		
		getContentPane().setLayout(null);
		contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 360, 546);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		donatetext = new JTextArea();
		donatetext.setEditable(false);
		donatetext.setLineWrap(true);
		donatetext.setFont(new Font("Consolas", Font.BOLD, 16));
		donatetext.setForeground(Color.WHITE);
		donatetext.setOpaque(false);
		donatetext.setText("      If you think it's helpful       Why do not you buy a starbaba for us?");
		donatetext.setBounds(10, 485, 350, 51);
		contentPanel.add(donatetext);
		picContent = new JLabel("");
		picContent.setBounds(0, 0, 350, 536);
		contentPanel.add(picContent);
		
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int width = picContent.getWidth();
		int height = picContent.getHeight();
		picContent.setIcon(ImageUtils.getImage(Constant.IMG_DONATE, width, height));
	}
}
