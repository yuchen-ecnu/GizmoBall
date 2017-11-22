package ui;

import listener.OperationListener;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    private OperationListener listener;
    public MenuBar(OperationListener listener) {
        this.listener = listener;
        JMenu mnFile = new JMenu("File");
        JMenuItem mNew = new JMenuItem("New");
        JMenuItem m_open = new JMenuItem("Open");
        JMenuItem mSave = new JMenuItem("Save");
        JMenuItem mExit = new JMenuItem("Exit");
        JMenu mnSetting = new JMenu("Setting");
        JCheckBoxMenuItem mCheckcollision = new JCheckBoxMenuItem("Collision Effect");
        JMenu mnHelp = new JMenu("Help");
        JMenuItem mntmAbout = new JMenuItem("About");

        this.add(mnFile);
        mnFile.add(mNew);
        mnFile.add(m_open);
        mnFile.add(mSave);
        mnFile.add(mExit);

        this.add(mnSetting);
        mnSetting.add(mCheckcollision);

        this.add(mnHelp);
        mnHelp.add(mntmAbout);
    }
}
