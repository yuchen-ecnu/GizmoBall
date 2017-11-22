package utils;

import constant.Constant;
import entity.CircleBody;
import entity.SquareBody;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.*;

import static constant.Constant.RATE;

/**
 * @description 刚体生成类
 * @author Jack Chen
 * @date 2017/11/21
 */
public class Box2DUtil {

    /**
     * 创建正方形
     * @param x 物体横坐标
     * @param y 物体纵坐标
     * @param size 正方形边长
     * @param isStatic 是否固定
     * @param world 所属模拟世界
     * @param color 颜色
     */
    public static SquareBody createSquare(float x,float y, float size, boolean isStatic, World world, int color) {
         //自定义形状
         PolygonShape polygon =new PolygonShape();
         polygon.setAsBox(size/2/RATE, size/2/RATE);
         //配置物体属性参数
         FixtureDef fDef=new FixtureDef();
         if(isStatic) {
             fDef.density=0;
         } else {
             fDef.density=1;
         }
         //摩擦因子
         fDef.friction=1.0f;
         //恢复系数
         fDef.restitution=0.0f;
         fDef.shape=polygon;

         //创建刚体
         BodyDef bodyDef=new BodyDef();
         bodyDef.type=isStatic? BodyType.STATIC:BodyType.DYNAMIC;
         bodyDef.position.set((x+size/2)/RATE,(y+size/2)/RATE );

         Body body=world.createBody(bodyDef);
         body.createFixture(fDef);
         return new SquareBody(body,color);
     }

    public static CircleBody createCircle(float x,float y, float rate, boolean isStatic, World world, int color){
         CircleShape circleShape = new CircleShape();
         circleShape.m_radius = rate/ Constant.RATE;

    }
}
