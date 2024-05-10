package com.targetindia.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSortDemo {
    /*
    static class StringReverseComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s2.compareTo(s1);
        }
    }
     */

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Ajay", "Shyam", "Harish", "Nagesh", "Rajesh"));

        System.out.println(names);
        Collections.sort(names);
        System.out.println(names);

        // StringReverseComparator src = new StringReverseComparator();
        /*
        Comparator<String> src = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        };
        */

        /*
        Comparator<String> src = (String s1, String s2) -> {
            return s2.compareTo(s1);
        };
        */

        /*
        Comparator<String> src = (s1, s2) -> {
            return s2.compareTo(s1);
        };
        */

        // Comparator<String> src = (s1, s2) -> s2.compareTo(s1);
        // System.out.println(src.getClass().getName());

        Collections.sort(names, (s1, s2) -> s2.compareTo(s1));
        System.out.println(names);
    }
}
