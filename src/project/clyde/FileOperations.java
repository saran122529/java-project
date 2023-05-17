package project.clyde;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOperations {

    public static void writeToFile(String fileName, int[] data) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (int i : data) {
            printWriter.println(i);
        }
        printWriter.close();
    }

    public static void writeToFile(String fileName, String data) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(data);
        printWriter.close();
        System.out.println("Please see " + fileName + " for results.");
    }

    public static void writeToFile(String fileName, int data) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(data);
        printWriter.close();
        System.out.println("Please see " + fileName + " for results.");
    }

}
