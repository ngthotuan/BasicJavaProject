package Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) {
        // from primitive

//        IntStream.range(1,7).forEach(value -> System.out.printf("%5d", value));

        // from data structure

//        String[] languages = { "Java", "C#", "C++", "PHP", "Javascript" };
//        // Get Stream using the Arrays.stream
//        Arrays.stream(languages).forEach(value -> System.out.printf("%s ", value));
//        // Get Stream using the Stream.of
//        Stream.of(languages).forEach(value -> System.out.printf("%s ", value));

//        List<String> items = new ArrayList<>();
//        items.add("Java");
//        items.add("C#");
//        items.add("C++");
//        items.add("PHP");
//        items.add("Javascript");
//        items.stream().forEach(System.out::println);

//        Stream<String> stream = Stream.generate(() -> "gpcoder").limit(3);
//        String[] testStrArr = stream.toArray(String[]::new);
//        System.out.println(Arrays.toString(testStrArr)); // [gpcoder, gpcoder, gpcoder]

//        Stream<Long> iterateNumbers = Stream.iterate(1L, n -> n + 1).limit(5);
//        iterateNumbers.forEach(System.out::print); // 12345

        //stream to data

//        List<String> languages = Stream.of("Java", "C#", "C++", "PHP", "Javascript").collect(Collectors.toList());
//        String[] languagesArr = Stream.of("Java", "C#", "C++", "PHP", "Javascript").toArray(String[]::new);
//        System.out.println(languages);
//        System.out.println(Arrays.toString(languagesArr));

        // filter

//        Stream.iterate(1, count -> count + 1) //
//                .filter(number -> number % 3 == 0) //
//                .limit(6) //
//                .forEach(System.out::println);

        // skip, limit

//        List<String> data = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
//        data.stream() //
//                .skip(1) //
//                .limit(3) //
//                .forEach(System.out::print); // C#C++PHP

        // map

//        List<String> data = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
//        data.stream() //
//                .map(String::toUpperCase) // convert each element to upper case
//                .forEach(System.out::println);

        //sorted

//        List<String> data = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
//        // sorted according to natural order
//        data.stream() //
//                .sorted() //
//                .forEach(System.out::println);
//        // sorted according to the provided Comparator
//        data.stream() //
//                .sorted((s1, s2) -> s1.length() - s2.length()) //
//                .forEach(System.out::println);

        // anyMatch, allMatch, noneMatch

//        List<String> data = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
//        boolean anyMatch = data.stream().anyMatch(s -> s.equalsIgnoreCase("Java"));
//        System.out.println(anyMatch);

        //count

//        List<Integer> data = Arrays.asList(2, 3, 5, 4, 6);
//        long count = data.stream().filter(n -> n % 3 == 0).count();
//        System.out.println(count);

        // min, max

//        Integer []numbers = {1, 8, 3, 4, 5, 7, 9, 6};
//        // Find max, min with Array ====================
//        // Max = 9
//        Integer maxNumber = Stream.of(numbers).max(Integer::compare).get();
//        System.out.println(maxNumber);
//        // Min = 1
//        Integer minNumber = Stream.of(numbers)
//                .min(Comparator.comparing(Integer::valueOf))
//                .get();
//        System.out.println(minNumber);
//
//        // Find max, min with Collection ====================
//        List<Integer> listOfIntegers = Arrays.asList(numbers);
//        // Max = 9
//        Integer max = listOfIntegers.stream()
//                .mapToInt(v -> v)
//                .max()
//                .getAsInt();
//        // Min = 1
//        Integer min = listOfIntegers.stream()
//                .mapToInt(v -> v)
//                .min()
//                .getAsInt();

        //summaryStatistics

//        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 10);
//        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
//        System.out.println("Count: " + stats.getCount());
//        System.out.println("Max: " + stats.getMax());
//        System.out.println("Min: " + stats.getMin());
//        System.out.println("Sum: " + stats.getSum());
//        System.out.println("Average: " + stats.getAverage());

        // reduce

//        int result = IntStream.of(1, 2, 3, 4).reduce(0, (a, b) -> a + b);
//        System.out.println(result); // 10

        try {
            Files.write(Paths.get("numbers.txt"),
                    (Iterable<String>) IntStream.range(0, 5000).mapToObj(String::valueOf)::iterator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
