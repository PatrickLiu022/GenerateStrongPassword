## StrongPasswordGenerator
### Read me
#### Purpose:
This program generates a strong password the user.
It uses upper case, lower case, numerical, and symbolic characters.
You can choose to exclude certain characters as well.
#### Features:
- First version of program functions correctly
    - User can generate a new strong password
        - User can choose which characters to exclude.
        - User can dictate length of new password gnerated.
        - User can choose number of newly generated passwords.
#### Known Bugs:
- [x] Password not meeting length requirements after excluding characters.
    - *resolved 8/18*
- [x] Resolved Regenerating unwanted characters bug
    - *resolved 8/18*
- [x] Resolved previous password adding on to new password bug.
    - *resolved 8/20*
- [x] Resolved exclude method accounting for brackets and commas.
    - *resolved 8/22*
- [x] Resolved User not being able to enter as many passwords as desired.
    - *resolved 8/22*
- [x] Resolved excluding characters adds on those characters to the end of the password
    - *resolved 8/22* 
- [x] Output password not printing to output file.
    - *resolved 8/25*

#### In Progress: 
- [x] Printing the password to an output file.
- [ ] Changing password for specific account (maps).

#### Future Roadmap:
- [ ] Can choose which passwords to change for which accounts.
- [ ] Utilize underlying algorithm for iOS app development.
      
#### Implementation Details:
- PasswordMaker.java:
    - Takes in user input and generates a strong password using Scanner object.
- StrongPasswordGenerator.java
    - StrongPasswordGenerator stores a randomly generated password using ASCII values stored in an ArrayList object.
    - Constructs a password inventory of characters from ASCII characters with values
    - Stores the data in a list, respectively. Stores values in other necessary data fields as well.
    - Sets a new password that is as long as the given length by randomly choosing from the permitted ASCII characters and storing it in the password inventory.
    - Handles IllegalArgumentException errors thrown when given user input is less than 6 characters in length.
	- Compares the password inventory with another password inventory and removes any element in the original password inventory. Then adds in as many ASCII characters as removed that are permitted by the user.
	- Returns whether or not a specific character from the original password inventory exists in another password inventory.
	- Takes the password inventory and stores all the elements into one String.


#### Follow ups:
Feel free to contact me if you want to work on it with me!

Email: pzl2@uw.edu
