package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 {

    private static final Logger logger = Logger.getLogger(Part4.class.getName());

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (Scanner scannerFromTxt = new Scanner(new FileInputStream("part4.txt"), "Cp1251")) {
            while (scannerFromTxt.hasNext()) {
                text.append(scannerFromTxt.nextLine()).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            logger.warning(e.getMessage());
        }
        AnIterableClass c = new AnIterableClass(text.toString());

        for (Object o : c) {
            System.out.println(o.toString().replaceAll("\\s+", " "));
        }
    }
}

class AnIterableClass implements Iterable<Object> {
    String text;

    public AnIterableClass(String text) {
        this.text = text;
    }

    @Override
    public Iterator<Object> iterator() {

        return new ImpIterator();
    }

    private class ImpIterator implements Iterator<Object> {
        String regex = "\\b[\\p{IsCyrillic}|\\p{IsLatin}][^.]+\\.";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);

        @Override
        public boolean hasNext() {
            return m.find();
        }

        @Override
        public Object next() {
            if (m.group() == null) {
                throw new NoSuchElementException();
            }
            return m.group();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
