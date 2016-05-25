package io.stevejamison;

/**
 * Created by stevejaminson on 5/23/16.
 */
public class MyStringUtils {

    public static String arrayToString(String[] arr){
        String joined = String.join(",", arr);
        return joined;
    }

    public static String[] stringToArray(String str){
        String[] arr = str.split("\n");
        return arr;
    }

    public static String reverseCapital(String str){
        String[] arr = str.split(" ");
        for(int i = 0; i < arr.length; i++){
            char[] letter = arr[i].toCharArray();
            letter[0] = Character.toUpperCase(letter[0]);
            arr[i] = new String(letter);
        }

        String almost = String.join(" ",arr);
        char[] chars = almost.toCharArray();
        for (int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(Character.isUpperCase(c)){
                chars[i] = Character.toLowerCase(c);
            } else {
                chars[i] = Character.toUpperCase(c);
            }
        }
        return new String(chars);
    }

    public static String reverseWord(String str){
        String[] arr = str.split(" ");
        for(int i = 0; i < arr.length; i++){
            StringBuilder current = new StringBuilder();
            current.append(arr[i]);
            String revStr = current.reverse().toString();
            arr[i] = revStr;
        }
        return String.join(" ",arr);
    }

    public static String removeWhitespace(String str){
        return str.replaceAll(" ", "\n");
    }

    public static String allSubstrings(String str){
        String result = "";
        for (int i = 0; i < str.length(); i++){
            for (int j = 1; j <= str.length()-i; j++){
                result += str.substring(i,i+j) + " ";
            }
        }
        return result;
    }

}
