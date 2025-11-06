package com.test.datetime;

import org.joda.time.DateTime;

public class Main {

    public static void main(String[] args) {
        DateTime parse = DateTime.parse("2023-08-12T13:40:50Z");
        System.out.println(parse);
    }
}
