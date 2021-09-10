package com.mentor.training.csv;


import java.io.*;
import java.util.*;

public class MainClass {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\pjaddu\\Desktop\\Delet");
        executeForDirectory(file);
    }

    private static void executeForDirectory(File parentFile) {
        for (File childFile : Objects.requireNonNull(parentFile.listFiles())) {
            if (childFile.isDirectory()) {
                executeForDirectory(childFile);
            } else {
                if (childFile.getName().contains(".csv")) {
                    try (FileReader fileReader = new FileReader(childFile)) {
                        Map<String, StringBuilder> newCSVFile = createNewCSVFile(fileReader, childFile.getAbsolutePath());
                        for (Map.Entry<String, StringBuilder> entry : newCSVFile.entrySet()) {
                            FileOutputStream stream = new FileOutputStream(entry.getKey());
                            stream.write(entry.getValue().toString().getBytes());
                            stream.flush();
                            stream.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static Map<String, StringBuilder> createNewCSVFile(FileReader reader, String fileName) throws IOException {
        Map<String, StringBuilder> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            boolean eligibleFile = isEligibleFile(bufferedReader.readLine());
            if (eligibleFile) {
                sb.append(getNewHeader());
                String currentLine = bufferedReader.readLine();
                while (currentLine != null) {
                    sb.append("\n");
                    sb.append(getNewString(currentLine));
                    currentLine = bufferedReader.readLine();
                }
                map.put(fileName, sb);
            }
        } catch (Exception exception) {
            System.out.println(fileName);
        }
        return map;
    }

    private static String getNewString(String oldLine) {
        List<String> oldValues = getOldValues(oldLine);
        assert oldValues.size() == 4 || oldValues.size() == 3;
        String[] newValues = getNewString(oldValues);
        return String.join(",", newValues);
    }

    private static List<String> getOldValues(String oldLine) {
        String[] split = oldLine.split("\"");
        List<String> strings = new ArrayList<>();
        for (String s : split) {
            if (s.equals(",") || s.equals("")) {
                continue;
            }
            strings.add(s);
        }
        return strings;
    }

    private static String[] getNewString(List<String> oldValues) {
        String[] newValues = new String[5];
        int startingPoint = 0;
        if (oldValues.size() == 4) {
            newValues[0] = "\"YES\"";
            startingPoint = 1;
        } else if (oldValues.size() == 3) {
            newValues[0] = "\"\"";
            startingPoint = 0;
        }
        newValues[1] = "\"NO\"";
        newValues[2] = getCoatedString(oldValues.get(startingPoint++));
        newValues[3] = getCoatedString(oldValues.get(startingPoint++));
        newValues[4] = getCoatedString(oldValues.get(startingPoint));
        return newValues;
    }

    private static String getCoatedString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        sb.append(s);
        sb.append("\"");
        return sb.toString();
    }

    private static boolean isEligibleFile(String firstLine) {
        if (firstLine == null) {
            return false;
        }
        return firstLine.equals("\"Is Root ?\",\"Object Type\",\"Delta Type\",\"Description\"");
    }

    private static String getNewHeader() {
        return "\"Header\",\"Complete\",\"Object\",\"Delta\",\"Description\"";
    }
}
