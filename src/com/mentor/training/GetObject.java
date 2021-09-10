package com.mentor.training;

public class GetObject {

    private GetObject(){}

    public static GetObject getObject(){
        GetObject object=new GetObject();
        return object;
    }

    public int multiply(int a,int b){
        return a*b;
    }
}
