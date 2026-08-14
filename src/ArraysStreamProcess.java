import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysStreamProcess {
    // Arrays.stream(int[])
//         │
//         ├── Intermediate Operations
//        │      ├── filter()
//        │      ├── map()
//        │      ├── mapToObj()
//        │      ├── mapToLong()
//        │      ├── mapToDouble()
//        │      ├── distinct()
//        │      ├── sorted()
//        │      ├── skip()
//        │      ├── limit()
//        │      ├── peek()
//        │      ├── takeWhile()
//        │      └── dropWhile()
//        │
//                └── Terminal Operations
//               ├── forEach()
//               ├── forEachOrdered()
//               ├── min()
//               ├── max()
//               ├── sum()
//               ├── average()
//               ├── count()
//               ├── findFirst()
//               ├── findAny()
//               ├── anyMatch()
//               ├── allMatch()
//               ├── noneMatch()
//               ├── reduce()
//               ├── toArray()
//               ├── boxed()
//               └── summaryStatistics()
    public static void main(String[] args) {
        int[] arr1 = {10, 5, 20, 5, 30, 15, 2, 8};

        // 1. filter()
        System.out.println("--- filter() - condition match ஆகும் elements மட்டும் ---");

        Arrays.stream(arr1)
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);

        System.out.println("------");


        // 2. min()
        System.out.println("--- min() - minimum value கண்டுபிடிக்க ---");

        Arrays.stream(arr1)
                .min()
                .ifPresent(System.out::println);

        System.out.println("------");


        // 3. max()
        System.out.println("--- max() - maximum value கண்டுபிடிக்க ---");

        Arrays.stream(arr1)
                .max()
                .ifPresent(System.out::println);

        System.out.println("------");


        // 4. sum()
        System.out.println("--- sum() - அனைத்து values-ஐ கூட்ட ---");

        System.out.println(Arrays.stream(arr1).sum());

        System.out.println("------");


        // 5. average()
        System.out.println("--- average() - values-ன் average கண்டுபிடிக்க ---");

        Arrays.stream(arr1)
                .average()
                .ifPresent(System.out::println);

        System.out.println("------");


        // 6. count()
        System.out.println("--- count() - array-ல் எத்தனை elements இருக்கிறது என்று count செய்ய ---");

        System.out.println(Arrays.stream(arr1).count());

        System.out.println("------");


        // 7. distinct()
        System.out.println("--- distinct() - duplicate values-ஐ remove செய்ய ---");

        Arrays.stream(arr1)
                .distinct()
                .forEach(System.out::println);

        System.out.println("------");


        // 8. sorted()
        System.out.println("--- sorted() - values-ஐ ascending order-ல் sort செய்ய ---");

        Arrays.stream(arr1)
                .sorted()
                .forEach(System.out::println);

        System.out.println("------");


        // 9. sorted() descending
        System.out.println("--- sorted() + reverseOrder() - values-ஐ descending order-ல் sort செய்ய ---");

        Arrays.stream(arr1)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println("------");


        // 10. skip()
        System.out.println("--- skip(5) - முதல் 5 elements-ஐ skip செய்ய ---");

        Arrays.stream(arr1)
                .skip(5)
                .forEach(System.out::println);

        System.out.println("------");


        // 11. limit()
        System.out.println("--- limit(5) - முதல் 5 elements மட்டும் எடுக்க ---");

        Arrays.stream(arr1)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("------");


        // 12. map()
        System.out.println("--- map() - ஒவ்வொரு element-ஐ transform/modify செய்ய ---");

        Arrays.stream(arr1)
                .map(e -> e * 2)
                .forEach(System.out::println);

        System.out.println("------");


        // 13. mapToObj()
        System.out.println("--- mapToObj() - primitive int value-ஐ Object/Integer ஆக convert செய்ய ---");

        Arrays.stream(arr1)
                .mapToObj(e -> e * 2)
                .forEach(System.out::println);

        System.out.println("------");


        // 14. mapToLong()
        System.out.println("--- mapToLong() - int values-ஐ long values ஆக convert செய்ய ---");

        Arrays.stream(arr1)
                .mapToLong(e -> e * 2L)
                .forEach(System.out::println);

        System.out.println("------");


        // 15. mapToDouble()
        System.out.println("--- mapToDouble() - int values-ஐ double values ஆக convert செய்ய ---");

        Arrays.stream(arr1)
                .mapToDouble(e -> e * 2.0)
                .forEach(System.out::println);

        System.out.println("------");


        // 16. findFirst()
        System.out.println("--- findFirst() - condition match ஆகும் முதல் element-ஐ எடுக்க ---");

        Arrays.stream(arr1)
                .filter(e -> e > 10)
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("------");


        // 17. findAny()
        System.out.println("--- findAny() - condition match ஆகும் ஏதாவது ஒரு element-ஐ எடுக்க ---");

        Arrays.stream(arr1)
                .filter(e -> e > 10)
                .findAny()
                .ifPresent(System.out::println);

        System.out.println("------");


        // 18. anyMatch()
        System.out.println("--- anyMatch() - குறைந்தது ஒரு element condition satisfy செய்கிறதா என்று check செய்ய ---");

        System.out.println(
                Arrays.stream(arr1)
                        .anyMatch(e -> e > 25)
        );

        System.out.println("------");


        // 19. allMatch()
        System.out.println("--- allMatch() - அனைத்து elements-ம் condition satisfy செய்கிறதா என்று check செய்ய ---");

        System.out.println(
                Arrays.stream(arr1)
                        .allMatch(e -> e > 0)
        );

        System.out.println("------");


        // 20. noneMatch()
        System.out.println("--- noneMatch() - எந்த element-மும் condition satisfy செய்யவில்லையா என்று check செய்ய ---");

        System.out.println(
                Arrays.stream(arr1)
                        .noneMatch(e -> e < 0)
        );

        System.out.println("------");


        // 21. reduce()
        System.out.println("--- reduce() - multiple values-ஐ single value ஆக combine செய்ய ---");

        int sum = Arrays.stream(arr1)
                .reduce(0, (a, b) -> a + b);

        System.out.println(sum);

        System.out.println("------");


        // 22. reduce() multiplication
        System.out.println("--- reduce() - அனைத்து values-ஐ multiply செய்து single result பெற ---");

        int multiplication = Arrays.stream(arr1)
                .reduce(1, (a, b) -> a * b);

        System.out.println(multiplication);

        System.out.println("------");


        // 23. boxed()
        System.out.println("--- boxed() - IntStream-ஐ Stream<Integer> ஆக convert செய்ய ---");

        Arrays.stream(arr1)
                .boxed()
                .forEach(System.out::println);

        System.out.println("------");


        // 24. toArray()
        System.out.println("--- toArray() - Stream result-ஐ int[] array ஆக convert செய்ய ---");

        int[] result = Arrays.stream(arr1)
                .filter(e -> e > 10)
                .toArray();

        Arrays.stream(result)
                .forEach(System.out::println);

        System.out.println("------");


        // 25. peek()
        System.out.println("--- peek() - stream-ன் intermediate values-ஐ பார்க்க/debug செய்ய ---");

        Arrays.stream(arr1)
                .filter(e -> e > 10)
                .peek(e -> System.out.println("After filter: " + e))
                .map(e -> e * 2)
                .forEach(System.out::println);

        System.out.println("------");


        // 26. summaryStatistics()
        System.out.println("--- summaryStatistics() - count, sum, min, max, average அனைத்தையும் ஒரே நேரத்தில் பெற ---");

        IntSummaryStatistics stats =
                Arrays.stream(arr1)
                        .summaryStatistics();

        System.out.println("Count   : " + stats.getCount());
        System.out.println("Sum     : " + stats.getSum());
        System.out.println("Min     : " + stats.getMin());
        System.out.println("Max     : " + stats.getMax());
        System.out.println("Average : " + stats.getAverage());

        System.out.println("------");


        // 27. takeWhile()
        int[] arr2 = {2, 4, 6, 8, 3, 10};

        System.out.println("--- takeWhile() - condition true ஆகும் வரை elements-ஐ எடுத்துக்கொள்ள ---");

        Arrays.stream(arr2)
                .takeWhile(e -> e % 2 == 0)
                .forEach(System.out::println);

        System.out.println("------");


        // 28. dropWhile()
        System.out.println("--- dropWhile() - condition true ஆகும் elements-ஐ ஆரம்பத்தில் skip செய்ய ---");

        Arrays.stream(arr2)
                .dropWhile(e -> e % 2 == 0)
                .forEach(System.out::println);

        System.out.println("------");


        // 29. asLongStream()
        System.out.println("--- asLongStream() - IntStream-ஐ LongStream ஆக convert செய்ய ---");

        Arrays.stream(arr1)
                .asLongStream()
                .forEach(System.out::println);

        System.out.println("------");


        // 30. asDoubleStream()
        System.out.println("--- asDoubleStream() - IntStream-ஐ DoubleStream ஆக convert செய்ய ---");

        Arrays.stream(arr1)
                .asDoubleStream()
                .forEach(System.out::println);

        System.out.println("------");


        // 31. parallel()
        System.out.println("--- parallel() - elements-ஐ parallel-ஆ process செய்ய ---");

        Arrays.stream(arr1)
                .parallel()
                .forEach(System.out::println);

        System.out.println("------");


        // 32. forEachOrdered()
        System.out.println("--- forEachOrdered() - parallel processing-ல் original order maintain செய்ய ---");

        Arrays.stream(arr1)
                .parallel()
                .forEachOrdered(System.out::println);

        System.out.println("------");


        // 33. IntStream.range()
        System.out.println("--- IntStream.range() - array index-ஐ stream ஆக பயன்படுத்த ---");

        IntStream.range(0, arr1.length)
                .forEach(i ->
                        System.out.println(
                                "Index = " + i + ", Value = " + arr1[i]
                        )
                );

        System.out.println("------");


        // 34. Array to List
        System.out.println("--- boxed() + toList() - int[] array-ஐ List<Integer> ஆக convert செய்ய ---");

        List<Integer> list = Arrays.stream(arr1)
                .boxed()
                .toList();

        System.out.println(list);

        System.out.println("------");


        // 35. Array to Set
        System.out.println("--- boxed() + collect(toSet()) - int[] array-ஐ Set<Integer> ஆக convert செய்து duplicates remove செய்ய ---");

        Set<Integer> set = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.toSet());

        System.out.println(set);

        System.out.println("------");


        // 36. Even numbers to List
        System.out.println("--- filter() + boxed() + toList() - even numbers-ஐ List ஆக convert செய்ய ---");

        List<Integer> evenNumbers = Arrays.stream(arr1)
                .filter(e -> e % 2 == 0)
                .boxed()
                .toList();

        System.out.println(evenNumbers);

        System.out.println("------");


        // 37. Square
        System.out.println("--- map() - ஒவ்வொரு number-ன் square value கண்டுபிடிக்க ---");

        Arrays.stream(arr1)
                .map(e -> e * e)
                .forEach(System.out::println);

        System.out.println("------");


        // 38. Filter + Map
        System.out.println("--- filter() + map() - condition match values-ஐ filter செய்து transform செய்ய ---");

        Arrays.stream(arr1)
                .filter(e -> e > 10)
                .map(e -> e * 2)
                .forEach(System.out::println);

        System.out.println("------");


        // 39. Filter + Sorted
        System.out.println("--- filter() + sorted() - even numbers-ஐ filter செய்து ascending order-ல் sort செய்ய ---");

        Arrays.stream(arr1)
                .filter(e -> e % 2 == 0)
                .sorted()
                .forEach(System.out::println);

        System.out.println("------");


        // 40. Duplicate values
        System.out.println("--- filter() + Set - duplicate values மட்டும் கண்டுபிடிக்க ---");

        Set<Integer> seen = new HashSet<>();

        Arrays.stream(arr1)
                .filter(e -> !seen.add(e))
                .forEach(System.out::println);

        System.out.println("------");


        // 41. Second largest
        System.out.println("--- distinct() + sorted() + skip() - second largest value கண்டுபிடிக்க ---");

        int secondLargest = Arrays.stream(arr1)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();

        System.out.println(secondLargest);

        System.out.println("------");


        // 42. Second smallest
        System.out.println("--- distinct() + sorted() + skip() - second smallest value கண்டுபிடிக்க ---");

        int secondSmallest = Arrays.stream(arr1)
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElseThrow();

        System.out.println(secondSmallest);

        System.out.println("------");


        // 43. Positive count
        System.out.println("--- filter() + count() - positive numbers count கண்டுபிடிக்க ---");

        long positiveCount = Arrays.stream(arr1)
                .filter(e -> e > 0)
                .count();

        System.out.println(positiveCount);

        System.out.println("------");


        // 44. Even sum
        System.out.println("--- filter() + sum() - even numbers-ன் sum கண்டுபிடிக்க ---");

        int evenSum = Arrays.stream(arr1)
                .filter(e -> e % 2 == 0)
                .sum();

        System.out.println(evenSum);

        System.out.println("------");


        // 45. Odd sum
        System.out.println("--- filter() + sum() - odd numbers-ன் sum கண்டுபிடிக்க ---");

        int oddSum = Arrays.stream(arr1)
                .filter(e -> e % 2 != 0)
                .sum();

        System.out.println(oddSum);

        System.out.println("------");


        // 46. Maximum even
        System.out.println("--- filter() + max() - maximum even number கண்டுபிடிக்க ---");

        Arrays.stream(arr1)
                .filter(e -> e % 2 == 0)
                .max()
                .ifPresent(System.out::println);

        System.out.println("------");


        // 47. Minimum odd
        System.out.println("--- filter() + min() - minimum odd number கண்டுபிடிக்க ---");

        Arrays.stream(arr1)
                .filter(e -> e % 2 != 0)
                .min()
                .ifPresent(System.out::println);

        System.out.println("------");
    }
}
