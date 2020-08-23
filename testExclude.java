/* Patrick Liu
   08/22/2020
*/
   
import java.util.*;

//this class is testing the best way to compare two ArrayLists
//and remove any element they have that are the exact same.
public class testExclude {

   private ArrayList<Character> password;
   private ArrayList<Character> other;
   
   public static void main(String[] args){
      ArrayList<Character> password = new ArrayList<Character>();
      
      ArrayList<Character> other = new ArrayList<Character>();
      
      password.add('a');
      password.add('b');
      password.add('c');
      password.add('d');
      password.add('e');
      password.add('f');
      
      other.add('1');
      other.add('2');
      other.add('3');
      other.add('4');
      other.add('c');
      other.add('5');
      other.add('6');
      other.add('7');
      other.add('f');
      other.add('8');
      
      System.out.println(password);
            
   }
   
   public static void exclude(ArrayList<Character> other){
      password = exclude(password, other);
   }
   
   private static ArrayList<Character> exclude(ArrayList<Character> password, 
                              ArrayList<Character> other){
      if (){ //looping through password is done
         //return password
      } else if (){ //password contains a char at i in other
         //recursive case: return exclude(password, other);
         //return password = remove that character
      } else {
         //return exclude(password, other)
      }
   }
   
}