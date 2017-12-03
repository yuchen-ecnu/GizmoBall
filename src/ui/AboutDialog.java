package ui;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constant.Constant;
import utils.ImageUtils;
import utils.ScreenUtils;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AboutDialog() {
		setResizable(false);
		setSize(537, 373);
		Dimension midDimension = ScreenUtils.getScreenMidDimension(this);
		setLocation(midDimension.width, midDimension.height);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextArea txtrCopyrightc = new JTextArea();
			txtrCopyrightc.setFont(new Font("Consolas", Font.PLAIN, 13));
			txtrCopyrightc.setWrapStyleWord(true);
			txtrCopyrightc.setOpaque(false);
			txtrCopyrightc.setLineWrap(true);
			txtrCopyrightc.setBounds(202, 39, 309, 146);
			txtrCopyrightc.setText("  Copyright (C) 2017 ChenYu <920901835@qq.com>,ZhangSiyuan<642201240@qq.com>,ZhaoChen<704168041@qq.com>\r\n  This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.");
			contentPanel.add(txtrCopyrightc);
		}
		
		JTextArea txtrThisProgramIs = new JTextArea();
		txtrThisProgramIs.setFont(new Font("Consolas", Font.PLAIN, 13));
		txtrThisProgramIs.setWrapStyleWord(true);
		txtrThisProgramIs.setText("  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.\r\n  You should have received a copy of the GNU General Public License along with this program. If not, see the license wiki page.");
		txtrThisProgramIs.setOpaque(false);
		txtrThisProgramIs.setLineWrap(true);
		txtrThisProgramIs.setBounds(10, 190, 501, 122);
		contentPanel.add(txtrThisProgramIs);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 14, 182, 160);
		lblNewLabel.setIcon(ImageUtils.getImage(Constant.IMG_JAVA, 182, 160));
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
