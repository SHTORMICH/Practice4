package com.epam.rd.java.basic.practice4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Util {
    private static final String ENCODING = "Cp1251";
    private static final Logger LOGGER = Logger.getLogger(Util.class.getName());

    public static String readFile(String path) {
        String res = null;

        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, ENCODING);
        } catch (IOException ex) {
            LOGGER.warning(ex.getMessage());
        }

        return res;
    }
}
