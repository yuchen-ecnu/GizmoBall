package controller;

import constant.Constant;
import entity.*;
import entity.base.AbstractCustomBody;
import listener.UiListener;
import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.contacts.Contact;
import utils.Box2DUtil;
import utils.FileUtils;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
* @description 游戏控制器
* @author Jack Chen
* @date 2017/11/21
*/
public class GameController implements UiListener, ContactListener {
    private World world;
    private List<AbstractCustomBody> components;
    
    public GameController() {
        components = new ArrayList<>();
        //创建 重力加速度为10 的世界
        world = new World(new Vec2(0.0f,10.0f));
        world.setContactListener(this);
        //创建边界
        Box2DUtil.createBoarder(Constant.GRID_COUNT,Constant.GRID_COUNT,world);
    }

    /**
     * 判断当前位置是否为空
     * @param x 坐标x
     * @param y 坐标y
     * @param size size大小
     * @return
     */
    public AbstractCustomBody isEmpty(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                AbstractCustomBody body = getComponent(i, j);
                if (body != null) {
                    return body;
                }
            }
        }
        return null;
    }

    /**
     * 根据坐标获取组件（第一个被添加的）
     * @param x 坐标x
     * @param y 坐标y
     * @return
     */
    private AbstractCustomBody getComponent(int x,int y) {
        for (int i = 0; i < components.size(); i++) {
            AbstractCustomBody comp = components.get(i);
            float size = comp.getSize()*Constant.RATE;
            Body body = comp.getBody();
            if(body!=null){
                float x1 = comp.getBody().getPosition().x*Constant.RATE-size;
                float y1 = comp.getBody().getPosition().y*Constant.RATE-size;
                if (x >= x1 && x < x1 + size*2 && y >= y1 && y < y1 + size*2){
                    return comp;
                }
            }
        }
        return null;
    }

    @Override
    public List<AbstractCustomBody> onItemAdd(Point point, int currentType,int size) {
        AbstractCustomBody body = isEmpty(point.x, point.y,size);
        if (body != null) {
            switch (currentType) {
                case Constant.OPERATION_ROTATION:
                    getComponent(point.x, point.y).rotation(world);
                    break;
                case Constant.OPERATION_DELETE:
                    getComponent(point.x, point.y).destroy(world);
                    components.remove(body);
                    break;
                default:
                    break;
            }
        }else if(body==null) {
            switch (currentType) {
                case Constant.COMPONENT_CIRCLE:
                    CircleBody circleBody = Box2DUtil.createCircle(point.x,point.y,size,true,world,Constant.COLOR_SQUARE);
                    components.add(circleBody);
                    break;
                case Constant.COMPONENT_TRIANGLE:
                    TriangleBody triangleBody = Box2DUtil.createTriangle(point.x,point.y,size,0,true,world,Constant.COLOR_SQUARE);
                    components.add(triangleBody);
                    break;
                case Constant.COMPONENT_SQUARE:
                    SquareBody squareBody = Box2DUtil.createSquare(point.x,point.y,size,world,Constant.COLOR_SQUARE);
                    components.add(squareBody);
                    break;
                case Constant.COMPONENT_TRAPEZOID:
                    TrapezoidBody trapezoidBody = Box2DUtil.createTrapezoidBody(point.x,point.y,size,0,true,world,Constant.COLOR_SQUARE);
                    components.add(trapezoidBody);
                    break;
                case Constant.COMPONENT_BALL:
                    Ball ball = Box2DUtil.createBall(point.x,point.y,world,Constant.COLOR_SQUARE);
                    components.add(ball);
                    break;
                case Constant.COMPONENT_ADVANCED_SQUARE:
                    AdvanceSquareBody advanceSquareBody = Box2DUtil.createAdvanceSquareBody(point.x,point.y,size,world,Constant.COLOR_SQUARE);
                    components.add(advanceSquareBody);
                    break;
                case Constant.COMPONENT_ELASTIC_PLATE:
                    ElasticPlateBody elasticPlateBody = Box2DUtil.createElasticPlateBody(point.x,point.y,size,0,world,Constant.COLOR_SQUARE);
                    components.add(elasticPlateBody);
                    break;
                case Constant.COMPONENT_LEFT_BAFFLE:
                    BaffleBody leftBaffleBody = Box2DUtil.createBaffleBody(point.x,point.y,size,Constant.COMPONENT_LEFT_BAFFLE,world,Constant.COLOR_SQUARE);
                    components.add(leftBaffleBody);
                    break;
                case Constant.COMPONENT_RIGHT_BAFFLE:
                    BaffleBody rightBaffleBody = Box2DUtil.createBaffleBody(point.x,point.y,size,Constant.COMPONENT_RIGHT_BAFFLE,world,Constant.COLOR_SQUARE);
                    components.add(rightBaffleBody);
                    break;
                case Constant.COMPONENT_ABSORBER:
                    AbsorberBody absorberBody = Box2DUtil.createAbsorber(point.x,point.y,size,world,Constant.COLOR_SQUARE);
                    components.add(absorberBody);
                    break;
                default:
                    break;
            }
        }
        return components;
    }

    @Override
    public World onOperationClicked(int type) {
        switch(type){
            case Constant.OPERATION_PLAY:
                Constant.DRAW_THREAD_FLAG = true;
                break;
            case Constant.OPERATION_PAUSE:
                Constant.DRAW_THREAD_FLAG = false;
                break;
            default:
                break;
        }
        return world;
    }

    @Override
    public List<AbstractCustomBody> componentInfoProvider() {
        return components;
    }

    @Override
    public void onMenuClicked(int type){
        if(type == Constant.MENUBAR_FILE_NEW){
            this.components.clear();
        }else if(type == Constant.MENUBAR_FILE_EXIT){
            System.exit(0);
        }else if(type == Constant.MENUBAR_FILE_SAVE){
            FileUtils.writeToFile(components);
        }else if(type == Constant.MENUBAR_FILE_OPEN){
            FileUtils.readFromFile();
        }
    }


    @Override
    public void beginContact(Contact contact) {
        //吸收器
        Body bodyA = contact.getFixtureA().getBody();
        Body bodyB = contact.getFixtureB().getBody();
        if(bodyA==null||bodyA.getUserData()==null
                ||bodyB==null||bodyB.getUserData()==null) {
            return;
        }
        if((int) bodyA.getUserData()==Constant.COMPONENT_ABSORBER
                &&(int) bodyB.getUserData()==Constant.COMPONENT_BALL) {
            world.destroyBody(bodyB);
        }else if((int) bodyB.getUserData()==Constant.COMPONENT_ABSORBER
                &&(int) bodyA.getUserData()==Constant.COMPONENT_BALL){
            world.destroyBody(bodyA);
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold manifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse contactImpulse) {

    }

}
