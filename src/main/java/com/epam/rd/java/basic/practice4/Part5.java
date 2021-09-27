package com.epam.rd.java.basic.practice4;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Part5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("stop")) {
            String[] words = input.split(" ");
            ResourceBundle bundleEn = ResourceBundle.getBundle("resources_" + words[1]);
            System.out.println(bundleEn.getString(words[0]));
            input = scanner.nextLine();
        }
    }
}
