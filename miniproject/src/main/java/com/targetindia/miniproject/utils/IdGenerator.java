package com.targetindia.miniproject.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public final class IdGenerator {
    private IdGenerator() {
    }

    private static int CURRENT_ID = 0;
    private static String FILENAME = "__seed__";

    static {

        try (
                FileInputStream file = new FileInputStream(FILENAME);
                DataInputStream in = new DataInputStream(file);
        ) {
            CURRENT_ID = in.readInt();
        }
        catch (IOException e) {
            log.warn("error while reading the seed file for id generation", e);
        }
    }

    public static int generate() {
        CURRENT_ID++;
        try (
                FileOutputStream file = new FileOutputStream(FILENAME);
                DataOutputStream out = new DataOutputStream(file);
        ) {
            out.writeInt(CURRENT_ID);
        }
        catch (IOException e) {
            log.warn("error while writing the seed file for id generation", e);
        }
        return CURRENT_ID;
    }
}
