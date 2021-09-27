package com.epam.rd.java.basic.practice4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    private static final String REGEX_CYRIL = "[à-ÿ¸À-ß¨ºª¿¯]+";
    private static final String REGEX_LATIN = "[a-zA-Z]+";

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (Scanner scannerFromTxt = new Scanner(new FileInputStream("part6.txt"), "UTF-8")) {
            while (scannerFromTxt.hasNext()) {
                text.append(scannerFromTxt.nextLine()).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scannerFromConsole = new Scanner(System.in);
        String input = scannerFromConsole.nextLine();
        while (!input.equalsIgnoreCase("stop")) {
            System.out.println(sorted(input, text.toString()));
            input = scannerFromConsole.nextLine();
        }

    }

    public static String sorted (String input, String text) {
        StringBuilder result = new StringBuilder();
        Pattern p;
        if (input.equalsIgnoreCase("cyrl")){
            p = Pattern.compile(REGEX_CYRIL);
        } else if (input.equalsIgnoreCase("latn")) {
            p = Pattern.compile(REGEX_LATIN);
        } else {
            return "Incorrect input";
        }
        Matcher m = p.matcher(text);
        while (m.find()) {
            result.append(m.group()).append(" ");
        }
        return result.toString().trim();
    }

}
