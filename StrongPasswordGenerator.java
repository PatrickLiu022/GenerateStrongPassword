/*
Patrick Liu
8/16/20
*/
import java.util.*;

//class generates a random array of characters on the ASCII table
//that will be used as a new password for the user
public class StrongPasswordGenerator {

   private int size;                         //records password size
   private ArrayList<Character> password;    //contains generated password
   private Random r;

   private static final int ASCII = 93;      //will choose from 93 kinds of ASCII characters

   //post: new password length is 0
   public StrongPasswordGenerator(){
      size = 0;
   }

   //pre:  A password is generated
   //post: counts the characters in the given password and
   //      a stores each character individually. Stores the
   //      size of the password.
   public StrongPasswordGenerator(String data){
      password = new ArrayList<Character>();
      for (int i = 0; i < data.length(); i++){
         password.add(data.charAt(i));
         size++;
      }
   }

   //post: gives the size of the password
   public int size(){
      return size;
   }

   //post: returns the password
   public ArrayList<Character> get(){
      return password;
   }

   //pre:  @exception IllegalArgumentException if the
   //      length of desired password is less than or equal
   //      to zero
   //post: generates random ASCII characters and stores each
   //      cahracter into a new password
   public void set(int length){
      int count = 0;
      r = new Random();

      if (length <= 0){
         throw new IllegalArgumentException();
      }

      int num = r.nextInt(ASCII) + 33;
      while(count < length){
         char letter = (char) num;
         password.add(letter);
         num = r.nextInt(ASCII) + 33;
         count++;
      }
   }

   //pre:  characters that are not desired in the new password have been
   //      specified by the user
   //psot: Checks if the characters the user wants to exclude exists in the
   //      new generated password and removes it if it exists.
   public ArrayList<Character> exclude(StrongPasswordGenerator other){
      int count = 0;
      for (int i = 0; i < password.size(); i++){
         Character pass = password.toString().charAt(i);
         for (int j = 0; j < other.password.size(); j++){
            Character remove = other.password.toString().charAt(i);
            if (pass.equals(remove)){
               password.remove(pass);
               count++;
            }
         }
      }
      exclude(count, other);  

      return password;
   }
   
   private void exclude(int count, StrongPasswordGenerator other){
      int val = r.nextInt(ASCII) + 33;
      
      for (int i = count; i > 0; i++){
         while (other.contains((char) val, other)){
            val = r.nextInt(ASCII) +  33;  
         } 
         password.add((char) val);
         count--;        
      } 
   }
   
   private boolean contains(char val, StrongPasswordGenerator other){
      for (int i = 0; i < other.size(); i++){
         if (other.toString().charAt(i) == val){
            return !(other.toString().charAt(i) == val);
         }
      }
      return true;
   }  

   //post: Takes the array of individual characters in the password
   //      and stores them together in a string
   public String toString(){
      String strPass = "";
      for (char c : password){
         strPass += c;
      }
      return strPass;
   }
}
