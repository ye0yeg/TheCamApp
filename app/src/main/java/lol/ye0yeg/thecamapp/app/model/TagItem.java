package lol.ye0yeg.thecamapp.app.model;

import java.io.Serializable;

/**
 * Created by Administrator on 7/14/2017.
 */
public class TagItem implements Serializable {
    private static final long serialVersionUID = 2685507991821634905L;

    public TagItem() {

    }

    public TagItem(int type, String label) {
        this.type = type;
        this.name = label;
    }


    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(final int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(final double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(final double y) {
        this.y = y;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(final int recordCount) {
        this.recordCount = recordCount;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(final boolean left) {
        this.left = left;
    }

    private long id;
    private int type;
    private String name;
    private double x = -1;
    private double y = -1;
    private int recordCount;
    private boolean left = true;


}
