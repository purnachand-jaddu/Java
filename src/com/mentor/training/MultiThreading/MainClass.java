package com.mentor.training.MultiThreading;

import java.io.IOException;

public class MainClass
{
    public static void main(String[] args) throws IOException
    {
        MyFileWriter writer = new MyFileWriter("/Users/pjaddu/Desktop/java_training/temp.txt");
        MyFileReader reader = new MyFileReader("/Users/pjaddu/Desktop/java_training/temp.txt");

        Runnable writeRunnable = createWriteRunnable(writer);
        Runnable readRunnable = createReadRunnable(reader);
        Thread t1 = new Thread(writeRunnable);
        Thread t2 = new Thread(readRunnable);

        t1.start();
        t2.start();

    }

    private static Runnable createReadRunnable(MyFileReader reader)
    {
        return () -> {
            try
            {
                reader.readAndPrint();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        };
    }

    private static Runnable createWriteRunnable(MyFileWriter writer)
    {
        return () -> {
            try
            {
                writer.writeALargeTextToFile();
            }
            catch (IOException  e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    writer.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        };
    }
}
