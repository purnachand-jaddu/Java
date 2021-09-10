package com.mentor.training;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApplication {
    public static void callStream()
    {
        StreamObject first= new StreamObject() {
            @Override
            public int getApplicability() {
                return 2;
            }

            @Override
            public int getSubject() {
                return 1;
            }

            @Override
            public String getName() {
                return "rule1";
            }
        };
        StreamObject second=new StreamObject() {
            @Override
            public int getApplicability() {
                return 3;
            }

            @Override
            public int getSubject() {
                return 1;
            }

            @Override
            public String getName() {
                return "rule2";
            }
        };
        StreamObject third=new StreamObject() {
            @Override
            public int getApplicability() {
                return 2;
            }

            @Override
            public int getSubject() {
                return 1;
            }

            @Override
            public String getName() {
                return "rule3";
            }
        };
        Set<StreamObject> newSet = new HashSet<>();
        newSet.add(first);
        newSet.add(second);
        newSet.add(third);

        Map<Integer, List<StreamObject>> myMap = newSet.stream().filter(obj -> obj.getSubject() == 1).collect(Collectors.groupingBy(obj -> {
            return obj.getApplicability();
        }));
        for(Map.Entry<Integer,List<StreamObject>> entry:myMap.entrySet())
        {
            int key=entry.getKey();
            List <StreamObject> value=entry.getValue();
            System.out.print(key);
            System.out.print("  -------------------  ");
            for(StreamObject newObj:value)
            {
                System.out.print(newObj.getName());
            }
        }
    }
}
