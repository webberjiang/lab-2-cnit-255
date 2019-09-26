/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringFunLab;

import java.util.Scanner;
public class StringFunLab {

    /**
     *
     */
    public static final String START_STRING = "abc def";
/**
* Prints the provided ‘errorMessage‘, then reminds the
* user what all the commands are and how to use them.
* You do not need to edit this function.
*/
public static void printHelp(String errorMessage)
{
System.err.println(errorMessage);
System.err.println("Usage - enter one of the following Commands:");
System.err.println();
System.err.println("searchText [text]: prints the index of [text] in "
+ "the String, leaves it unchanged.");
System.err.println("removeText [text] - deletes all occurences of "
+ "[text] in the String.");
System.err.println("addText [i] [text] - first argument is an integer "
+ "between 0 and and the length of the string; "
+ "adds [text] at that location in the string.");
System.err.println("reverseText [no argument] - makes the string into "
+ "its mirror image.");
System.err.println("reverseEachWord [no argument] - like reverseText "
+ "but applies to each command word individually.");
System.err.println("printString [no argument] - prints the current "
+ "value of the string.");
System.err.println("enterNewString [text] - overwites whatever the "
+ "string was with [text] instead.");
System.err.println("quit [no argument] - exits the program.");
System.err.println("");
}
/**
* Implements the "printString" command. This command doesn’t change
* theString, so we just return what it was.
*/
public static String printString(String oldString, String[] commandWords)
{
System.out.println(oldString);
return oldString;
}
/**
* A useful function, combines all of the words in ‘words‘ starting from
* ‘index‘. You do not need to edit this function.
*/
private static String combineWordsFrom(String[] words, int index)
{
String newString = "";
for(int i = index; i < words.length; i+=1)
{
if(i > 1)
{
newString += " ";
}
newString += words[i];
}
return newString;
}
/**
* Implements the "enterNewString" command. You probably want to
* create a similar function for each string command. Note that
* ‘oldString‘ is ignored by this particular command/function.
*/
public static String searchText (String oldString, String[] commandWords)
{
 String newString = oldString;  
 if (commandWords.length < 2)
{
printHelp("enterNewString - requires an argument");
} 
 else{
 String st = commandWords[1];
 int pos = newString.indexOf(st);
 System.out.println(pos);
 }
  return oldString;
}
public static String removeText (String oldString, String[] commandWords)
{
 String newString = oldString;  
 if (commandWords.length < 2)
{
printHelp("removeText - requires an argument");
} 
 else{
 String remove = commandWords[1];
 newString = newString.replaceAll(remove,"");
 
 }
 return newString;
 
}
public static String addText (String oldString, String[] commandWords)
{
 String newString = oldString;  
 int stringlength = newString.length();
        int loc = Integer.parseInt(commandWords[1]);
        String addword = commandWords[2];
         if (commandWords.length < 2)
{
printHelp("addText - requires an argument");
} 
 else if(  loc< 0 || loc> stringlength ){
 printHelp("addText - invalid index(must be int between 0 and string length):"+ loc);
 
}
 else{
newString =  newString.substring(0,loc)+ addword + newString.substring(loc);

 }
 return newString;       }



public static String reverseText(String oldString, String[] commandWords)
{
 String newString = oldString;  
 String reverse = "";      
     {for(int i = newString.length() - 1; i >= 0; i--)
{
    reverse = reverse + newString.charAt(i);
		}
         }
 
return reverse;   
}

public static String reverseEachWord(String oldString, String[] commandWords)
{
   String newString = oldString;
   String[] words =  newString.split(" ");
   String reverseEachWord ="";
    for (int i=0; i < words.length;i++)
    {
      String word = words[i];
      String reverseWord = "";
      for (int j= word.length()-1; j>=0;j--)
      {
          reverseWord = reverseWord + word.charAt(j);
      }
   reverseEachWord =  reverseEachWord + reverseWord + " ";
    }
   
   return reverseEachWord;
}
   

public static String enterNewString(String oldString, String[] commandWords)
{
// This command needs an argument after the command; if it’s missing
// that’s an error.
if (commandWords.length < 2)
{
printHelp("enterNewString - requires an argument");
return null;
}
return combineWordsFrom(commandWords, 1);
}
// TODO - add further functions, like printString() and enterNewString() above,
// that you can use in handleStringCommand below to implement the various other
// string commands.
/**
* This method should return the result of applying the string command
* represented by ‘commandWords‘, or else null (if the command was not
* recognized or the wrong arguments were supplied). When returning
* null, an appropriate error message should first be printed (use
* printHelp()).
*/
public static String handleStringCommand(String oldString, String[] commandWords)
{
if ("printString".equals(commandWords[0]))
{
return printString(oldString, commandWords);
}
else if ("enterNewString".equals(commandWords[0]))
{
return enterNewString(oldString, commandWords);
}
else if ("searchText".equals(commandWords[0]))
{
 return searchText(oldString, commandWords);
}
else if ("removeText".equals(commandWords[0]))
{
    return removeText(oldString,commandWords);
}
else if ("addText".equals(commandWords[0]))
{
    return addText(oldString,commandWords);
}
else if ("reverseText".equals(commandWords[0]))
{ 
    return reverseText(oldString,commandWords);
}
else if ("reverseEachWord".equals(commandWords[0]))
{ 
    return reverseEachWord(oldString,commandWords);
}
// TODO - add support for the rest of the commands here.
//
else
{
printHelp("Unknown command: "+commandWords[0]);
return null;
}
}
public static void main(String args[])
{
String theString = START_STRING;
Scanner s = new Scanner(System.in);
boolean run = true;
do
{
System.out.print("Enter Command: ");
String line = s.nextLine();
String[] commandWords = line.split(" ");
// Handle "quit" specially.
if ("quit".equals(commandWords[0]))
{
run = false;
}
else
{
// Everything besides quit should be a command that alters
// ‘theString‘.
String newString = handleStringCommand(theString, commandWords);
if (newString != null)
{
theString = newString;
}
}
} while(run == true);
}
}