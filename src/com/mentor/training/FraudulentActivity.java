package com.mentor.training;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FraudulentActivity {

    // Complete the activityNotifications function below.
    private static int activityNotifications(int[] e, int d) {
        int n = e.length;
        if (n <= d) {
            return 0;
        }
        List<Integer> dArray = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            dArray.add(e[i]);
        }
        Collections.sort(dArray);
        int counter = 0;
        for (int i = d; i < n; i++) {
            //System.out.println(e[i] + "  "  + median(dArray,d));
            if (e[i] >= 2 * median(dArray, d)) {
                counter++;
            }
            int index = dArray.indexOf(e[i - d]);
            dArray.set(index, e[i]);
            bubble(dArray, d, index);
        }
        return counter;
    }

    private static void bubble(List<Integer> dArray, int d, int i) {
        // System.out.println(i);
        if (i < d - 1 && dArray.get(i) > dArray.get(i + 1)) {
            swap(dArray, i, i + 1);
            bubble(dArray, d, i + 1);
        } else if (i > 0 && dArray.get(i) < dArray.get(i - 1)) {
            swap(dArray, i, i - 1);
            bubble(dArray, d, i - 1);
        }

    }

    private static void swap(List<Integer> dArray, int x, int y) {
        int temp = dArray.get(x);
        int yVal = dArray.get(y);
        dArray.set(x, yVal);
        dArray.set(y, temp);
    }

    private static double median(List<Integer> dArray, int d) {
        int mid = d / 2;
        if (d % 2 == 1) {
            return (double) dArray.get(mid);
        }
        double leftPart = dArray.get(mid);
        double rightPart = dArray.get(mid - 1);
        return (leftPart + rightPart) / 2;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
