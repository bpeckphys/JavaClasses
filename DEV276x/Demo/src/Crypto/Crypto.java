/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;
import java.util.*;

/**
 *
 * @author bpeck
 */
public class Crypto {
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        // Prompt user for the text to encrypt
        System.out.print("Please enter text to encrypt: ");
        String text = input.nextLine();
        
        // Prompt user for the key to encrypt with
        System.out.print("Please enter the numeric shift key: ");
        Integer key = input.nextInt();
        
        // Prompt user for the group size to encrypt with
        System.out.print("Please enter the group size: ");
        Integer groupSize = input.nextInt();
        
        String cypher = encryptString(text,key,groupSize);
        System.out.println("The encrypted text is: " + cypher);
    }
    
    public static String encryptString(String original, Integer key, Integer groupSize){
        String normalized = normalizeText(original);
        String obified = obify(normalized);
        String caesarfied = caesarify(obified, key);
        String groupified = groupify(caesarfied, groupSize);
        
        return groupified;
    }
    
    public static String normalizeText(String original){
        // Remove punctuation (.,:;'"!?())
        String normalized = original.replace(" ", "");
        normalized = normalized.replace(".", "");
        normalized = normalized.replace(",", "");
        normalized = normalized.replace(":", "");
        normalized = normalized.replace(":", "");
        normalized = normalized.replace("'", "");
        normalized = normalized.replace("\"", "");
        normalized = normalized.replace("!", "");
        normalized = normalized.replace("?", "");
        normalized = normalized.replace("(", "");
        normalized = normalized.replace(")", "");
        
        // Turn all lowercase to uppercase
        normalized = normalized.toUpperCase();
        
        //System.out.println(normalized);
        
        return normalized;
    }
    
    public static String obify(String original){
        String obifiedText = original;
        obifiedText = obifiedText.replace("O", "OBO");
        obifiedText = obifiedText.replace("A", "OBA");
        obifiedText = obifiedText.replace("E", "OBE");
        obifiedText = obifiedText.replace("I", "OBI");
        obifiedText = obifiedText.replace("U", "OBU");
        obifiedText = obifiedText.replace("Y", "OBY");
        //System.out.println(obifiedText);
        return obifiedText;
    }
    
    public static String caesarify(String normalized, Integer key){
        Integer currCharNum = 0;
        String encrypted = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetShifted = shiftAlphabet(key);
        //System.out.println(alphabetShifted);
        for(; currCharNum < normalized.length(); ++ currCharNum){
            Integer alphNum = alphabet.indexOf(normalized.charAt(currCharNum));
            encrypted = encrypted + alphabetShifted.charAt(alphNum);
            //System.out.println(normalized.charAt(currCharNum) + "-->" + alphNum + "-->" + alphabetShifted.charAt(alphNum));
        }
        //System.out.println(encrypted);
        return encrypted;
    }
    
    public static String groupify(String normalized,Integer groupLen){
        Integer padLen = normalized.length() % groupLen;
        while(padLen != 0){
            normalized = normalized + "x";
            padLen = normalized.length() % groupLen;
        }
        String groupified = "";
        //System.out.println(groupified);
        Integer currCharNum = 0;
        for(; currCharNum < normalized.length(); currCharNum += groupLen){
            //System.out.print(groupified + "-->");
            groupified = groupified + normalized.substring(currCharNum,currCharNum + groupLen) + " ";
            //System.out.println(groupified);
        }
        
        return groupified;
    }
    
    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }
    
}
