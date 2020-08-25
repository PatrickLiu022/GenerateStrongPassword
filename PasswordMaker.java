import java.io.*;
import java.util.*;

public class PasswordMaker {

    public static void main(String[] args) throws FileNotFoundException{
        PrintStream output = new PrintStream(new File("passwordFile.txt"));
        Scanner console = new Scanner(System.in);
        String start;
        String password = "";
        int count = 0;
        
        intro();
        
        System.out.println("enter 1");
        int num = console.nextInt();
        
        output.println("made it to " + num + "st post");
        
        intro();
        output.println("test second post: " + num + "8 number: " + 10);
        do {
            output.println("test third post: " + num + "8 number: " + 10);
            StrongPasswordGenerator strongPass = new StrongPasswordGenerator(""); //new StrongPasswordGenerator object
            System.out.println("Character exclusion:");
            System.out.println("type no for no exclusion, yes to exclude characters");
            System.out.print("Exclude characters? ");
            String exclude = console.next();
            output.println("test fourth post: " + num + "8 number: " + 10);
            if (exclude.toLowerCase().startsWith("y")) {
                password = excludePassword(strongPass, console, exclude);
            } else {
                password = regularPassword(strongPass, console);
                output.println("else conditional: " + num + "8 number: " + 10);
            }
            System.out.println("Your new strong password is: " + password);
            count++;
            output.println("before end program: " + num + "8 number: " + 10);
            //output.println("password "+ count + ": " + password);
            System.out.print("End program? (y/n): ");
            start = console.next();
            output.println("password: " + password);
        } while (!start.startsWith("y"));
        output.println("out do while: " + num + "8 number: " + 10);
        output.println("last test print password: " + password);
        output.println("password " + num + ": " + password);

        
        
        
        
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
        ArrayList <Character> list;
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
        strongPass.exclude(excluder);
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