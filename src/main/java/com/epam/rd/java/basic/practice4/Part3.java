package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    public static final String REGEX_CHAR = "[\\p{IsCyrillic}|\\p{IsLatin}]+";
    public static final String REGEX_INT = "(?<![.\\d])\\d+(?![.\\d])";
    public static final String REGEX_DOUBLE = "-?\\d*\\.\\d+";
    public static final String REGEX_STRING = "[\\p{IsCyrillic}|\\p{IsLatin}]{2,}";

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        text.append(reader("part3.txt"));

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("stop")) {
            if (input.equalsIgnoreCase("char")) {
                System.out.println(findCharInText(text.toString(), REGEX_CHAR).trim());
            } else if (input.equalsIgnoreCase("int")) {
                System.out.println(findIntInText(text.toString(), REGEX_INT));
            } else if (input.equalsIgnoreCase("double")) {
                System.out.println(findValueInText(text.toString(), REGEX_DOUBLE));
            } else if (input.equalsIgnoreCase("String")) {
                System.out.println(findValueInText(text.toString(), REGEX_STRING).trim());
            } else {
                System.out.println("Incorrect input");
            }
            input = scanner.nextLine();
        }
    }

    public static String findCharInText(String text, String regex) {
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            if (m.group().length() == 1) {
                result.append(m.group()).append(" ");
            }
        }
        return result.toString().trim();
    }

    public static String findIntInText(String text, String regex) {
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            if (!m.group().contains(".")) {
                result.append(m.group()).append(" ");
            }
        }
        return result.toString().trim();
    }

    public static String findValueInText(String text, String regex) {
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            result.append(m.group()).append(" ");
        }
        return result.toString().trim();
    }

    public static String reader(String path) {
        File file = new File(path);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return builder.toString();
    }
}
