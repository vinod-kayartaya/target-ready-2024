package com.targetindia.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInputDemo {

    public static void main(String[] args)  throws Exception{
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        System.out.print("Enter your name: ");
        String name = in.readLine();
        System.out.print("Enter your age: ");
        int age = Integer.parseInt(in.readLine());

        System.out.printf("%s is %d years old\n", name, age);
    }
    public static void userInputDemo2(String[] args) throws Exception{

        byte[] bytes = new byte[25];
        // System.out.println(Arrays.toString(bytes));
        System.out.print("Enter your name: ");
        System.in.read(bytes);
        // System.out.println(Arrays.toString(bytes));
        String name = new String(bytes).trim();
        System.out.println("Hello, \"" + name + "\"");

    }
    public static void userInputDemo1(String[] args) throws Exception {

        // System.out.println("System.in refers to an object of type: " + System.in.getClass().getName());
        System.out.print("Enter your name: ");
        int ch;
        StringBuffer nameBuff = new StringBuffer(125);
        while ((ch = System.in.read()) != '\n') {
            nameBuff.append((char)ch);
        }
        String name = nameBuff.toString();

        System.out.println("Hello, \"" + name + "\"");

    }
}
