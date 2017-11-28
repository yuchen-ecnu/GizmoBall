package thread;

import constant.Constant;
import listener.OperationListener;
import listener.UiListener;
import org.jbox2d.dynamics.World;
import ui.BoardPanel;

import java.util.List;

/**
 * @description 绘制线程，负责刷新界面
 * @author Jack Chen
 * @date 2017/11/21
 */
public class DrawThread extends Thread {
    private World world;
    private OperationListener operationListener;

    public DrawThread(World world, OperationListener operationListener) {
        this.world = world;
        this.operationListener = operationListener;
    }

    @Override
    public void run() {
        while(Constant.DRAW_THREAD_FLAG){
            world.step(Constant.TIME_STEP,Constant.VELOCITY_ITERATION,Constant.POSITION_ITERATION);
            operationListener.onRepaintBoard();
            operationListener.onDestroy();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
