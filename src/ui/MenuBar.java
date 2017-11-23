package ui;

import listener.OperationListener;

import javax.swing.*;

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
        JMenuItem mOpen = new JMenuItem("Open");
        JMenuItem mSave = new JMenuItem("Save");
        JMenuItem mExit = new JMenuItem("Exit");
        JMenu mnSetting = new JMenu("Setting");
        JCheckBoxMenuItem mCheckCollision = new JCheckBoxMenuItem("Collision Effect");
        JMenu mnHelp = new JMenu("Help");
        JMenuItem mntmAbout = new JMenuItem("About");

        this.add(mnFile);
        mnFile.add(mNew);
        mnFile.add(mOpen);
        mnFile.add(mSave);
        mnFile.add(mExit);

        this.add(mnSetting);
        mnSetting.add(mCheckCollision);

        this.add(mnHelp);
        mnHelp.add(mntmAbout);
    }
}
