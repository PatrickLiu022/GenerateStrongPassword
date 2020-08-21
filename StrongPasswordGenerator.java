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

   private static final int ASCII = 93;      //this alogirthm will use 93 kinds of ASCII characters

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
      Random r = new Random();

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
      for (Iterator<Character> itr = password.iterator();itr.hasNext(); ){
         Character c = itr.next();
         for (Iterator<Character> itr1 = other.password.iterator(); itr1.hasNext(); ){
            Character o = itr1.next();
            if (c.equals(o)){
               itr.remove();
               count++;
            }
         }
      }

      return password;
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
