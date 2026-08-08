public class StringPalindrome {
//      Questions 1
//    Check if a String is a Palindrome
    public static void main(String[] args){
        String name = "APPA";

        if(name.equalsIgnoreCase(new StringBuilder(name).reverse().toString())){
            System.out.println("String is Palindrom");
        }else{
            System.out.println("String is not Palindrom");
        }
    }
}
