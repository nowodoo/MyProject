package com.zach;

/**
 * Created by zach on 17/8/13.
 */
public class Point {
    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object object) {

        Point other = ((Point) object);
        if (object instanceof Point) {
            if (other.getX() == this.x && other.getY() == this.y) {
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
