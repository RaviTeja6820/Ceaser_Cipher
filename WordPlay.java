
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
public class WordPlay {
public boolean isVowel(char ch)
{
    String vowel="aeiou";
    for(int i=0;i<vowel.length();i++)
    {
        if(ch==vowel.charAt(i))
        return true;
    }
    return false;
}
public String replaceVowels(String phrase,char ch)
{
    String newStr="";
    for(int i=0;i<phrase.length();i++)
    {
        if(isVowel(phrase.charAt(i)))
        newStr=newStr+"*";
        else
        newStr=newStr+phrase.charAt(i);
    }
    return newStr;
}
public String emphasize(String phrase,char ch)
{
    String newStr="";
    for(int i=0;i<phrase.length();i++)
    {
        if(ch==phrase.charAt(i)||Character.toUpperCase(ch)==phrase.charAt(i))
        {
            if(i%2==0)
            newStr=newStr+"*";
            else
            newStr=newStr+"+";
        }
        else
        newStr=newStr+phrase.charAt(i);
    }
    return newStr;
}
public void test()
{
    System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
}
}
