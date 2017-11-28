package utils;

import constant.Constant;
import entity.*;
import entity.base.AbstractCustomBody;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;
import org.jbox2d.dynamics.joints.RevoluteJointDef;

import javax.swing.*;
import java.awt.*;


/**
 * @description 刚体生成类（内部将按照比例尺转化）
 *              坐标系为 右->x  | 下->y
 * @author Jack Chen
 * @date 2017/11/21
 */
public class Box2DUtil {

    public static Body rotationBody(AbstractCustomBody abstractCustomBody, World world){
        if(abstractCustomBody==null||abstractCustomBody.getBody()==null){
            return null;
        }
        Body body = abstractCustomBody.getBody();
        int type = (int) body.getUserData();
        float angle = (float) (body.getAngle() + Math.PI/2);
        float size = abstractCustomBody.getSize() * Constant.RATE;
        float x = body.getPosition().x * Constant.RATE - size;
        float y = body.getPosition().y * Constant.RATE - size;
        Body retBody = null;
        switch (type){
            case Constant.COMPONENT_CIRCLE:
                CircleBody circleBody = Box2DUtil.createCircle(x,y,size*2,true,world,Constant.COLOR_SQUARE);
                retBody = circleBody.getBody();
                break;
            case Constant.COMPONENT_TRIANGLE:
                TriangleBody triangleBody = Box2DUtil.createTriangle(x,y,size*2,angle,true,world,Constant.COLOR_SQUARE);
                retBody = triangleBody.getBody();
                break;
            case Constant.COMPONENT_SQUARE:
                SquareBody squareBody = Box2DUtil.createSquare(x,y,size*2,world,Constant.COLOR_SQUARE);
                retBody = squareBody.getBody();
                break;
            case Constant.COMPONENT_TRAPEZOID:
                TrapezoidBody trapezoidBody = Box2DUtil.createTrapezoidBody(x,y,size*2,angle,true,world,Constant.COLOR_SQUARE);
                retBody = trapezoidBody.getBody();
                break;
            case Constant.COMPONENT_BALL:
                Ball ball = Box2DUtil.createBall(x,y,world,Constant.COLOR_SQUARE);
                retBody = ball.getBody();
                break;
            case Constant.COMPONENT_ADVANCED_SQUARE:
                AdvanceSquareBody advanceSquareBody = Box2DUtil.createAdvanceSquareBody(x,y,size*2,world,Constant.COLOR_SQUARE);
                retBody = advanceSquareBody.getBody();
                break;
            case Constant.COMPONENT_ELASTIC_PLATE:
                ElasticPlateBody elasticPlateBody = Box2DUtil.createElasticPlateBody(x,y,size*2,angle,world,Constant.COLOR_SQUARE);
                retBody = elasticPlateBody.getBody();
                break;
            case Constant.COMPONENT_LEFT_BAFFLE:
                BaffleBody leftBaffleBody = Box2DUtil.createBaffleBody(x,y,size*2,Constant.COMPONENT_LEFT_BAFFLE,world,Constant.COLOR_SQUARE);
                retBody = leftBaffleBody.getBody();
                break;
            case Constant.COMPONENT_RIGHT_BAFFLE:
                BaffleBody rightBaffleBody = Box2DUtil.createBaffleBody(x,y,size*2,Constant.COMPONENT_RIGHT_BAFFLE,world,Constant.COLOR_SQUARE);
                retBody = rightBaffleBody.getBody();
                break;
            case Constant.COMPONENT_ABSORBER:
                AbsorberBody absorberBody = Box2DUtil.createAbsorber(x,y,size*2,world,Constant.COLOR_SQUARE);
                retBody = absorberBody.getBody();
                break;
            default:
                break;
        }
        world.destroyBody(body);
        return retBody;
    }


    /**
     * 创建正方形
     * @param x 物体横坐标
     * @param y 物体纵坐标
     * @param size 正方形边长
     * @param world 所属模拟世界
     * @param color 颜色
     */
    public static SquareBody createSquare(float x,float y, float size, World world, Color color) {
         //自定义形状
        PolygonShape polygon =new PolygonShape();
        float r = size / 2.0f / Constant.RATE;
        polygon.setAsBox(r, r);
        //配置物体属性参数
        FixtureDef fDef=new FixtureDef();
        fDef.density=Constant.COMPONENT_DESTINY;
        //摩擦因子
        fDef.friction=1.0f;
        //恢复系数
        fDef.restitution=1.0f;
        fDef.shape=polygon;

        //创建刚体
        BodyDef bodyDef=new BodyDef();
        bodyDef.gravityScale = 0;
        bodyDef.type=BodyType.DYNAMIC;
        bodyDef.position.set(x/Constant.RATE + r,y/Constant.RATE + r);

        Body body=world.createBody(bodyDef);
        body.createFixture(fDef);
        return new SquareBody(body,r,color);
     }

    /**
     * 创建完全弹性碰撞正方形
     * @param x 物体横坐标
     * @param y 物体纵坐标
     * @param size 吸收器边长
     * @param world 所属模拟世界
     * @param color 颜色
     */
    public static AdvanceSquareBody createAdvanceSquareBody(float x,float y, float size, World world, Color color) {
        //自定义形状
        PolygonShape polygon =new PolygonShape();
        float r = size / 2.0f / Constant.RATE;
        polygon.setAsBox(r, r);
        //配置物体属性参数
        FixtureDef fDef=new FixtureDef();
        fDef.density=0;
        //摩擦因子
        fDef.friction=1.0f;
        //恢复系数
        fDef.restitution=0.0f;
        fDef.shape=polygon;

        //创建刚体
        BodyDef bodyDef=new BodyDef();
        bodyDef.type=BodyType.STATIC;
        bodyDef.position.set(x/Constant.RATE + r,y/Constant.RATE + r);

        Body body=world.createBody(bodyDef);
        body.createFixture(fDef);
        return new AdvanceSquareBody(body,r,color);
    }

    /**
     * 创建弹力板
     * @param x 物体横坐标
     * @param y 物体纵坐标
     * @param length 弹力板长度
     * @param world 所属模拟世界
     * @param color 颜色
     */
    public static ElasticPlateBody createElasticPlateBody(float x,float y, float length,float angle, World world, Color color) {
        //自定义形状
        PolygonShape polygon =new PolygonShape();
        float r = length / 2.0f / Constant.RATE;
        //宽高
        polygon.setAsBox(r, r/10.0f);
        //配置物体属性参数
        FixtureDef fDef=new FixtureDef();
        fDef.density=0;
        //摩擦因子
        fDef.friction=1.0f;
        //恢复系数
        fDef.restitution=1.5f;
        fDef.shape=polygon;

        //创建刚体
        BodyDef bodyDef=new BodyDef();
        bodyDef.type=BodyType.STATIC;
        bodyDef.angle = angle;
        bodyDef.position.set(x/Constant.RATE + r,y/Constant.RATE + r);

        Body body=world.createBody(bodyDef);
        body.createFixture(fDef);
        return new ElasticPlateBody(body,r,color);
    }

    /**
     * 创建可活动挡板
     * @param x 物体横坐标
     * @param y 物体纵坐标
     * @param length 挡板长度
     * @param direction 挡板位置，0--左边；1--右边
     * @param world 所属模拟世界
     * @param color 颜色
     */
    public static BaffleBody createBaffleBody(float x,float y, float length, int direction, World world, Color color) {
        //自定义形状
        PolygonShape polygon =new PolygonShape();
        float r = length / 2.0f / Constant.RATE;
        //宽高
        polygon.setAsBox(r/6.0f, r);
        //配置物体属性参数
        FixtureDef fDef=new FixtureDef();
        fDef.density=0;
        //摩擦因子
        fDef.friction=1.0f;
        //恢复系数
        fDef.restitution=1.0f;
        fDef.shape=polygon;

        //创建刚体
        BodyDef bodyDef=new BodyDef();
        bodyDef.type=BodyType.STATIC;
        if(direction == Constant.COMPONENT_LEFT_BAFFLE){
            bodyDef.position.set(x/Constant.RATE,y/Constant.RATE + r);
        }else{
            bodyDef.position.set(x/Constant.RATE + 2*r,y/Constant.RATE + r);
        }

        Body body=world.createBody(bodyDef);
        body.createFixture(fDef);

        //创建定点（旋转关节）
        RevoluteJointDef rjd = new RevoluteJointDef();
        if (direction == Constant.COMPONENT_LEFT_BAFFLE) {
            rjd.initialize(body, body, new Vec2(((x + 0.875f) * length / Constant.RATE), y * length / Constant.RATE));
            rjd.upperAngle = 0;
            rjd.lowerAngle = -(float) (Math.PI / 2);
        } else {
            rjd.initialize(body, body, new Vec2((x + 0.125f) * length / Constant.RATE, y * length / Constant.RATE));
            rjd.lowerAngle = 0;
            rjd.upperAngle = (float) (Math.PI / 2);
        }
        return new BaffleBody(body,direction,r,color);
    }

    /**
     * 创建吸收器
     * @param x 物体横坐标
     * @param y 物体纵坐标
     * @param size 正方形边长
     * @param world 所属模拟世界
     * @param color 颜色
     */
    public static AbsorberBody createAbsorber(float x,float y, float size, World world, Color color) {
        //自定义形状
        PolygonShape polygon =new PolygonShape();
        float r = size / 2.0f / Constant.RATE;
        polygon.setAsBox(r, r);
        //配置物体属性参数
        FixtureDef fDef=new FixtureDef();
        fDef.density=0;
        //摩擦因子
        fDef.friction=1.0f;
        //恢复系数
        fDef.restitution=0.0f;
        fDef.shape=polygon;

        //创建刚体
        BodyDef bodyDef=new BodyDef();
        bodyDef.type=BodyType.STATIC;
        bodyDef.position.set(x/Constant.RATE + r,y/Constant.RATE + r);

        Body body=world.createBody(bodyDef);
        body.createFixture(fDef);
        return new AbsorberBody(body,r,color);
    }

    /**
     * 创建圆形
     * @param x 物体横坐标
     * @param y 物体纵坐标
     * @param radius 物体半径
     * @param isStatic 是否固定
     * @param world 所属虚拟世界
     * @param color 物体颜色
     * @return
     */
    public static CircleBody createCircle(float x,float y, float radius, boolean isStatic, World world, Color color){
        CircleShape circleShape = new CircleShape();
        float r = radius / 2.0f / Constant.RATE;
        circleShape.setRadius(r);
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
        fDef.restitution=1.0f;
        fDef.shape = circleShape;

        //创建刚体
        BodyDef bodyDef=new BodyDef();
        bodyDef.type=isStatic? BodyType.STATIC:BodyType.DYNAMIC;
        bodyDef.position.set(x / Constant.RATE + r ,y / Constant.RATE + r);
        Body body=world.createBody(bodyDef);
        body.createFixture(fDef);
        return new CircleBody(body,r,color);
    }

    /**
     * 创建等腰三角形
     * @param x 物体横坐标
     * @param y 物体中坐标
     * @param size 直角边长
     * @param isStatic 是否固定
     * @param world 所属虚拟世界
     * @param color 物体颜色
     * @return
     */
    public static TriangleBody createTriangle(float x, float y, float size,float angle, boolean isStatic, World world, Color color){
        PolygonShape triangleShape = new PolygonShape();
        float r = size / 2.0f / Constant.RATE;
        triangleShape.set(new Vec2[]{new Vec2(-r, -r), new Vec2(-r, r), new Vec2(r, -r)},3);
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
        fDef.restitution=1.0f;
        fDef.shape = triangleShape;

        //创建刚体
        BodyDef bodyDef=new BodyDef();
        bodyDef.type=isStatic? BodyType.STATIC:BodyType.DYNAMIC;
        bodyDef.angle = angle;
        bodyDef.position.set(x/Constant.RATE + r,y/Constant.RATE + r);
        Body body=world.createBody(bodyDef);
        body.createFixture(fDef);
        return new TriangleBody(body,r,color);
    }


    /**
     * 创建小球
     * @param x 小球横坐标（左上）
     * @param y 小球纵坐标（左上）
     * @param world 所属虚拟世界
     * @param color 物体颜色
     * @return
     */
    public static Ball createBall(float x, float y, World world, Color color){
        CircleShape ballShape = new CircleShape();

        float r = Constant.BALL_UNIT_SIZE / 2.0f / Constant.RATE;
        ballShape.setRadius(r);
        //配置物体属性参数
        FixtureDef fDef=new FixtureDef();
        fDef.density=1;
        //摩擦因子
        fDef.friction=1.0f;
        //恢复系数
        fDef.restitution=1.0f;
        fDef.shape = ballShape;

        //创建刚体
        BodyDef bodyDef=new BodyDef();
        bodyDef.type = BodyType.DYNAMIC;
        bodyDef.position.set(x / Constant.RATE + r ,y / Constant.RATE + r);
        Body body=world.createBody(bodyDef);
        body.createFixture(fDef);
        return new Ball(body,r,color);
    }

    /**
     * 创建等腰梯形
     * @param x 物体横坐标
     * @param y 物体中坐标
     * @param size 直角边长
     * @param isStatic 是否固定
     * @param world 所属虚拟世界
     * @param color 物体颜色
     * @return
     */
    public static TrapezoidBody createTrapezoidBody(float x, float y, float size,float angle, boolean isStatic, World world, Color color){
        PolygonShape trapezoidBody = new PolygonShape();

        float r = size / 2.0f / Constant.RATE;
        trapezoidBody.set(new Vec2[]{new Vec2(-r, r), new Vec2(-r/2.0f, -r), new Vec2(r/2.0f, -r), new Vec2(r, r)},4);
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
        fDef.restitution=1.0f;
        fDef.shape = trapezoidBody;

        //创建刚体
        BodyDef bodyDef=new BodyDef();
        bodyDef.type=isStatic? BodyType.STATIC:BodyType.DYNAMIC;
        bodyDef.position.set(x/Constant.RATE+r,y/Constant.RATE+r);
        bodyDef.angle = angle;
        Body body=world.createBody(bodyDef);
        body.createFixture(fDef);
        return new TrapezoidBody(body,r,color);
    }

    /**
     * 创建世界的边界
     * @param x 边界的宽
     * @param y 边界的高
     * @param world 所属虚拟世界
     */
    public static void createBoarder(float x, float y, World world){
        //自定义形状
        PolygonShape horizontalShape =new PolygonShape();
        PolygonShape verticalShape =new PolygonShape();
        horizontalShape.setAsBox(x/2.0f/Constant.RATE, 0);
        verticalShape.setAsBox(0, y/2.0f/Constant.RATE);
        //配置物体属性参数
        FixtureDef fDef=new FixtureDef();
        //创建刚体
        BodyDef bodyDef=new BodyDef();
        bodyDef.type=BodyType.STATIC;

        fDef.density=0;
        //摩擦因子
        fDef.friction=1.0f;
        //恢复系数
        fDef.restitution=1.0f;

        //Top
        bodyDef.position.set(x/2.0f/Constant.RATE,0);
        fDef.shape=horizontalShape;
        Body body=world.createBody(bodyDef);
        body.createFixture(fDef);
        //Bottom
        bodyDef.position.set(x/2.0f/Constant.RATE,y/Constant.RATE);
        body=world.createBody(bodyDef);
        body.createFixture(fDef);
        //Left
        bodyDef.position.set(0,y/2.0f/Constant.RATE);
        fDef.shape=verticalShape;
        body=world.createBody(bodyDef);
        body.createFixture(fDef);
        //Right
        bodyDef.position.set(x/Constant.RATE,y/2.0f/Constant.RATE);
        body=world.createBody(bodyDef);
        body.createFixture(fDef);

    }


}
