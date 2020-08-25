/*
Patrick Liu 
start PasswordMaker:08/18/2020 
PasswordMaker is functional: 8/22/2020
*/

import java.util.*;
import java.io.*;

//class prompts user to generate a password, with or without certain
//characters only.
public class PasswordMaker {

    //pre:  prompts user to specify if they want to exclude characters
    //      and how long they want the password to be. User can end the
    //      program anytime.
    //post: prints out the new strong password for the user.
    public static void main(String[] args) throws FileNotFoundException{
        Scanner console = new Scanner(System.in);
        PrintStream output = new PrintStream(new File("passwordFile.txt"));
        String start;
        String password = "";
        int count = 0;
        
        intro();

        do {
            StrongPasswordGenerator strongPass = new StrongPasswordGenerator(""); //new StrongPasswordGenerator object
            output = System.out;
            System.out.println("Character exclusion:");
            System.out.println("type no for no exclusion, yes to exclude characters");
            System.out.print("Exclude characters? ");
            String exclude = console.next();
            if (exclude.toLowerCase().startsWith("y")) {
                password = excludePassword(strongPass, console, exclude);
                output.println("password " + count + ":\t" + password);
            } else {
                password = regularPassword(strongPass, console);
                output.println("password " + count + ":\t" + password);
            }
            System.out.println("Your new strong password is: " + password);
            count++;
            System.out.print("End program? (y/n): ");
            start = console.next();
        } while (!start.startsWith("y"));

    }


    //post: prints out an introduction and defines what a strong
    //      password is for the user
    public static void intro() {
        System.out.println("Welcome to the Strong Password Generator");
        System.out.println("This program will help you create a strong password.");
        System.out.println("A strong password contains upper and lower case");
        System.out.println("characters, numerical characters, and symbols.");
        System.out.println("It also must be at least 6 characters long");
        System.out.println("Use this program anytime you need a password change\n");

    }

    //pre:  prompts user to enter which characters to exclude and how long
    //      they want the password to be. Exception thrown if length < 6.
    //post: prints out a new strong password for the user.
    public static String excludePassword(StrongPasswordGenerator strongPass, 
                                         Scanner console, String exclude){
        StrongPasswordGenerator excluder;
        ArrayList < Character > list;
        //Scanner consoleNew = new Scanner(System.in);

        System.out.print("Which characters to exclude? ");
        String excludeChars = console.next();
        excluder = new StrongPasswordGenerator(excludeChars);
        try {
            System.out.print("password length? ");
            strongPass.set(console.nextInt());
        } catch (Exception e) {
            System.out.println("Please enter an integer value greater than 6");
        }
        strongPass.exclude(excluder.get());
        //strongPass.toString();
        return strongPass.toString();
        //System.out.println("Your new strong password is: " + strongPass);


    }

    //pre:  prompts user for password length. Exception thrown if length < 6.
    //post: generates a new strong password.
    public static String regularPassword(StrongPasswordGenerator strongPass, Scanner console) {
        try {
            System.out.print("password length? ");
            strongPass.set(console.nextInt());
        } catch (Exception e) {
            System.out.println("Please enter an integer value greater than 6");
        }
        return strongPass.toString();
        //System.out.println("Your new strong password is " + generatedPass);
    }
    
}