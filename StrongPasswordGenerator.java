/*
Patrick Liu 
start StrongPasswordGenerator: 08/18/2020  
StrongPasswordGenerator is functional: 08/23/2020
*/


import java.util.*;

//class generates a random array of characters on the ASCII table
//that will be used as a new password for the user.
public class StrongPasswordGenerator {

    private int size; //records password size.
    private ArrayList < Character > password; //contains generated password.
    private Random r;

    private static final int ASCII = 93; //will choose from 93 kinds of ASCII characters.

    //post: new password length is 0
    public StrongPasswordGenerator() {
        size = 0;
    }

    //pre:  A password is generated.
    //post: counts the characters in the given password and
    //      a stores each character individually. Stores the
    //      size of the password.
    public StrongPasswordGenerator(String data) {
        password = new ArrayList < Character > ();
        for (int i = 0; i < data.length(); i++) {
            password.add(data.charAt(i));
            size++;
        }
    }

    //post: gives the size of the password.
    public int size() {
        return size;
    }

    //post: returns the password.
    public ArrayList < Character > get() {
        return password;
    }

    //pre:  @exception IllegalArgumentException if the
    //      length of desired password is less than or equal
    //      to zero.
    //post: generates random ASCII characters and stores each
    //      cahracter into a new password.
    public void set(int length) {
        int count = 0;
        r = new Random();

        if (length < 6) {
            throw new IllegalArgumentException();
        }

        int num = r.nextInt(ASCII) + 33;
        while (count < length) {
            char letter = (char) num;
            password.add(letter);
            num = r.nextInt(ASCII) + 33;
            count++;
        }
    }

    //pre:  characters that are not desired in the new password have been
    //      specified by the user.
    //psot: Checks if the characters the user wants to exclude exists in the
    //      new generated password and removes it if it exists.
    public ArrayList < Character > exclude(ArrayList < Character > other) {
        int count = 0;

        for (int i = 0; i < password.size(); i++) {
            if (other.contains(password.get(i))) {
                password.remove(password.get(i));
                i--;
                count++;
            }
        }

        exclude(count, other);
        return password;
    }

    //pre:  the user has entered the characters they want to exclude and
    //      is stored in an array.
    //post: generates as many ASCII characters for the new strong password 
    //      as needed to replace the excluded characters.   
    private void exclude(int count, ArrayList < Character > other) {
        int val = r.nextInt(ASCII) + 33;

        for (int i = count; i > 0; i--) {
            do {
                val = r.nextInt(ASCII) + 33;
            } while (includes((char) val, other));

            password.add((char) val);
        }
    }

    //pre:  a single character and the array of characters to be excluded
    //      exists.
    //post: true if the variable exists in the array, false if the variable
    //      does not exist.
    public boolean includes(char val, ArrayList < Character > other) {
        for (int i = 0; i < other.size(); i++) {
            if (other.get(i) == val) {
                return other.get(i) == val;
            }
        }
        return false;
    }

    //post: Takes the array of individual characters in the password
    //      and stores them together in a string.
    public String toString() {
        String strPass = "";
        for (char c: password) {
            strPass += c;
        }
        return strPass;
    }

}