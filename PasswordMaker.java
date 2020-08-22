/*
Patrick Liu 
08/18/2020 - current, 08/22/2020
*/

import java.util.*;

public class PasswordMaker {

   public static void main(String[] args){
      Scanner console = new Scanner(System.in);
      String start;
      intro();
      
      do {
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
      }  while(!start.startsWith("y"));
      
   }
   
   public static void intro(){
      System.out.println("Welcome to the Strong Password Generator");
      System.out.println("This program will help you create a strong password");
      System.out.println("Use this anytime you need a password change\n");

   }
   
   public static void excludePassword(StrongPasswordGenerator strongPass, String exclude){
      StrongPasswordGenerator excluder;
      ArrayList<Character> list;
      Scanner consoleNew = new Scanner(System.in);
      
      System.out.print("Which characters to exclude? ");
      String excludeChars = consoleNew.nextLine();
      excluder = new StrongPasswordGenerator(excludeChars);
      try {
         System.out.print("password length? ");
         strongPass.set(consoleNew.nextInt());
      } catch (Exception e){
         System.out.println("Please enter an integer value greater than 6");
      }
      strongPass.exclude(excluder);
      strongPass.toString();
      System.out.println("Your new strong password is: " + strongPass);
      
      
   }
   
   public static void regularPassword(Scanner console, StrongPasswordGenerator strongPass){
         try {
            System.out.print("password length? ");
            strongPass.set(console.nextInt());
         } catch (Exception e) {
            System.out.println("Please enter an integer value greater than 6");
         }
         String generatedPass = strongPass.toString();
         generatedPass = generatedPass.replace(" ", ".");
         System.out.println("Your new strong password is " + generatedPass);
   }
   
}   