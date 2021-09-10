package com.mentor.training.questions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {


    static int[] maxCircle(int[][] queries) {

        int[] people = new int[1000000001];

        int[] maxCountAfterEachQuery = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int first = queries[i][0];
            int second = queries[i][1];
            if (first == second) {
                continue;
            }
            int countAfterCurrentQuery = 0;
            if (people[first] == 0 && people[second] == 0) {
                people[first] = second;
                people[second] = first;
                countAfterCurrentQuery = 2;
            } else if (people[first] != 0 && people[second] == 0) {
                Set<Integer> visited = new HashSet<>();
                int currentParent = -1;
                while (first != 0) {
                    if (visited.contains(first)) {
                        break;
                    }
                    currentParent = first;
                    visited.add(first);
                    first = people[currentParent];
                    countAfterCurrentQuery++;
                }
                people[currentParent] = second;
                countAfterCurrentQuery++;

            } else if (people[first] == 0 && people[second] != 0) {
                countAfterCurrentQuery = 0;
                Set<Integer> visited = new HashSet<>();
                int currentParent = -1;
                while (second != 0) {
                    if (visited.contains(second)) {
                        break;
                    }
                    currentParent = second;
                    visited.add(first);
                    second = people[currentParent];
                    countAfterCurrentQuery++;
                }
                people[currentParent] = first;
                countAfterCurrentQuery++;
            } else {
                int firstFriendsCount = 0;
                int secondFriendsCount = 0;
                int currentParent = -1;
                Set<Integer> visited = new HashSet<>();
                while (first != 0) {
                    if (visited.contains(first)) {
                        break;
                    }
                    currentParent = first;
                    visited.add(first);
                    first = people[first];
                    firstFriendsCount++;
                }
                visited.clear();
                while (second != 0) {
                    if (visited.contains(second)) {
                        break;
                    }
                    visited.add(second);
                    second = people[second];
                    secondFriendsCount++;

                }
                people[currentParent] = second;
                countAfterCurrentQuery = firstFriendsCount + secondFriendsCount;
            }

            maxCountAfterEachQuery[i] = countAfterCurrentQuery;
        }
        return maxCountAfterEachQuery;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C:\\Users\\pjaddu\\Desktop\\Learnings\\java_training\\Output.txt")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] queries = new int[q][2];

        for (int i = 0; i < q; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        int[] ans = maxCircle(queries);

        for (int i = 0; i < ans.length; i++) {
            bufferedWriter.write(String.valueOf(ans[i]));

            if (i != ans.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    static class Node {
        int value;
        Set<Node> friends;

        Node(int value) {
            this.value = value;
            this.friends = new HashSet<>();
        }

        void addFriend(Node friend) {
            if (this.friends.contains(friend)) {
                return;
            }
            this.friends.add(friend);
            friend.addFriend(this);
        }
    }
}

