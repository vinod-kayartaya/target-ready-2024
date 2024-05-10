package com.targetindia.programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {
    public static void main(String[] args) {

        try (
                FileReader reader = new FileReader("pom.xml");
                BufferedReader in = new BufferedReader(reader);
        ) {
            var loopCount = 0;
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                loopCount++;
            }
            System.out.println("It took " + loopCount + " iterations.");
        } // reader.close() and in.close() are automatically called here
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main1(String[] args) {
        FileReader reader = null;

        try {
            reader = new FileReader("pom.xml");
            int ch;
            StringBuffer content = new StringBuffer(1024);
            var loopCount = 0;
            while ((ch = reader.read()) != -1) {
                content.append((char) ch);
                loopCount++;
            }

            System.out.println(content);
            System.out.println("It took " + loopCount + " iterations.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
