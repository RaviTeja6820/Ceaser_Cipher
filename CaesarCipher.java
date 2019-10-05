
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class CaesarCipher {
public String encrypt(String input,int key)
{
    StringBuilder encrypted=new StringBuilder(input);
    String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String ShiftedAlpha=alpha.substring(key)+alpha.substring(0,key);
    for(int i=0;i<encrypted.length();i++)
    {
        int idx=-1;
        char currChar = encrypted.charAt(i);
        if(Character.isUpperCase(currChar))
        {
            idx=alpha.indexOf(currChar);
            if(idx!=-1)
            {
            char newChar = ShiftedAlpha.charAt(idx);
            encrypted.setCharAt(i,newChar);
            }
        }
        else
        {
            idx=alpha.indexOf(Character.toUpperCase(currChar));
            if(idx!=-1)
            {
            char newChar = ShiftedAlpha.charAt(idx);
            encrypted.setCharAt(i,Character.toLowerCase(newChar));
            }
        }
    }
    return encrypted.toString();
}
public String encryptTwoKeys(String input,int key1,int key2)
{
    StringBuilder encrypted=new StringBuilder(input);
    String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String ShiftedAlpha1=alpha.substring(key1)+alpha.substring(0,key1);
    String ShiftedAlpha2=alpha.substring(key2)+alpha.substring(0,key2);
    for(int i=0;i<encrypted.length();i++)
    {
        int idx=-1;
        char currChar = encrypted.charAt(i);
        if(i%2==0)
        {
            if(Character.isUpperCase(currChar))
            {
            idx=alpha.indexOf(currChar);
            if(idx!=-1)
            {
            char newChar = ShiftedAlpha1.charAt(idx);
            encrypted.setCharAt(i,newChar);
            }
            }
        else
            {
            idx=alpha.indexOf(Character.toUpperCase(currChar));
            if(idx!=-1)
            {
            char newChar = ShiftedAlpha1.charAt(idx);
            encrypted.setCharAt(i,Character.toLowerCase(newChar));
            }
            }
        }
        else
        {
            if(Character.isUpperCase(currChar))
            {
            idx=alpha.indexOf(currChar);
            if(idx!=-1)
            {
            char newChar = ShiftedAlpha2.charAt(idx);
            encrypted.setCharAt(i,newChar);
            }
            }
            else
            {
            idx=alpha.indexOf(Character.toUpperCase(currChar));
            if(idx!=-1)
            {
            char newChar = ShiftedAlpha2.charAt(idx);
            encrypted.setCharAt(i,Character.toLowerCase(newChar));
            }
            }
        }
    }
    return encrypted.toString();
}
public void test()
{
    //FileResource fr=new FileResource();
    //String input=fr.asString();   
    String encrypted = encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?",15);
    String encrypte = encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?",21,8 );
    System.out.println("key is: "+15+"\n"+encrypted+"\n"+encrypte);
}
}
