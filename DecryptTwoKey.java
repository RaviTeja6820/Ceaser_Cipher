
/**
 * Write a description of DecryptOneKey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
public class DecryptTwoKey {
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
public int[] countAlpha(String str){
    String alpha = "abcdefghijklmnopqrstuvwxyz";
    int[] count=new int[26];
    for(int i=0;i<str.length();i++){
        char ch=Character.toLowerCase(str.charAt(i));
        int dex=alpha.indexOf(ch);
        if(dex!=-1){
            count[dex]+=1;
        }
    }
    for(int i=0;i<count.length;i++){
        if(count[i]!=0)
        System.out.println("Count["+i+"]="+count[i]);
    }
    return count;
}
public int maxIndex(int[] arr){
    int max=arr[0],maxInd=0;
    for(int i=0;i<arr.length;i++){
        if(arr[i]>max){
        max=arr[i];
        maxInd=i;
    }
    }
    return maxInd;
}
public String decryptTwoKeys(String str){
    String str1="",str2="";
    for(int i=0;i<str.length();i++){
        if(i%2==0)
        str1+=str.charAt(i);
        else
        str2+=str.charAt(i);
    }
    System.out.println("str1");
    int[] freqs1 = countAlpha(str1);
    System.out.println("Str2");
    int[] freqs2 = countAlpha(str2);
    int maxDex1 = maxIndex(freqs1);
    int maxDex2 = maxIndex(freqs2);
    System.out.println("maxdex1 "+maxDex1+"maxDex2 "+maxDex2);
    int dkey1 = maxDex1 - 4;
    int dkey2 = maxDex2 - 4;
    System.out.println("dkey1 "+dkey1+"dkey2 "+dkey2);
    if(maxDex1<4)
    dkey1 = 26-(4-maxDex1);
    if(maxDex2<4)
    dkey2 = 26-(4-maxDex2);
    System.out.println("dkey1 "+dkey1+"dkey2 "+dkey2);
 return encryptTwoKeys(str,26-dkey1,26-dkey2);   
}
public void test(){
    //FileResource fr = new FileResource();
    //String str = fr.asString();
    //String str = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
    String message = encryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy.",12,2);
    System.out.println(message);
    String messageDec = decryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy.");
    System.out.println(messageDec);
    
}
}
