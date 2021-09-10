package com.mentor.training;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void readGivenFile() throws IOException {
        BufferedReader reader=null;
        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\pjaddu\\Desktop\\First.txt"));
            String line;
            while((line=reader.readLine())!=null)
            {
                System.out.println(line);
            }
        }
        catch(Exception exception){

        }
        finally {
            reader.close();
        }
    }
}
