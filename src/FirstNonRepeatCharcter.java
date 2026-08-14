import java.util.*;
import java.util.stream.Collectors;

public class FirstNonRepeatCharcter {

    //    Find the first non-repeated character in a String
    public static void main(String[] args) {
        String name = "avaProgramming";
        collectionWay(name);
        System.out.println("=================");
        coreWay(name);
    }

    private static void coreWay(String name) {
        //LinkedHashmap la podanum next for loop la check pannu ethu first 1 mnu
        char[] charMap = name.toCharArray();
        LinkedHashMap<Character, Integer> mapVar = new LinkedHashMap<>();
        for (int i = 0; i < charMap.length; i++) {

            if(mapVar.containsKey(charMap[i])){
                Integer count = mapVar.get(charMap[i]);
                mapVar.put(charMap[i], count+1);
            }else{
                mapVar.put(charMap[i], 1);
            }
        }
        System.out.println(mapVar);
        Iterator<Map.Entry<Character, Integer>> iterator = mapVar.entrySet().iterator();
        while (iterator.hasNext()){
            Character key = iterator.next().getKey();
            if(mapVar.get(key) == 1){
                System.out.println(key);
                break;
            }
        }

    }

    private static void collectionWay(String name) {
        name.chars().mapToObj((e) -> (char) e).collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().
                filter((e) -> e.getValue() == 1).
                max(Map.Entry.comparingByValue()).stream().findFirst().ifPresent((e)-> System.out.println(e.getKey()));
    }
}
