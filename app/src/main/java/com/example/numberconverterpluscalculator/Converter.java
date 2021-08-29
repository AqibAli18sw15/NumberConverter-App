package com.example.numberconverterpluscalculator;

public class Converter {
    private static long[] arr;
    public static String decToBin(String s){
        long n = Long.parseLong(s);
        long m=n;
        long num = m;
        int r=0;
        while(n>=1){
            n/=2;
            r+=1;
        }
        arr = new long[r];
        for (int i=0;i<r ;i++ ) {
            arr[i]=m%2;
            m/=2;
        }
        return (binary(arr));
    } // end of dectoBin
    public static String binary(long[] ar){
        String s="";
        for (int i=(ar.length-1);i>=0 ;i-- ) {
            s+=ar[i]+"";
        }
        return s;

    }// end of method this method returns string which is binary numbers
    public static String decToQuin(String s){
        long n = Long.parseLong(s);
        long m=n;
        long num = m;
        int r=0;
        while(n>=1){
            n/=5;
            r+=1;
        }
        arr = new long[r];
        for (int i=0;i<r ;i++ ) {
            arr[i]=m%5;
            m/=5;
        }
        return binary(arr);
    } // end of decToQuinary Method
    public static String decToOctal(String s){
        long n = Long.parseLong(s);
        long m=n;
        long num = m;
        int r=0;
        while(n>=1){
            n/=8;
            r+=1;
        }
        arr = new long[r];
        for (int i=0;i<r ;i++ ) {
            arr[i]=m%8;
            m/=8;
        }
        return binary(arr);
    } //end of dec to Octal
    public static String binToDec(String s){
        if(!Checker.isBinary(s))return "Please insert only binary number";
        else {

            char[] ch = s.toCharArray();
            int pow=0;
            long dec=0;

            for(int i=ch.length-1;i>=0;i--){
                if(ch[i]=='0')dec+=0;
                else {dec+=1*Math.pow(2,pow);}

                pow+=1;
            }

            return ""+dec;
        }

    }//end of bintoDec method
    public static String quinToDec(String s){
        if(!Checker.isQuinary(s))return "Insert only quinary numbers";
        else{

            char[] ch = s.toCharArray();
            int pow=0;
            long dec=0;

            for(int i=ch.length-1;i>=0;i--){
                dec+=Character.getNumericValue(ch[i])*Math.pow(5,pow);

                pow+=1;
            }

            return ""+dec;

        }
    }//end of Quinary to decimal
    public static String octToDec(String s){
    if(!Checker.isOctal(s))return "Insert only Octal numbers";
    else{

        char[] ch = s.toCharArray();
        int pow=0;
        long dec=0;

        for(int i=ch.length-1;i>=0;i--){
            dec+=Character.getNumericValue(ch[i])*Math.pow(8,pow);

            pow+=1;
        }

        return ""+dec;
    }

    }//end of oct to dec
    public static String binToQuin(String s){
        if(!Checker.isBinary(s))return "Insert Only Binary Numbers";
        else{
        String dec = binToDec(s);
        return decToQuin(dec);}
    }//end of bintoQuin

    public  static String binToOctal(String s){
        if(!Checker.isBinary(s))return "Insert Only Binary Numbers";
        else{
        String dec = binToDec(s);
        return decToOctal(dec);}
    }//end of Bin to Octal
    public  static String quinToBinary(String s){
        if(!Checker.isQuinary(s))return "Insert Only Quinary Numbers";
        else{
        String dec = quinToDec(s);
        return decToBin(dec);}
    }//end of Bin to Octal
    public  static String quinToOctal(String s){
        if(!Checker.isQuinary(s))return "Insert Only Quinary Numbers";
        else{
        String dec = quinToDec(s);
        return decToOctal(dec);}
    }//end of Bin to Octal

    public  static String octToBin(String s){
        if(!Checker.isOctal(s))return "Insert Only Octal Numbers";
        else{
        String dec = octToDec(s);
        return decToBin(dec);}
    }
    public static String octToQuin(String s){
        if(!Checker.isOctal(s))return "Insert Only Octal Numbers";
        else{
        String dec = octToDec(s);
        return decToQuin(dec);}
    }

} //end of class
