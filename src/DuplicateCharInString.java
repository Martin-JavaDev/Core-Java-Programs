import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateCharInString {

    //    Find duplicate characters in a String
    public static void main(String[] args) {

        String name = "javavgtthyye";
        char[] nameArr = name.toCharArray();
        Set<Character> dupChar = new HashSet<>();
        for (int i = 0; i < name.length(); i++) {
            if (!dupChar.add(nameArr[i])) {
                System.out.println(nameArr[i]);
            }
        }


    }
}
