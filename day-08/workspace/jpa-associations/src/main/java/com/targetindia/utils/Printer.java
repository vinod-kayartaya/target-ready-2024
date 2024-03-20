package com.targetindia.utils;

import com.targetindia.entity.Product;

public final class Printer {
    public static void print(Object obj, String ...fieldsToExclude) {
        if (obj == null) {
            return;
        }
        try {
            System.out.println("data in the give object of type " + obj.getClass().getName());
            outer_loop:
            for (var f : obj.getClass().getDeclaredFields()) {
                for(var fieldToExclude: fieldsToExclude){
                    if (f.getName().equals(fieldToExclude)) {
                        continue outer_loop;
                    }
                }
                f.setAccessible(true);
                System.out.printf("%-20s: %s\n", f.getName(), f.get(obj));
                f.setAccessible(false);
            }
            System.out.println();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
