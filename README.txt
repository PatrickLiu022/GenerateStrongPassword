# StrongPasswordGenerator
This program generates a strong password the user.
It uses upper case, lower case, numerical, and symbolic characters.
You can choose to exclude certain characters as well.
- Patrick Liu

FEATURES:

   DONE:
      Program Integrity:
	 First version of program functions correctly 8/22
	    User can generate a new strong password; They can choose which characters to
	    exclude and choose the length of the new password. User can generate as many
	    passwords as desired.
      Features:
      	 Users can generate a password for length i. 8/16
         Users can choose to exclude characters.     8/16
         Password will be presented as a String 8/20
      Bugs:
         Resolved password not meeting length requirements after excluding characters. 8/18
         Resolved Regenerating unwanted characters bug. 8/18
	 Resolved previous password adding on to new password bug. 8/20
	 Resolved exclude method accounting for brackets and commas, 8/22
         Resolved User not being able to enter as many passwords as desired. 8/22
	 Resolved excluding characters adds on those characters to the end of the password 8/22

   IN PROGRESS:
      Features:
         Printing the password to an output file.
	 Changing password for specific account (maps)
      Bugs: 
	 No current bugs; all bugs resolved as of 8/22

   FUTURE FEATURES:
      Can choose which passwords to change for which accounts.

FUTURE DEVELOPMENT:
In order to ensure consistency across the users' devices, future development for a security app will be underway. This will be done through XCode.


PasswordMaker.java:
   PasswordMaker prompts the user to either 1) end the program or 2) generate a password and 
   if they want to exclude characters. Then it generates a new strong password. Uses a Scanner 
   object to control password generation by taking user input.
   
   
StrongPasswordGenerator
   StrongPasswordGenerator stores a randomly generated password using ASCII values stored in an
   ArrayList object.

   public StrongPasswordGenerator()
	Initializes a StrongPasswordGenerator object to size 0;

   public StrongPasswordGenerator(String data)
	Constructs a password inventory of characters from ASCII characters with values 
	33 - 57 and 65 - 126 and stores the data in a list, respectively. Stores values
	in other necessary data fields as well.

   public int size()
	Returns the number of elements in the list.
 
   public ArrayList<Character> get()
	Returns all elements of the list

   public void set(int length) 
	Sets a new password that is as long as the given length by randomly choosing from 
	the permitted ASCII characters and storing it in the password inventory. If the 
	a password length that is less than 6 is passed, an IllegalArgumentException is 
	thrown.

   public ArrayList<Character> exclude(ArrayList<Character> other)
	Compares the password inventory with another password inventory and removes any
	element in the original password inventory. Then adds in as many ASCII characters
	as removed that are permitted by the user.

   public boolean includes(char val, ArrayList<Character> other)
	Returns whether or not a specific character from the original password inventory 	
	exists in another password inventory.

   public String toString()
	Takes the password inventory and stores all the elements into one String.

Contact me if you want to work on it with me!

Email: pzl2@uw.edu
