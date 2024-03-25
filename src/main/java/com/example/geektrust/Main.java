package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProcessInput processInput = new ProcessInput();

        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
                String lineInput = sc.nextLine();
                String[]  eachCommand = lineInput.split(" ");
                processInput.parseAndAct(eachCommand);
                //Add your code here to process input commands
            }
            sc.close(); // closes the scanner
        } catch (IOException | InvalidParameterException ip) {
            System.out.println(ip.getMessage());
        }

    }

}
