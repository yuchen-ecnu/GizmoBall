package listener;

import entity.base.AbstractCustomBody;

import java.awt.*;

/**
* @description UI操作监听回调
* @author Jack Chen
* @date 2017/11/21
*/
public interface UiListener {
    boolean onItemAdd(Point point);
}
