package com.example.numberconverterpluscalculator;

public class Checker {
    public static boolean isBinary(String s){
        char []ch = s.toCharArray();
        int count=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='1'||ch[i]=='0')continue;
            else count++;
        }
        return count==0;
    }//end of binary checker
    public static boolean isQuinary(String s){
        char []ch = s.toCharArray();
        int count=0;
        for(int i=0;i<ch.length;i++){
            int j=Character.getNumericValue(ch[i]);
            System.out.println("Numeric Value "+j);
            if(j<=4)continue;
            count+=1;
        }
        return count==0;
    }//end of binary checker

    public static boolean isOctal(String s){
        char []ch = s.toCharArray();
        int count=0;
        for(int i=0;i<ch.length;i++){
            int j=Character.getNumericValue(ch[i]);
            System.out.println("Numeric Value "+j);
            if(j<=7)continue;
            count+=1;
        }
        return count==0;
    }//end of binary checker
}
