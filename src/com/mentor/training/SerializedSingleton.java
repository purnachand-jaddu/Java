package com.mentor.training;

import java.io.Serializable;

public class SerializedSingleton implements Serializable {

    private SerializedSingleton()
    {

    }

    private static class SerializedSingletonHelper
    {
        private static SerializedSingleton instance=new SerializedSingleton();
    }

    public static SerializedSingleton getInstance()
    {
        return SerializedSingletonHelper.instance;
    }
}
