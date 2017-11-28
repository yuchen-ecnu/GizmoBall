package entity;

/**
 * 虚拟世界绑定数据
 *
 * @author Jack Chen
 * @create 2017-11-28 13:31
 */
public class BodyData {
    private long id;
    private int type;

    public BodyData() {
    }

    public BodyData(long id, int type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
