package com.mentor.training.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence(
                Arrays.asList(697, 953, 900, 438, 899, 593, 591, 963, 31, 160, 894, 493, 782, 445, 326, 452, 988, 657, 7, 544, 768, 398, 791, 650, 818, 12, 347, 928, 828, 336, 692, 339, 130, 837, 548, 487, 989, 333, 875, 711, 957, 341, 821, 319, 338, 328, 234, 7, 670, 328, 451, 200, 685, 699, 855, 668, 609, 322, 752, 386, 81, 635, 952, 618, 133, 73, 548, 163, 221, 105, 773, 398, 639, 579, 660, 746, 718, 918, 224, 984, 265, 242, 506, 762, 734, 98, 324, 100, 896, 346, 344, 27, 420, 353, 532, 105, 914, 130, 695),
                Arrays.asList(438, 591, 768, 160, 777, 894, 782, 398, 445, 306, 326, 282, 452, 607, 241, 513, 185, 7, 544, 12, 347, 828, 336, 83, 924, 143, 692, 339, 130, 515, 837, 466, 989, 875, 711, 957, 338, 266, 305, 480, 328, 28, 7, 670, 328, 699, 849, 668, 609, 979, 100, 322, 283, 386, 655, 263, 826, 169, 635, 952, 618, 73, 238, 897, 221, 863, 34, 372, 732, 398, 579, 666, 545, 660, 794, 746, 526, 718, 918, 403, 615, 946, 224, 822, 242, 506, 734, 324, 100, 55, 346, 704, 24, 650, 678, 532, 914, 130, 423, 998)
        ));
    }

    public static List<Integer> longestCommonSubsequence(List<Integer> a, List<Integer> b) {
        int x = a.size() + 1;
        int y = b.size() + 1;
        List[][] output = new ArrayList[x][y];
        for (int i = 0; i < x; i++) {
            output[i][0] = new ArrayList<Integer>();
        }
        for (int i = 0; i < y; i++) {
            output[0][i] = new ArrayList<Integer>();
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (a.get(i - 1).equals(b.get(j - 1))) {
                    output[i][j] = new ArrayList<>(output[i - 1][j - 1]);
                    output[i][j].add(a.get(i - 1));
                }
                if (output[i][j] == null || output[i][j].size() < output[i - 1][j].size()) {
                    output[i][j] = new ArrayList<>(output[i - 1][j]);
                }
                if (output[i][j] == null || output[i][j].size() < output[i][j - 1].size()) {
                    output[i][j] = new ArrayList<>(output[i][j - 1]);
                }

            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.println(output[i][j].size());
                System.out.println(" ");
            }
            System.out.println("\n");
        }
        return output[x - 1][y - 1];

    }
}
