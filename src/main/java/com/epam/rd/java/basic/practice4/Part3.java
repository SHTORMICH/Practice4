package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    //[\p{IsCyrillic}|\p{IsLatin}]+
    //[\p{IsCyrillic}|\p{IsLatin}]{2,}
    public static final String REGEX_CHAR = "(^|\\s)([\\p{Alpha}\\p{IsCyrillic}]{1})(?=\\s|\\n$)";
    public static final String REGEX_INT = "(?<![.\\d])\\d+(?![.\\d])";
    public static final String REGEX_DOUBLE = "-?\\d*\\.\\d+";
    public static final String REGEX_STRING = "(^|\\s)([a-zA-Z\\p{IsCyrillic}]{2,})(?=\\s|\\n$)";
    private static final Logger logger = Logger.getLogger(Part3.class.getName());

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        text.append(readerFil("part3.txt"));
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("stop")) {
            if (input.equalsIgnoreCase("char")) {
                System.out.println(findInText(text.toString(), REGEX_CHAR).trim());
            } else if (input.equalsIgnoreCase("int")) {
                System.out.println(findInText(text.toString(), REGEX_INT));
            } else if (input.equalsIgnoreCase("double")) {
                System.out.println(findInText(text.toString(), REGEX_DOUBLE));
            } else if (input.equalsIgnoreCase("String")) {
                System.out.println(findInText(text.toString(), REGEX_STRING).trim());
            } else {
                System.out.println("Incorrect input");
            }
            input = scanner.nextLine();
        }
    }

    public static String findInText(String text, String regex) {
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            result.append(m.group()).append(" ");
        }
        return result.toString().trim();
    }

    public static String readerFil(String path) {
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
    /*public static String findValueInText(String text, String input) {
        StringBuilder resultWords = new StringBuilder();
        StringBuilder resultChars = new StringBuilder();
        String[] lines = text.split(System.lineSeparator());
        for (String line : lines) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (IsCyrillic(word) && word.length() >= 4) {
                    resultWords.append(word).append(" ");
                } else if (!IsCyrillic(word) && word.length() >= 2) {
                    resultWords.append(word).append(" ");
                }
                if (IsCyrillic(word) && word.length() == 2) {
                    resultChars.append(word).append(" ");
                } else if (!IsCyrillic(word) && word.length() == 1) {
                    resultWords.append(word).append(" ");
                }
            }
            resultWords.append(System.lineSeparator());
            resultChars.append(System.lineSeparator());
        }
        if (input.equalsIgnoreCase("String")) {
            return resultWords.toString().replaceAll("(?m)^\\s*$[\\n\\r]+", "");
        }
        return resultChars.toString().replaceAll("(?m)^\\s*$[\\n\\r]+", "");
    }

    public static boolean IsCyrillic(String word) {
        Pattern p = Pattern.compile("\\p{IsCyrillic}");
        Matcher m = p.matcher(word);
        return m.find();
    }*/