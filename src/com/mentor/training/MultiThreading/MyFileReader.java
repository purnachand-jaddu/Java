package com.mentor.training.multithreading;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader extends FileReader
{
    public MyFileReader(String fileName) throws FileNotFoundException
    {
        super(fileName);
    }

    public void readAndPrint() throws IOException
    {
        int read = read();
        while(read!=-1)
        {
            System.out.println((char)read);
            read=read();
        }
    }
}
