package entity;

import java.awt.*;
import java.io.Serializable;

public class SerializableObject  implements Serializable {
    private int type;
    private float x;
    private float y;
    private float size;
    private Color color;
    private float direction;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getDirection() {
        return direction;
    }

    public void setDirection(float direction) {
        this.direction = direction;
    }
}
