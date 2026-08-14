import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamCollectorsUsage {

    // Stream
//   │
//   └── Terminal Operation
//          └── collect()
//                 │
//                 └── Collectors
//                       │
//                       ├── toList()
//                       ├── toSet()
//                       ├── toMap()
//                       ├── joining()
//                       │
//                       ├── groupingBy()
//                       │      ├── groupingBy(..., counting())
//                       │      ├── groupingBy(..., summingInt())
//                       │      ├── groupingBy(..., averagingInt())
//                       │      └── groupingBy(..., mapping())
//                       │
//                       ├── partitioningBy()
//                       │
//                       ├── counting()
//                       ├── summingInt()
//                       ├── summingLong()
//                       ├── summingDouble()
//                       │
//                       ├── averagingInt()
//                       ├── averagingLong()
//                       ├── averagingDouble()
//                       │
//                       ├── minBy()
//                       ├── maxBy()
//                       │
//                       ├── summarizingInt()
//                       ├── summarizingLong()
//                       ├── summarizingDouble()
//                       │
//                       └── mapping()

        public static void main(String[] args) {

            List<Integer> numbers =
                    Arrays.asList(10, 20, 10, 30, 20, 40, 50);

            List<String> names =
                    Arrays.asList("Martin", "John", "David", "Sam");

            // =========================================================
            // 1. toList()
            // =========================================================

            System.out.println("--- toList() - Stream result-ஐ List ஆக convert செய்ய ---");

            List<Integer> listResult = numbers.stream()
                    .filter(e -> e > 20)
                    .collect(Collectors.toList());

            System.out.println(listResult);

            System.out.println("------");


            // =========================================================
            // 2. toSet()
            // =========================================================

            System.out.println("--- toSet() - Stream result-ஐ Set ஆக convert செய்து duplicates remove செய்ய ---");

            Set<Integer> setResult = numbers.stream()
                    .collect(Collectors.toSet());

            System.out.println(setResult);

            System.out.println("------");


            // =========================================================
            // 3. toMap()
            // =========================================================

            System.out.println("--- toMap() - Stream elements-ஐ Key-Value Map ஆக convert செய்ய ---");

            Map<String, Integer> mapResult = names.stream()
                    .collect(Collectors.toMap(
                            Function.identity(),
                            String::length
                    ));

            System.out.println(mapResult);

            System.out.println("------");


            // =========================================================
            // 4. joining()
            // =========================================================

            System.out.println("--- joining() - String elements-ஐ ஒன்றாக join செய்ய ---");

            String joined = names.stream()
                    .collect(Collectors.joining(", "));

            System.out.println(joined);

            System.out.println("------");


            // =========================================================
            // 5. joining() - prefix + suffix
            // =========================================================

            System.out.println("--- joining() - separator + prefix + suffix பயன்படுத்தி join செய்ய ---");

            String joinedWithBracket = names.stream()
                    .collect(Collectors.joining(", ", "[", "]"));

            System.out.println(joinedWithBracket);

            System.out.println("------");


            // =========================================================
            // 6. groupingBy()
            // =========================================================

            System.out.println("--- groupingBy() - ஒரு property அடிப்படையில் data-வை group செய்ய ---");

            Map<Integer, List<String>> groupedByLength = names.stream()
                    .collect(Collectors.groupingBy(
                            String::length
                    ));

            System.out.println(groupedByLength);

            System.out.println("------");


            // =========================================================
            // 7. groupingBy() + counting()
            // =========================================================

            System.out.println("--- groupingBy() + counting() - ஒவ்வொரு group-ல் எத்தனை elements என்று count செய்ய ---");

            Map<Integer, Long> countByLength = names.stream()
                    .collect(Collectors.groupingBy(
                            String::length,
                            Collectors.counting()
                    ));

            System.out.println(countByLength);

            System.out.println("------");


            // =========================================================
            // 8. partitioningBy()
            // =========================================================

            System.out.println("--- partitioningBy() - condition அடிப்படையில் true/false groups உருவாக்க ---");

            Map<Boolean, List<Integer>> partitioned = numbers.stream()
                    .collect(Collectors.partitioningBy(
                            e -> e % 2 == 0
                    ));

            System.out.println(partitioned);

            System.out.println("------");


            // =========================================================
            // 9. counting()
            // =========================================================

            System.out.println("--- counting() - Stream elements count செய்ய ---");

            Long count = numbers.stream()
                    .collect(Collectors.counting());

            System.out.println(count);

            System.out.println("------");


            // =========================================================
            // 10. summingInt()
            // =========================================================

            System.out.println("--- summingInt() - integer values-ன் sum கண்டுபிடிக்க ---");

            Integer sum = numbers.stream()
                    .collect(Collectors.summingInt(Integer::intValue));

            System.out.println(sum);

            System.out.println("------");


            // =========================================================
            // 11. averagingInt()
            // =========================================================

            System.out.println("--- averagingInt() - integer values-ன் average கண்டுபிடிக்க ---");

            Double average = numbers.stream()
                    .collect(Collectors.averagingInt(Integer::intValue));

            System.out.println(average);

            System.out.println("------");


            // =========================================================
            // 12. minBy()
            // =========================================================

            System.out.println("--- minBy() - minimum element கண்டுபிடிக்க ---");

            Optional<Integer> minimum = numbers.stream()
                    .collect(Collectors.minBy(
                            Comparator.naturalOrder()
                    ));

            minimum.ifPresent(System.out::println);

            System.out.println("------");


            // =========================================================
            // 13. maxBy()
            // =========================================================

            System.out.println("--- maxBy() - maximum element கண்டுபிடிக்க ---");

            Optional<Integer> maximum = numbers.stream()
                    .collect(Collectors.maxBy(
                            Comparator.naturalOrder()
                    ));

            maximum.ifPresent(System.out::println);

            System.out.println("------");


            // =========================================================
            // 14. summarizingInt()
            // =========================================================

            System.out.println("--- summarizingInt() - count, sum, min, max, average அனைத்தையும் ஒரே நேரத்தில் பெற ---");

            IntSummaryStatistics statistics = numbers.stream()
                    .collect(Collectors.summarizingInt(
                            Integer::intValue
                    ));

            System.out.println("Count   : " + statistics.getCount());
            System.out.println("Sum     : " + statistics.getSum());
            System.out.println("Min     : " + statistics.getMin());
            System.out.println("Max     : " + statistics.getMax());
            System.out.println("Average : " + statistics.getAverage());

            System.out.println("------");


            // =========================================================
            // 15. mapping()
            // =========================================================

            System.out.println("--- mapping() - group செய்த data-வில் specific field மட்டும் collect செய்ய ---");

            Map<Integer, List<String>> namesByLength = names.stream()
                    .collect(Collectors.groupingBy(
                            String::length,
                            Collectors.mapping(
                                    String::toUpperCase,
                                    Collectors.toList()
                            )
                    ));

            System.out.println(namesByLength);

            System.out.println("------");
        }
}
