package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (Scanner scannerFromTxt = new Scanner(new FileInputStream("part1.txt"), "UTF-8")) {
            while (scannerFromTxt.hasNext()) {
                text.append(scannerFromTxt.nextLine()).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder result = new StringBuilder();
        String[] lines = text.toString().split(System.lineSeparator());
        System.out.println();
        for (String line : lines) {
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > 3) {
                    result.append(words[i].substring(2));
                } else {
                    result.append(words[i]);
                }
                if (i != words.length - 1) {
                    result.append(" ");
                }
            }
            result.append(System.lineSeparator());
        }
        System.out.println(result);

    }
}
/*
 public static String reader(String path) {
        File file = new File(path);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String value = reader.readLine();
            while (value != null) {
                builder.append(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return builder.toString();
    }*/

/*String text = Util.readFile(FILE_PATH);
         StringBuilder result = new StringBuilder(text);
        Pattern p = Pattern.compile("[\\p{IsCyrillic}|\\p{IsLatin}]{4,}");
        Matcher m = p.matcher(result);

        while (m.find()) {
            System.out.println(m.group());
            result.replace(m.start(), m.start() + 1, "");
            System.out.println(result);
        }
        System.out.println(result);*/
