package entity.base;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import utils.Box2DUtil;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * @description 抽象基类，封装JBOX物理引擎中的Body
 * (注：物理引擎仅提供模拟运动过程，还需要封装部分绘制的属性; eg：color)
 *
 * @author Jack Chen
 * @date 2017/11/21
 */
public abstract class AbstractCustomBody implements Serializable {
    /**JBox2D物理引擎中的刚体(Body)*/
    protected Body body;
    /**刚体的颜色*/
    protected Color color;
    /**物体尺寸，可以是半径或者边长一半*/
    protected float size;

    public Body getBody() {
        return body;
    }

    public Color getColor() {
        return color;
    }

    public float getSize() {
        return size;
    }

    public Integer getBodyType(){
        return isEmpty() ? null: (Integer) body.getUserData();
    }

    private boolean isEmpty(){
        return body == null || body.getUserData() == null;
    }

    public void rotation(World world){
        this.body = Box2DUtil.rotationBody(this,world);
    }

    public abstract void applyAngularImpulse();

    public void destroy(World world){
        world.destroyBody(body);
    }

    public abstract void drawSelf(Graphics g);

}
