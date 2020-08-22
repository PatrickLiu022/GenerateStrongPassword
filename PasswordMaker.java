/*
*/

import java.util.*;

public class PasswordMaker {

   public static void main(String[] args){
      Scanner console = new Scanner(System.in);
      
      intro();
      System.out.print("End program? (y/n): ");
      String start = console.nextLine();
      
      while(!start.startsWith("y")){
         StrongPasswordGenerator strongPass = new StrongPasswordGenerator("");
         Scanner redo = new Scanner(System.in);
         System.out.println("Character exclusion:");
         System.out.println("type no for no exclusion, yes to exclude characters");
         System.out.print("Exclude characters? ");
         String exclude = redo.nextLine();
         if (exclude.toLowerCase().startsWith("y")) {
            excludePassword(strongPass, exclude);
         } else {
            regularPassword(console, strongPass);
         }
         System.out.print("End program? (y/n): ");
         start = redo.nextLine();
      }
   }
   
   public static void intro(){
      System.out.println("Welcome to the Strong Password Generator");
      System.out.println("This program will help you create a strong password");
      System.out.println("Use this anytime you need a password change\n");

   }
   
   public static void excludePassword(StrongPasswordGenerator strongPass, String exclude){
      StrongPasswordGenerator excluder;
      Scanner consoleNew = new Scanner(System.in);
      
      System.out.print("Which characters to exclude? ");
      String excludeChars = consoleNew.nextLine();
      excluder = new StrongPasswordGenerator(excludeChars);
      System.out.print("password length? ");
      strongPass.set(consoleNew.nextInt());
      strongPass = strongPass.exclude(excluder);
      System.out.println("Your new strong password is: " + strongPass.toString());
      
      
   }
   
   public static void regularPassword(Scanner console, StrongPasswordGenerator strongPass){
         System.out.print("password length? ");
         strongPass.set(console.nextInt());
         String generatedPass = strongPass.toString();
         generatedPass = generatedPass.replace(" ", ".");
         System.out.println("Your new strong password is " + generatedPass);
   }
   
}   