# StrongPasswordGenerator
This program generates a strong password the user.
It uses upper case, lower case, numerical, and symbolic characters.
You can choose to exclude certain characters as well.

FEATURES:

   DONE:
      Features:
      	 Users can generate a password for length i. 8/16
         Users can choose to exclude characters.     8/16
      Bugs:
         Resolved password not meeting length requirements after excluding characters. 8/18
         Resolved Regenerating unwanted characters bug. 8/18
	 Resolved previous password adding on to new password bug. 8/20

   IN PROGRESS:
      Printing the password to an output file.
      Conducting samples for user preference on how the password is presented.
   FUTURE FEATURES:
      User can enter as many passwords as desired.
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

This is just a rough draft! Contact me if you want to work on it with me!

Email: pzl2@uw.edu
