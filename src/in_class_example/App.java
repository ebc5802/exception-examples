package in_class_example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // call a method that contains a try/catch to handle an exception
        openFile("foo.txt");

        // call a method that declares that it throws an exception
        try {
            openFileDifferently("foo.txt");
        }
        catch(FileNotFoundException e) {
            System.out.println("Sorry, that file does not exist: " + e);
        }

        // call a method that may throw a custom checked exception type
        try {
            doSomething1();
        }
        catch (NonsenseCheckedException e) {
            System.out.println("Sorry, there was a nonsense exception: " + e);
        }

        // call a method that may throw a custom unchecked exception type
        doSomething2();


    }

    public static void openFile(String filepath) {
        try {
            Scanner scn = new Scanner(new File(filepath));
        }
        catch(FileNotFoundException e) {
            System.out.println("Sorry, that file does not exist: " + e);
        }        
    }

    public static void openFileDifferently(String filepath) throws FileNotFoundException {
        Scanner scn = new Scanner(new File(filepath));
    }

    public static void doSomething1() throws NonsenseCheckedException {
        System.out.println("Thank you for calling this malfunctioning method.");
        // sometimes we throw an exception, sometimes we don't
        int randy = (int) (Math.random() * 10);
        if (randy > 5) {
            NonsenseCheckedException e = new NonsenseCheckedException();
            throw e;
        }
    }

    public static void doSomething2() {
        System.out.println("Thank you for calling this malfunctioning method.");
        // sometimes we throw an exception, sometimes we don't
        int randy = (int) (Math.random() * 10);
        if (randy > 5) {
            NonsenseUncheckedException e = new NonsenseUncheckedException();
            throw e;
        }
    }

}



