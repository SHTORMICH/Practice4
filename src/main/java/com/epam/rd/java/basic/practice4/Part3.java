package com.epam.rd.java.basic.practice4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static final String REGEX_CHAR = "[\\p{IsCyrillic}|\\p{IsLatin}]+";
    public static final String REGEX_INT = "[0-9]+";
    public static final String REGEX_DOUBLE = "(\\d+\\.\\d+)|(\\.\\d+)++";
    public static final String REGEX_STRING = "[\\p{IsCyrillic}|\\p{IsLatin}]{2,}";

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (Scanner scannerFromTxt = new Scanner(new FileInputStream("part3.txt"), "UTF-8")) {
            while (scannerFromTxt.hasNext()) {
                text.append(scannerFromTxt.nextLine()).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Write your word:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputValues = input.split(System.lineSeparator());
        for (String el : inputValues) {
            while (!el.equalsIgnoreCase("stop")) {
                if (el.equalsIgnoreCase("char")) {
                    System.out.println(findCharInText(text.toString(), REGEX_CHAR));
                    break;
                } else if (el.equalsIgnoreCase("int")) {
                    System.out.println(findIntInText(text.toString(), REGEX_INT));
                    break;
                } else if (el.equalsIgnoreCase("double")) {
                    System.out.println(findValueInText(text.toString(), REGEX_DOUBLE));
                    break;
                } else if (el.equalsIgnoreCase("String")) {
                    System.out.println(findValueInText(text.toString(), REGEX_STRING));
                    break;
                } else {
                    System.out.println("Incorrect input");
                    break;
                }
            }
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
}
