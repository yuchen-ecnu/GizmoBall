package controller;

import constant.Constant;
import listener.OperationListener;
import listener.UiListener;
import org.jbox2d.dynamics.World;
import thread.DrawThread;
import ui.MainFrame;

import java.awt.*;

/**
* @description UI 控制器
* @author Jack Chen
* @date 2017/11/21
*/
public class UiController implements OperationListener{
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
    public void onBorderClicked(Point point,int size){
        if(curType!=0){
            switch (curType){
                case Constant.OPERATION_ROTATION:
                    uiListener.onOperationClicked(Constant.OPERATION_ROTATION);
                    mainFrame.repaintBoardPanel(uiListener.componentInfoProvider());
                    break;
                case Constant.OPERATION_DELETE:
                    uiListener.onOperationClicked(Constant.OPERATION_DELETE);
                    mainFrame.repaintBoardPanel(uiListener.componentInfoProvider());
                    break;
                default:
                    int unitSize = Constant.BOARD_SIZE/Constant.GRID_COUNT;
                    point.x = point.x/unitSize;
                    point.y = point.y/unitSize;
                    mainFrame.repaintBoardPanel(uiListener.onItemAdd(point,curType,size));
                    break;
            }
        }
    }

    @Override
    public void onRepaintBoard() {
        mainFrame.repaintBoardPanel(uiListener.componentInfoProvider());
    }
}
