package com.mentor.training.oracle;

public class Deadlock
{
	static int firstThreadCounter = 0;
	static int secondThreadCounter = 0;

	public static void main(String[] args)
	{
		Thread th1 = new Thread(() -> {
			while(secondThreadCounter!=1)
			{

			}
			firstThreadCounter++;
		});
		Thread  th2 = new Thread(() ->{
			while(firstThreadCounter!=1)
			{

			}
			secondThreadCounter++;
		});
		th1.start();
		th2.start();
	}
}
