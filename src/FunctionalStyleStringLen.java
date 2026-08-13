import java.util.Arrays;
import java.util.function.Function;

public class FunctionalStyleStringLen {

    public static void main(String[] args) {
        String name = "MartinRaaj";
        Function<String, Integer> len = String::length;
        int var = len.apply(name);
        System.out.println(var);
    }
}
