package com.mentor.training.CodingPractise;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/queens-attack-2/problem
public class QueensAttackII
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        long queenXPos = scanner.nextLong();
        long queenYPos = scanner.nextLong();
        long plusPlus = Long.min(n - queenXPos, n - queenYPos);
        long minusMinus = Long.min(queenXPos - 1, queenYPos - 1);
        long plusZero = n - queenXPos;
        long minusZero = queenXPos - 1;
        long zeroPlus = n - queenYPos;
        long zeroMinus = queenYPos - 1;
        long plusMinus = Long.min(n - queenXPos, queenYPos - 1);
        long minusPlus = Long.min(queenXPos - 1, n - queenYPos);

        long plusPlusObstacleMin = Long.MAX_VALUE;
        long minusMinusObstacleMin = Long.MAX_VALUE;
        long zeroPlusObstacleMin = Long.MAX_VALUE;
        long zeroMinusObstacleMin = Long.MAX_VALUE;
        long plusZeroObstacleMin = Long.MAX_VALUE;
        long minusZeroObstacleMin = Long.MAX_VALUE;
        long plusMinusObstacleMin = Long.MAX_VALUE;
        long minusPlusObstacleMin = Long.MAX_VALUE;
        for (int i = 0; i < k; i++)
        {
            long obsXPos = scanner.nextLong();
            long obsYPos = scanner.nextLong();
            long absXPos = obsXPos - queenXPos;
            long absYPos = obsYPos - queenYPos;
            if (absXPos == absYPos)
            {
                if (absXPos > 0)
                {
                    if (absXPos < plusPlusObstacleMin)
                    {
                        plusPlusObstacleMin = absXPos;
                    }
                }
                else
                {
                    absXPos *= -1;
                    if (absXPos < minusMinusObstacleMin)
                    {
                        minusMinusObstacleMin = absXPos;
                    }
                }
            }
            else if (absXPos == 0)
            {
                if (absYPos > 0)
                {
                    if (absYPos < zeroPlusObstacleMin)
                    {
                        zeroPlusObstacleMin = absYPos;
                    }
                }
                else
                {
                    absYPos *= -1;
                    if (absYPos < zeroMinusObstacleMin)
                    {
                        zeroMinusObstacleMin = absYPos;
                    }
                }
            }
            else if (absYPos == 0)
            {
                if (absXPos > 0 && absXPos < plusZeroObstacleMin)
                {
                    plusZeroObstacleMin = absXPos;
                }
                else if (absXPos < 0 && -1 * absXPos < minusZeroObstacleMin)
                {
                    minusZeroObstacleMin = -1 * absXPos;
                }
            }
            else if (absXPos == -1 * absYPos)
            {
                if (absXPos < 0)
                {
                    if (absYPos < minusPlusObstacleMin)
                    {
                        minusPlusObstacleMin = absYPos;
                    }
                }
                else
                {
                    if (absXPos < plusMinusObstacleMin)
                    {
                        plusMinusObstacleMin = absXPos;
                    }
                }
            }
        }
        long totalSquares = myAbsoluteValue(plusPlus, plusPlusObstacleMin) +
                myAbsoluteValue(minusMinus, minusMinusObstacleMin) +
                myAbsoluteValue(plusZero, plusZeroObstacleMin) +
                myAbsoluteValue(minusZero, minusZeroObstacleMin) +
                myAbsoluteValue(zeroPlus, zeroPlusObstacleMin) +
                myAbsoluteValue(zeroMinus, zeroMinusObstacleMin) +
                myAbsoluteValue(plusMinus, plusMinusObstacleMin) +
                myAbsoluteValue(minusPlus, minusPlusObstacleMin);

        System.out.println(totalSquares);

    }

    private static long myAbsoluteValue(long a, long b)
    {
        if (b == 1)
        {
            return 0;
        }
        else if (a > b)
        {
            return a - b;
        }
        else if (b == Long.MAX_VALUE)
        {
            return a;
        }
        return 0;

    }
}
