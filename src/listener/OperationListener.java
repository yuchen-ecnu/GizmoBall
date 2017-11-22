package listener;

import java.awt.*;

public interface OperationListener {
    void onItemChoose(int type);
    void onOperationClicked(int type);
    void onBorderClicked(Point point,int size);
    void onRepaintBoard();
}
