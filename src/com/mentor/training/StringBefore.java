package com.mentor.training;
public class StringBefore {
    public static String substringBefore(String string, String end)
    {
        return substringBefore(string, end, 0);
    }

    public static String substringBefore(String string, String end, int searchPos)
    {
        int index = string.indexOf(end, searchPos);
        if (index < 1) {
            return null;
        }
        return string.substring(0, index);
    }
    public static String substringAfter(String string, String beginning)
    {
        return substringAfter(string, beginning, 0);
    }

    public static String substringAfter(String string, String beginning, int searchPos)
    {
        int index = string.indexOf(beginning, searchPos);
        if (index < 0 || index + beginning.length() >= string.length()) {
            return null;
        }
        return string.substring(index + beginning.length(), string.length());
    }

}
