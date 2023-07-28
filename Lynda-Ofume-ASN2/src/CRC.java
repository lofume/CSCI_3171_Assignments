/*
* LYNDA OFUME
* B00738568
* DUE DATE: FEB. 26, 2021
* CSCI 3171
* THIS PROGRAM RUNS THE CRC CHECK USING MODULO 2 ARITHMETIC IN ORDER TO TAKE IN
*   THE ORIGINAL MESSAGE AND CONVERT IT TO THE CRC CODEWORD.
*/

import java.util.*;
import java.io.*;
public class CRC {
    //method that uses modulo 2 arithmetic in order to commence conversion of txt file
    static String XOR (String bit1, String bit2 ){
        //creating arguments for polynomial
        int val = bit2.length();
        String found = bit2.substring(0, val);
        String leftOver= "";

        //while the substring of the polynomial length is greater than 0,
        //the program checks to see if the value at the given is equal
        //if so then it adds a "0" and otherwise a "1" and then it loops through
        //till all characters are dealt with.
        int l=0;
        while(found.length() > l){
            if(found.charAt(l)== bit2.charAt(l)){
                leftOver += "0";
            }
            else{
                leftOver += "1";
            }
            l++;
        }

        //while the polynomial length is greater than the length of the original code,
        //the program checks to see if the value at the given is equal to '0'
        //if so then the remainder is the string value of the char at bit1 length
        //and irritates at the length of bit2
        while(val < bit1.length()){
            if(leftOver.charAt(0) == '0'){
                leftOver = leftOver.substring(1, leftOver.length());
                leftOver = leftOver + String.valueOf(bit1.charAt(val));
                val++;
            }
            val++;
        }

        //while the substring of the polynomial length is greater than bit2 length,
        //the program checks to see if the value at the given is equal
        //if so then it adds a "1" and otherwise a "0" and then it loops through
        //till all characters are dealt with.
        found= leftOver;
        leftOver= "";
        int k=0;
        while(k<bit2.length()){
            if(found.charAt(k) == bit2.charAt(k)){
                leftOver+="1";
            }
            else{
                leftOver +="0";
            }
            k++;
        }
        //program returns the subsequent iteration
        return leftOver.substring(1, leftOver.length());
    }
    
    //demo method
    public static void main(String args[]) throws IOException {


        //file created and buffer made in order to read in txt file
        File CRCode = new File("src/MessageAndPolynomial.txt");
        BufferedReader br = new BufferedReader(new FileReader(CRCode));

        //m0= original code, m1= polynomial
        String m0 = br.readLine();
        String m1 = br.readLine();

        //print statement to display the info in the txt file
        System.out.println("The original message and the CRC polynomial are:");
        System.out.println(m0);
        System.out.println(m1);

        //give space in displayed message
        System.out.println();

        //This block of code calls the method below and prints the responding CRC codeword
        String n = m0;
        while (n.length() < (m0.length() + m1.length() - 1)) {
            n = n + "0";
            n = m0 + XOR(n,m1);
            System.out.println("The CRC codeword to be sent to the receiver is: " + n);
            return;
        }

        //boundaries for the original and the polynomial length limit
        if(m0.length()>12 || m0.length()<2){
            System.out.println("ERROR: OUT OF BOUNDS");
            return;
        }
        if(m1.length()>6 || m1.length()<2){
            System.out.println("ERROR: OUT OF BOUNDS");
        }
    }
}
