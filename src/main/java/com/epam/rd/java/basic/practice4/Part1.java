package com.epam.rd.java.basic.practice4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static final String FILE_PATH = System.getProperty("user.dir") + "/part1.txt";
    //public static final String REGEX = "[a-zA-Zа-яєїА-ЯЄЇ]{4,}";

    public static void main(String[] args) {
        String text = Util.readFile(FILE_PATH);
        StringBuilder result = new StringBuilder();
        //Pattern p = Pattern.compile(REGEX);
        //Matcher m = p.matcher(text);


    }

}
/*String[] lines = text.split("\r\n");
        for (String line : lines) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (word.length() >= 4) {
                    result.append(word.substring(4)).append(" ");
                } else {
                    result.append(word).append(" ");
                }
            }
            result.append(System.lineSeparator());
        }
        System.out.println(result);*/