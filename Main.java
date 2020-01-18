package com.company;

import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String taxinum;
        Scanner scanner= new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int counter=n;
        int kolvo=0;
        int v=0;
        Pattern pt=Pattern.compile ("([1-7](TAX|TBX))|7TEX");
        Pattern pt2= Pattern.compile("[0-9]{4}");
        Pattern pt3=Pattern.compile("(^\\s)|(\\s{2,})|(\\s$)");
        while (counter!=0){
            v=0;
            taxinum=scanner.nextLine();
            Matcher matcher3= pt3.matcher(taxinum);
            if(matcher3.find())
            {
                v=1;
            }
            StringTokenizer st= new StringTokenizer(taxinum, " ");
            while (st.hasMoreTokens())
            {
                Matcher matcher= pt.matcher(st.nextToken());
                if(!matcher.matches()||v==1){
                    break;
                }
                else {
                    if(!st.hasMoreTokens())
                        break;
                    String zero=st.nextToken();
                    Matcher matcher2= pt2.matcher(zero);
                    if (!matcher2.matches())
                        break;
                    else if(zero.equals("0000"))
                    {
                        break;
                    }
            }

                if(st.hasMoreTokens())
                    break;
                kolvo++;
            }
            counter--;

        }
        System.out.println(kolvo);
    }
}
