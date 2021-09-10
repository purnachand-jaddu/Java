package com.mentor.training;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class SherlockAndAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        Map<State,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            int[] currentState = new int[26];
            for(int k=0;k<26;k++)
            {
                currentState[k]=0;
            }
            for(int j=i;j<s.length();j++)
            {
                currentState[s.charAt(j)-'a']++;
                State state = new State(currentState);
                if(!map.containsKey(state))
                {
                    map.put(state,1);
                }
                else
                {
                    int v = map.get(state);
                    map.put(state,v+1);
                }
            }
        }
        System.out.println(map.size());
        int sum = 0;
        for(State state : map.keySet())
        {
            int v = map.get(state);
            if(v>=2)
            {
                sum+= v*(v-1)/2;
            }
        }
        return sum;
    }

    static class State
    {
        private int[] value;
        public State(int[] value)
        {
            this.value = value;
        }

        public boolean equals(Object o)
        {
            return hashCode()==o.hashCode();
        }

        public int hashCode()
        {
            return Objects.hash(value);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(sherlockAndAnagrams("abba"));
    }
}
