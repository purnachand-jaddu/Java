package com.mentor.training.MultiThreading;

import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter extends FileWriter
{
    MyFileWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    void writeALargeTextToFile() throws IOException
    {
        for(int i=0;i<102;i++)
        {
            append("lol");
            append("\n");
        }
    }
}
