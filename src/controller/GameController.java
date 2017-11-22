package controller;

import constant.Constant;
import entity.SquareBody;
import entity.base.AbstractCustomBody;
import listener.UiListener;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;
import utils.Box2DUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
* @description 游戏控制器
* @author Jack Chen
* @date 2017/11/21
*/
public class GameController implements UiListener{
    private World world;
    private List<AbstractCustomBody> components;
    
    public GameController() {
        components = new ArrayList<>();
        //创建 重力加速度为10 的世界
        world = new World(new Vec2(0.0f,10.0f));
        //创建边界
        createBoundary();
    }

    /**
     * 创建边界
     */
    private void createBoundary() {

    }
    public boolean isEmpty(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (getComponent(i, j) != null) {
                    return false;
                }
            }
        }
        return true;
    }

    private AbstractCustomBody getComponent(int x,int y) {
        //TODO:
//        for (int i = 0; i < components.size(); i++) {
//            AbstractCustomBody temp = components.get(i);
//            int tempX = temp.getX();
//            int tempY = temp.getY();
//            int sizeRate = temp.getSizeRate();
//            if (x >= tempX && x < tempX + sizeRate && y >= tempY && y < tempY + sizeRate){
//                return temp;
//            }
//        }
        return null;
    }

    @Override
    public List<AbstractCustomBody> onItemAdd(Point point, int currentType,int size) {
        if(isEmpty(point.x, point.y,size)) {
            switch (currentType) {
                case Constant.COMPONENT_CIRCLE:

                    break;
                case Constant.COMPONENT_TRIANGLE:
                    break;
                case Constant.COMPONENT_SQUARE:
                    SquareBody squareBody = Box2DUtil.createSquare(point.x,point.y,size,false,world,Constant.COLOR_SQUARE);
                    components.add(squareBody);
                    break;
                case Constant.COMPONENT_TRAPEZOID:
                    break;
                case Constant.COMPONENT_BALL:
                    break;
                case Constant.COMPONENT_ADVANCED_SQUARE:
                    break;
                case Constant.COMPONENT_ELASTIC_PLATE:
                    break;
                case Constant.COMPONENT_LEFT_BAFFLE:
                    break;
                case Constant.COMPONENT_RIGHT_BAFFLE:
                    break;
                case Constant.COMPONENT_ABSORBER:
                    break;
                default:
                    break;
            }
        }
        return components;
    }

    @Override
    public void onOperationClicked(int type) {
        if(type == Constant.OPERATION_PLAY){
            Constant.DRAW_THREAD_FLAG = true;
        }else if(type == Constant.OPERATION_PAUSE){
            Constant.DRAW_THREAD_FLAG = false;
        }
    }

    @Override
    public List<AbstractCustomBody> componentInfoProvider() {
        return components;
    }
}
