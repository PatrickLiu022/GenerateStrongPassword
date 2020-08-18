/* 
Patrick Liu
8/16/20
*/
import java.util.*;


public class StrongPasswordGenerator {

   private int size;
   private ArrayList<Character> password;
   private Random r;
   
   private static final int ASCII = 127;
   
   public StrongPasswordGenerator(){
      size = 0;
   }
   
   public StrongPasswordGenerator(String data){
      password = new ArrayList<Character>();
      for (int i = 0; i < data.length(); i++){
         password.add(data.charAt(i));
         size++;
      }
   }
   
   public int size(){
      return size;
   }
   
   public void set(int length){
      int count = 0;
      r = new Random();
      
      if (length <= 0){
         throw new IllegalArgumentException();
      }
      
      int num = r.nextInt(93) + 33;
      while(count < length){
         char letter = (char) num;
         password.add(letter);
         num = r.nextInt(93) + 33;
         count++;
      }  
   }

   
   public ArrayList<Character> get(){
      return password;
   }
   
   public ArrayList<Character> exclude(StrongPasswordGenerator other){
      for (Iterator<Character> itr = password.iterator();itr.hasNext(); ){
         Character c = itr.next();
         for (Iterator<Character> itr1 = other.password.iterator(); itr1.hasNext(); ){
            Character o = itr1.next();
            if (c.equals(o)){
               itr.remove();
            }
         }
      }
      
      return password;
   }
   
   public String toString(){
      String strPass = "";
      for (char c : password){
         strPass += c;
      }
      return strPass;
   }
}