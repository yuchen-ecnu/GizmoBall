package controller;

import constant.Constant;
import listener.OperationListener;
import listener.UiListener;
import org.jbox2d.dynamics.World;
import thread.DrawThread;
import ui.MainFrame;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
* @description UI 控制器
* @author Jack Chen
* @date 2017/11/21
*/
public class UiController implements OperationListener {
    private MainFrame mainFrame;
    private UiListener uiListener;
    private int curType;

    public UiController(UiListener uiListener) {
        this.uiListener = uiListener;
        curType = 0;
        mainFrame = new MainFrame(this);
        mainFrame.setVisible(true);
    }

    @Override
    public void onItemChoose(int type) {
        curType = type;
    }

    @Override
    public void onOperationClicked(int type) {
        World world = uiListener.onOperationClicked(type);
        if(type==Constant.OPERATION_PLAY){
            new DrawThread(world,UiController.this).start();
        }
    }

    @Override
    public void onBorderClicked(Point point){
        if(curType!=0){
            int unitSize = Constant.BOARD_SIZE/Constant.GRID_COUNT;
            point.x = point.x/unitSize;
            point.y = point.y/unitSize;
            int size = mainFrame.getComponentSize();
            mainFrame.repaintBoardPanel(uiListener.onItemAdd(point,curType,size));
        }
    }

    @Override
    public void onRepaintBoard() {
        mainFrame.repaintBoardPanel(uiListener.componentInfoProvider());
    }

    @Override
    public void onMenuBarClicked(int type) {
        uiListener.onMenuClicked(type);
        mainFrame.repaintBoardPanel(uiListener.componentInfoProvider());
    }

    @Override
    public void onKeyPressed() {
        uiListener.onKeyPressed();
        mainFrame.repaintBoardPanel(uiListener.componentInfoProvider());
    }

    @Override
    public void onDestroy() {
        uiListener.onDestroy();
    }
}
