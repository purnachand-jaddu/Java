package com.mentor.training;

import java.io.File;
import java.io.PrintWriter;

public class WriteFile {
    WriteFile()
    {
        try {
            File file = new File("C:\\Users\\pjaddu\\Desktop\\First.txt");
            PrintWriter newWriter = new PrintWriter(file);
            newWriter.println("First text");
            newWriter.println("Second text");
            newWriter.println("Third text");
            newWriter.print(true);
            newWriter.close();
        }
        catch(Exception exception){

        }
        System.out.println("Hello");
    }
}
