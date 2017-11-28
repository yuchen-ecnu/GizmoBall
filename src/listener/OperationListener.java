package listener;

import java.awt.*;
import java.awt.event.KeyEvent;

public interface OperationListener {
    void onItemChoose(int type);
    void onOperationClicked(int type);
    void onBorderClicked(Point point);
    void onRepaintBoard();
    void onMenuBarClicked(int type);
    void onKeyPressed();
    void onDestroy();
}
