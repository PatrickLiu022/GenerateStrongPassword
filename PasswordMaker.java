/*
Patrick Liu 
08/16
*/

import java.util.*;

public class PasswordMaker {

   public static void main(String[] args){
      Scanner console = new Scanner(System.in);
      boolean continueGenerate = true;
      intro();
      
      String exclude = console.nextLine();
      System.out.print("How many passwords to generate? ");
      int num = console.nextInt();
      int count = 0;
      String generate = "";
      StrongPasswordGenerator strongPass = new StrongPasswordGenerator("");
      
      while(count < num){
         generatePassword(console, strongPass, exclude);
         count++;
      }
   }
   
   public static void intro(){
      System.out.println("Welcome to the Strong Password Generator");
      System.out.println("This program will help you create a strong password");
      System.out.println("Use this anytime you need a password change");
      System.out.println("Exclude any characters?");
      System.out.println("type: no = no exclusion, yes = exclude characters");
      System.out.print("exclude characters? ");
   }
   
   public static void generatePassword(Scanner console, StrongPasswordGenerator strongPass, String exclude){
      ArrayList<Character> charPass = new ArrayList<Character>();
      StrongPasswordGenerator excluder;
      String excludedChars = "";
      int length = 0;
      
      if(!exclude.startsWith("no")){
         System.out.print("Which characters to exclude? ");
         excludedChars = console.nextLine();
         excluder = new StrongPasswordGenerator(excludedChars);
         System.out.print("password length? ");
         length = console.nextInt();
         strongPass.set(length);
         charPass = strongPass.exclude(excluder);
         String generatedPass = charPass.toString();
         System.out.println("Your new strong password is: " + generatedPass);
      } else {
         System.out.print("password length? ");
         length = console.nextInt();
         strongPass.set(length);
         
         String generatedPass = strongPass.toString();
         generatedPass = generatedPass.replace(" ", ".");
         System.out.println("Your new strong password is " + generatedPass);
      }
      
   }
   
}   
