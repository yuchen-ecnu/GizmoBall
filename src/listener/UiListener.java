package listener;

import entity.base.AbstractCustomBody;

import java.awt.*;
import java.util.List;


/**
* @description UI操作监听回调
* @author Jack Chen
* @date 2017/11/21
*/
public interface UiListener {
    List<AbstractCustomBody> onItemAdd(Point point, int currentType,int size);
    void onOperationClicked(int type);
    List<AbstractCustomBody> componentInfoProvider();
}
