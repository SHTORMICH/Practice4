package com.epam.rd.java.basic.practice4;

import java.io.*;

public class Part2 {

    public static void main(String[] args) {
        int[] randomNubs = new int[10];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            randomNubs[i] = (int) (Math.random() * 50 + 1);

        }
        writeToFile("part2.txt", randomNubs);

        for (int i = 0; i <= randomNubs.length - 1; i++) {
            for (int j = 0; j < randomNubs.length - 1 - i; j++) {
                if (randomNubs[j] > randomNubs[j + 1]) {
                    int temp = randomNubs[j];
                    randomNubs[j] = randomNubs[j + 1];
                    randomNubs[j + 1] = temp;
                }
            }
        }
        writeToFile("part2_sorted.txt", randomNubs);
        System.out.println(result
                .append("input ==>")
                .append(reader("part2.txt"))
                .append(System.lineSeparator())
                .append("output ==>")
                .append(reader("part2_sorted.txt")));
    }

    public static File writeToFile(String path, int[] randomNubs) {
        File numbers = new File(path);
        try (PrintWriter file = new PrintWriter(numbers)){
            for (int el : randomNubs) {
                file.printf(" %s", el);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return numbers;
    }

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
            e.printStackTrace();
        }
        return builder.toString();
    }
}


