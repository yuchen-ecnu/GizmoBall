package listener;

import entity.base.AbstractCustomBody;

import java.awt.*;

public interface OperationListener {
    void onItemAddListener(int type);
    void onItemPositionListener(Point point);
}
