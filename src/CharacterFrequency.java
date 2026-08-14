import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CharacterFrequency {

    public static void main(String[] args) {

        String name = "JavaProgramming";

        char[] nameArray = name.toCharArray();

        Map<Character, Integer> reMap = new LinkedHashMap<>();

        for (int i = 0; i < nameArray.length; i++) {
            Character key = nameArray[i];
            if(reMap.containsKey(key)){
                Integer value =  reMap.get(key);
                reMap.put(key, value+1);

            }else{
                reMap.put(key, 1);
            }
        }

        System.out.println(reMap);


        name.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.groupingBy(
                        e -> e,
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .forEach((key, vale)->System.out.println(key +" "+vale));
    }


}
