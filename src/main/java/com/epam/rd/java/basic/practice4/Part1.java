package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    private static final Logger logger = Logger.getLogger(Part1.class.getName());

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        String[] lines = reader("part1.txt").split(System.lineSeparator());

        for (String line : lines) {
            String[] words = line.split(" ");

            for (int i = 0; i < words.length; i++) {
                if (isCyrillic(words[i]) && words[i].length() > 7) {
                    result.append(words[i].substring(4));
                } else if (!isCyrillic(words[i]) && words[i].length() > 3) {
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
        logger.log(Level.INFO, result.toString());
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
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static boolean isCyrillic(String word) {
        Pattern p = Pattern.compile("\\p{IsCyrillic}");
        Matcher m = p.matcher(word);
        return m.find();
    }
}



/*String text = Util.readFile(FILE_PATH);
         StringBuilder result = new StringBuilder(text);
        Pattern p = Pattern.compile("[\\p{IsCyrillic}|\\p{IsLatin}]{4,}");
        Matcher m = p.matcher(result);

        while (m.find()) {
            System.out.println(m.group());
            result.replace(m.start(), m.start() + 1, "");
            System.out.println(result);
        }
        System.out.println(result);

        try (Scanner scannerFromTxt = new Scanner(new FileInputStream("part1.txt"), "UTF-8")) {
            while (scannerFromTxt.hasNext()) {
                text.append(scannerFromTxt.nextLine()).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        */
