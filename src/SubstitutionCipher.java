//Kamil Peza March 2020
//reference: 	https://www.sanfoundry.com/java-program-implement-monoalphabetic-cypher/
//https://rosettacode.org/wiki/Substitution_Cipher#Java
import java.util.Scanner;

public class SubstitutionCipher {
	
  public static char alpha[]= { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', '.', ' ' };
	
   public static char key[] = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
            'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C',
            'V', 'B', 'N', 'M', 'p', 'o', 'i', 'u', 'y', 't', 'r', 'e', 'w',
            'q', 'a', 's', 'd', 'f', 'g', 'h', 'j', ' ', 'k', 'l', 'm', 'n',
            'b', 'v', 'c', 'x', 'z', '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', '.' };
   
   static String plaintext = "Here we have to do is there will be a input source "
           + "file in which we are going to Encrypt the file by replacing every "
           + "upper and lower case alphabets of the source file with another "
           + "predetermined upper and lower case alphabets or symbols and save "
           + "it into another output or encrypted file and then again convert "
           + "that output or encrypted file into original or decrypted file. This "
           + "type of Encryption and Decryption scheme is often called a "
           + "Substitution Cipher. My name is Kamil Peza and this is a test of Substitution cipher.";
 
//Encryption method that encrypts the plaintext.
    public static String Encryption(String s, char array[])
    {
        char c[] = new char[(s.length())];
        
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j <alpha.length; j++)
            {
                if (alpha[j] == s.charAt(i))
                {
                    c[i] = array[j];
                    break;
                }
            }
        }
        return (new String(c));
    }
    
//Decryption method that decrypts the string that is entered. 
    public static String Decryption(String s, char array[])
    {
        char p1[] = new char[(s.length())];
        
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < alpha.length; j++)
            {
                if (array[j] == s.charAt(i))
                {
                    p1[i] = alpha[j];
                    break;
                }
            }
        }
        return (new String(p1));
    }
 
//Main Method 
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("[Enter the message] " + plaintext);
        String encrypt = Encryption(plaintext, key);
        //Shows the encryption message.
        System.out.println("[Encrypted message] " + encrypt);
        //Shows the message after decryption.
        System.out.println("[Decrypted message] " + Decryption(encrypt, key));
        sc.close();
        
//finding encrypted code frequency character frequency:       
        
        //String str = "picture perfect";  
        int[] freq = new int[encrypt.length()];  
        int i, j;  
          
        //Converts given string into character array  
        char string[] = encrypt.toCharArray();  
          
        for(i = 0; i <encrypt.length(); i++) {  
            freq[i] = 1;  
            for(j = i+1; j <encrypt.length(); j++) {  
                if(string[i] == string[j]) {  
                    freq[i]++;  
                      
                    //Set string[j] to 0 to avoid printing visited character  
                    string[j] = '0';  
                }  
            }  
        }  
          
        //Displays the each character and their corresponding frequency  
        System.out.println();
        System.out.println("Characters and their corresponding frequencies (including spaces, periods, upper and lower case letters, and numbers):\n");  
        for(i = 0; i <freq.length; i++) {  
            if(string[i] != ' ' && string[i] != '0')  
                System.out.println(string[i] + "-" + freq[i]);  
        }  
    }
	
}
