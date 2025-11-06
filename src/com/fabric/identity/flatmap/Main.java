package com.test.flatmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

//Fibinocci series
//Find if there is any match in the list
//Given a list transform it into another list where each value is 2x, x^2
//Function, Consumer, Supplier, Runnable interfaces
//Lambda expressions
//Streams - When to use Parallel
//Flat map
//Is it better to pass Stream as an argument or List as an argument
public class Main {

    public static void main(String[] args) {
        Map<String, List<Integer>> m = new HashMap<>();
        m.put("P1", List.of(1,2,4));
        m.put("P2", List.of(5,7,8,4));

        Set<Integer> collect = m.entrySet().stream().flatMap(entry -> entry.getValue().stream()).collect(Collectors.toSet());
        System.out.println(collect);

        Optional<Integer> first = collect.stream().filter(v -> v == 2).findFirst();
        System.out.println(first.get());
    }
}
