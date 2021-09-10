package com.mentor.training;

public class Rectangle implements Polygon{

    private int height,width;
    public void setValues(int height,int width)
    {
        this.height=height;
        this.width=width;
    }

    public int getArea()
    {
        return (height*width);
    }

}
