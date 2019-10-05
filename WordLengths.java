
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
public class WordLengths {
public void countWordLengths(FileResource fr,int counts[]){
        String str[]=new String[10000000];
        int index=0;
        for(String s: fr.words()){
            int countf=0,counte=0,count=0;
                if(!Character.isLetter(s.charAt(0)))
                countf+=1;
                if(!Character.isLetter(s.charAt(s.length()-1)))
                counte+=1;
                count=countf+counte;
            if(countf==1&&count==1){
                s=s.substring(1,s.length());}
            else if(counte==1&&count==1){
                s=s.substring(0,s.length()-1);}
            else if(count==2){
                System.out.println(s);
                //s=s.substring(1,s.length()-1);
            }
               str[index]=s;
               index+=1;
                counts[s.length()]+=1;
            }
        for(int k=0;k<counts.length;k++){
            if(counts[k]!=0)
            System.out.print("\n"+counts[k]+" words of length "+k+":");
            for(int i=0;i<index;i++){
            if(str[i].length()==k)
            System.out.print(str[i]+" ");}
        }
    }
    public int indexOfMax(int values[]){
        int max=values[0],index=-1;
        for(int i=0;i<values.length;i++){
            if(max<values[i])
            max=values[i];
        }
        for(int i=0;i<values.length;i++){
            if(max==values[i])
            index=i;
    }
    return index;
}
    public void test()
    {
        FileResource fr = new FileResource();
        int counts[]=new int[30];
        countWordLengths(fr,counts);
        System.out.println("\n"+indexOfMax(counts));
    }
}