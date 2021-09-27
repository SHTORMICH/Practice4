package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    private static final String REGEX_CYRIL = "\\p{IsCyrillic}+";
    private static final String REGEX_LATIN = "[a-zA-Z]+";

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        //text.append(reader("part6.txt"));
        try (Scanner scannerFromTxt = new Scanner(new FileInputStream("part6.txt"), "Cp1251")) {
            while (scannerFromTxt.hasNext()) {
                text.append(scannerFromTxt.nextLine()).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(text);
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
            return input + "Incorrect input";
        }
        Matcher m = p.matcher(text);
        while (m.find()) {
            result.append(m.group()).append(" ");
        }
        result.append("\n");
        return result.toString();
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
