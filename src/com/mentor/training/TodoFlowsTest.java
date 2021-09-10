package com.mentor.training;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class TodoFlowsTest {

    public static void main(String[] args) {
        String fileName = "C:\\Users\\pjaddu\\Desktop\\TodoFLows.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            Set<String> visited = new HashSet<>();
            while (true) {
                String s = reader.readLine();
                if (s == null) {
                    break;
                }
                if (visited.contains(s)) {
                    continue;
                }
                int index = s.indexOf(':');
                if (index == -1) {
                    index = s.length();
                }
                String subString = s.substring(0, index);
                if (visited.contains(subString)) {
                    continue;
                }
                visited.add(subString);
                sb.append(subString);
                sb.append("\n");
            }
            String filtered = sb.toString();
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(filtered);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
