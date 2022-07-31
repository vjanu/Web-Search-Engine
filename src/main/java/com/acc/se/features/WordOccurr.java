package com.acc.se.features;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WordOccurr {
    static String path = System.getProperty("user.dir");
    public static void createUserFile() {
        try {
            File fileObj = new File(path + "\\src\\main\\resources\\static\\data\\ouccur\\occurr.txt");
            if (fileObj.createNewFile()) {
                System.out.println("File created: " + fileObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeInFile(String userip) {
        try(FileWriter fileWriter = new FileWriter(path + "\\src\\main\\resources\\static\\data\\occurr\\occurr.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);) {

            printWriter.println(userip);
        }
        catch (IOException e) {
            System.out.println("exception occurred" + e);
        }
    }
}
