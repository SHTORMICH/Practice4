package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    private static final Logger logger = Logger.getLogger(Part6.class.getName());

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        text.append(readerFile("part6.txt"));
        Scanner scannerFromConsole = new Scanner(System.in);
        String input = scannerFromConsole.nextLine();
        while (!input.equalsIgnoreCase("stop")) {
            System.out.println(sorted(input, text.toString()));
            input = scannerFromConsole.nextLine();
        }
    }

    public static String sorted (String input, String text) {
        String[] lines = text.split(System.lineSeparator());
        StringBuilder resultCyrillic = new StringBuilder();
        resultCyrillic.append("Cyrl: ");
        StringBuilder resultLatin = new StringBuilder();
        resultLatin.append("Latn: ");
        for (String line : lines) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (isCyrillic(word)) {
                    resultCyrillic.append(word).append(" ");
                } else if (!isCyrillic(word)) {
                    resultLatin.append(word).append(" ");
                }
            }
        }
        if (input.equalsIgnoreCase("cyrl")) {
            return resultCyrillic.toString().replaceAll("\\.", "");
        } else if (input.equalsIgnoreCase("latn")) {
            return resultLatin.toString().replaceAll("\\.", "");
        } else {
            return input + ": Incorrect input";
        }
    }

    public static boolean isCyrillic(String word) {
        Pattern p = Pattern.compile("\\p{IsCyrillic}");
        Matcher m = p.matcher(word);
        return m.find();
    }

    public static String readerFile(String path) {
        File file = new File(path);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
        return builder.toString();
    }

}
/*
.replaceAll("(?m)^\\s*$[\\n\\r]+", "")
try (Scanner scannerFromTxt = new Scanner(new FileInputStream("part6.txt"), "Cp1251")) {
            while (scannerFromTxt.hasNext()) {
                text.append(scannerFromTxt.nextLine()).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        StringBuilder result = new StringBuilder();
        Pattern p;
        if (input.equalsIgnoreCase("cyrl")){
            p = Pattern.compile(REGEX_CYRIL);
        } else if (input.equalsIgnoreCase("latn")) {
            p = Pattern.compile(REGEX_LATIN);
        } else {
            return input + "Incorrect input";
        }
        Matcher m = p.matcher(text);
        while (m.find()) {
            result.append(m.group()).append(" ");
        }
        result.append("\n");
        return result.toString();

        while (!input.equalsIgnoreCase("stop")) {
            System.out.println(sorted(input, text.toString()));
            input = scannerFromConsole.nextLine();
        }

        public static String sorted (String input, String text) {
        StringBuilder result = new StringBuilder();
        Pattern p;
        if (input.equalsIgnoreCase("cyrl")){
            p = Pattern.compile(REGEX_CYRIL);
        } else if (input.equalsIgnoreCase("latn")) {
            p = Pattern.compile(REGEX_LATIN);
        } else {
            return input + "Incorrect input";
        }
        Matcher m = p.matcher(text);
        while (m.find()) {
            result.append(m.group()).append(" ");
        }
        result.append("\n");
        return result.toString();
    }
        */