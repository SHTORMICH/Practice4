package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (Scanner scannerFromTxt = new Scanner(new FileInputStream("part4.txt"), "UTF-8")) {
            while (scannerFromTxt.hasNext()) {
                text.append(scannerFromTxt.nextLine()).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AnIterableClass c = new AnIterableClass(text.toString());

        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString().replaceAll("\\s+", " "));
        }
    }
}

class AnIterableClass implements Iterable {

    String text;

    public AnIterableClass(String text) {
        this.text = text;
    }

    @Override
    public Iterator iterator() {

        return new ImpIterator();
    }

    private class ImpIterator implements Iterator {
        String regex = "\\b\\p{IsLatin}[^\\.]+\\.";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);

        @Override
        public boolean hasNext() {
            return m.find();
        }

        @Override
        public Object next() {
            return m.group();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
