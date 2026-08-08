public class SwapNumbers {

    //    Swap two numbers without a third variable
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        if (a < b) {
            b = a;
            a = a + b;
        } else {
            a = b;
            b = a + b;
        }
        System.out.println("New Value A:" + a + "   New Value B:" + b);
    }
}
