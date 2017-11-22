package controller;

import entity.base.AbstractCustomBody;
import org.jbox2d.collision.AABB;
import org.jbox2d.collision.broadphase.BroadPhaseStrategy;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import java.util.ArrayList;
import java.util.List;

/**
* @description 游戏控制器
* @author Jack Chen
* @date 2017/11/21
*/
public class GameController {
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

}
