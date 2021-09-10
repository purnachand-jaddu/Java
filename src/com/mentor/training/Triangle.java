package com.mentor.training;

public class Triangle implements Polygon {

    private int height;
    private int width;

    public void setValues(int height,int width)
    {
        this.height=height;
        this.width=width;
    }

    public int getArea()
    {
        return (height*width)/2;
    }
}
