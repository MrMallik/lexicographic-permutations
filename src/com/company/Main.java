package com.company;

import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileWriter;


public class Main {

    public static void main(String[] args) throws IOException
    {
	    Scanner stdin = new Scanner(System.in);
	    FileWriter fw = new FileWriter("permutation.txt");
	    String text;

	    System.out.print("Enter text to generate permutation : ");
	    text = stdin.nextLine();

	    int i,j;

	    char myText[] = text.toCharArray();
	    Arrays.sort(myText);
	    char myTextrev[] = new char [myText.length];
        for(i = 0, j = myText.length - 1; j!=-1; i++, j--)
            myTextrev[i] = myText[j];


        i = j = text.length() - 1;



	    while(true){

            for(char x : myText)
                fw.write(x);
            fw.write('\n');

            if(Arrays.equals(myText, myTextrev))
                break;

            //find highest i such that s[i-1] < s[i]
            while(i > 0){
                if(myText[i-1] < myText[i])
                    break;
                i--;
            }

            //find j such that j>=i AND s[j] > s[i-1]
            while(j > 0){
                if(myText[j] > myText[i-1])
                    break;
                j--;
            }

            //swap s[j] and s[i-1]
            char temp = myText[i-1];
            myText[i-1] = myText[j];
            myText[j] = temp;

            //Reverse substring starting from i
            int hi = myText.length - 1;
            for(int lo = i; lo <= hi;  lo++, hi--){
                temp = myText[lo];
                myText[lo] = myText[hi];
                myText[hi] = temp;
            }

            //reset indices
            i = j = myText.length - 1;
        }
	    stdin.close();
	    fw.close();
    }
}
