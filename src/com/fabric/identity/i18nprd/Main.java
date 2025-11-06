package com.test.i18nprd;

import net.openhft.hashing.LongHashFunction;

public class Main {

    public static void main(String[] args) {
        String text = "tenantId65305c000cf2e732c4d4ef0apropertycountrymediumwebregion";
        System.out.println(String.valueOf(LongHashFunction.xx3().hashChars(text)));
    }
}
