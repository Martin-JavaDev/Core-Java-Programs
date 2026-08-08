public class Factorial {

//    Find the factorial of a number
    public static void main(String[] args){
        int num = 5;
        int total = num;
        for (int i = num-1; i>0; i--){
            total = total * i;
        }
        System.out.println("Ans:"+total);

    }
}
