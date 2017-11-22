package controller;

import entity.AbsorberBody;
import entity.CircleBody;
import entity.base.AbstractCustomBody;
import javafx.scene.layout.BorderPane;
import listener.OperationListener;
import listener.UiListener;
import ui.BoardPanel;
import ui.DonateDialog;
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
    private AbstractCustomBody abstractCustomBody;

    public UiController(UiListener uiListener) {
        this.uiListener = uiListener;
        mainFrame = new MainFrame(this);
        mainFrame.setVisible(true);
    }

    @Override
    public void onItemAddListener(int type) {
        switch (type) {
            case 1:
                abstractCustomBody = new CircleBody();
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemPositionListener(Point point){
        if(uiListener.onItemAdd(point)){
            mainFrame.draw(abstractCustomBody,point);
        }
    }
}
