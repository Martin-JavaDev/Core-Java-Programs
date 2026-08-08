import java.util.Arrays;

public class ReverseString {
//      Questions 1
//    Reverse a String without using built-in methods
    public static void main(String[] args){
        String name = "Begining";
        char[] revArray = name.toCharArray();
        for(int i=revArray.length-1; i>=0; i--){
            System.out.print(revArray[i]);
        }
    }
}
