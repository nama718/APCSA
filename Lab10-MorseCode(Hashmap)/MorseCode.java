import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.util.Map;
import java.util.Map.Entry;
public class MorseCode
{
private final String   alphabet = "abcdefghijklmnopqrstuvwxyz1234567890 ";
private final String[] morse    = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", 
"-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "|"};
private HashMap<String, String> toText;
private HashMap<String, String> toCode;

public MorseCode()
{
    toText = new HashMap<>();
    toCode = new HashMap<>();
     char[] c = alphabet.toCharArray();
     for(int i = 0; i < morse.length; i++) {
            toText.put(morse[i], String.valueOf(c[i]));
            toCode.put(String.valueOf(c[i]), morse[i]);
      }
    
}
public String encode(String s)
{
     
     String encoded = "";
        for(int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (toCode.containsKey(c)) {
                encoded += toCode.get(c) + " ";
            } else {
                encoded += c;
            }
        }
        return encoded;
}
public String decode(String s)
{
     String[] c = s.split(" ");
     String decode = "";
        for(int i = 0; i < c.length; i++) {
            if (toText.containsKey(c[i])) {
                decode += toText.get(c[i]);
            } else {
                decode += "";
            }
        }
        return decode;
    }
}


