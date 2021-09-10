package com.mentor.training;

import java.util.function.Function;

public class TestFunction {

    private int variable;
    private String string;
    public TestFunction(int variable,String string)
    {
        this.variable=variable;
        this.string=string;
    }

    public String testFunction(Function<TestFunction,String> fun)
    {
        return fun.apply(this);
    }
}
