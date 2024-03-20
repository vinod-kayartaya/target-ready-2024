package com.targetindia.utils;

import com.targetindia.entity.Product;

public final class Printer {
    public static void print(Object obj, String fieldToExclude) {
        if (obj == null) {
            return;
        }
        try {
            System.out.println("data in the give object of type " + obj.getClass().getName());
            for (var f : obj.getClass().getDeclaredFields()) {
                if (f.getName().equals(fieldToExclude)) {
                    continue;
                }
                f.setAccessible(true);
                System.out.printf("%-20s: %s\n", f.getName(), f.get(obj));
                f.setAccessible(false);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
