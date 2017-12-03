package ui;

import constant.Constant;
import listener.OperationListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ConcurrentModificationException;

/**
 * @description 菜单栏
 * @author Jack Chen
 * @date 2017/11/23
 */
public class MenuBar extends JMenuBar {

    private OperationListener listener;

    public MenuBar(OperationListener listener) {
        this.listener = listener;

        JMenu mnFile = new JMenu("File");
        JMenuItem mNew = new JMenuItem("New");
        mNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onMenuBarClicked(Constant. MENUBAR_FILE_NEW);
            }
        });
        JMenuItem mOpen = new JMenuItem("Open");
        mOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onMenuBarClicked(Constant. MENUBAR_FILE_OPEN);
            }
        });
        JMenuItem mSave = new JMenuItem("Save");
        mSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onMenuBarClicked(Constant. MENUBAR_FILE_SAVE);
            }
        });
        JMenuItem mExit = new JMenuItem("Exit");
        mExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onMenuBarClicked(Constant. MENUBAR_FILE_EXIT);
            }
        });
        JMenu mnHelp = new JMenu("Help");
        JMenuItem mntmAbout = new JMenuItem("About");
        mntmAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutDialog dialog = new AboutDialog();
                dialog.setVisible(true);
            }
        });

        this.add(mnFile);
        mnFile.add(mNew);
        mnFile.add(mOpen);
        mnFile.add(mSave);
        mnFile.add(mExit);


        this.add(mnHelp);
        mnHelp.add(mntmAbout);
    }
}
