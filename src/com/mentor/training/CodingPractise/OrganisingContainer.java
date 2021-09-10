package com.mentor.training.CodingPractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
public class OrganisingContainer
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int iterator = scanner.nextInt();
        while(iterator-- > 0)
        {
            int q = scanner.nextInt();
            long containerToTypes[][] = new long[q][q];
            for (int i = 0; i < q; i++)
            {
                for (int j = 0; j < q; j++)
                {
                    containerToTypes[i][j] = scanner.nextLong();
                }
            }

            List<Long> rows = new ArrayList<>();
            List<Long> columns = new ArrayList<>();
            for (int i = 0; i < q; i++)
            {
                long sum = 0;
                for (int j = 0; j < q; j++)
                {
                    sum += containerToTypes[i][j];
                }
                rows.add(sum);
            }
            for (int j = 0; j < q; j++)
            {
                long sum = 0;
                for (int i = 0; i < q; i++)
                {
                    sum += containerToTypes[i][j];
                }
                columns.add(sum);
            }
            Object[] rowsArray = rows.toArray();
            Object[] columnsArray = columns.toArray();
            Arrays.sort(rowsArray);
            Arrays.sort(columnsArray);

            boolean isPossible = true;
            for (int i = 0; i < q; i++)
            {
                if (!((long) columnsArray[i] <= (long) rowsArray[i]))
                {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible)
            {
                System.out.println("Possible");
            }
            else
            {
                System.out.println("Impossible");
            }
        }
    }
}
