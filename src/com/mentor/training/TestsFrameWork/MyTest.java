package com.mentor.training.TestsFrameWork;

import junit.framework.Test;
import junit.framework.TestSuite;

public class MyTest
{
    private static TestSuite suite=new TestSuite();

    public static Test suite()
    {
        Test test1 = TestSuite.createTest(MyTestCase.class, "test1");
        Test test2 = TestSuite.createTest(MyTestCase2.class, "test1");
        suite.addTest(test1);
        suite.addTest(test2);
        System.out.println(test1.getClass());
        return suite;
    }

}
