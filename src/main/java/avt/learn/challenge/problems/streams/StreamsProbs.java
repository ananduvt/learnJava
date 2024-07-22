package avt.learn.challenge.problems.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsProbs {

    public static void main(String[] args) {

    }

    public static void name() {
        // Write a Stream operation to find the first even number greater than 10 in a
        // list of integers.
        List<Integer> numbers = Arrays.asList(5, 8, 15, 20, 25);
        Optional<Integer> firstEven = numbers.stream()
                .filter(n -> n > 10 && n % 2 == 0)
                .findFirst();
    }

    public static void name2() {
        // Write a Stream operation to find the first even number greater than 10 in a
        // list of integers.
        List<Integer> numbers = Arrays.asList(5, 8, 15, 20, 25);
        Optional<Integer> firstEven = numbers.stream()
                .filter(n -> n > 10 && n % 2 == 0)
                .findFirst();
    }

    public static void name3() {
        // Given a list of names, write a Stream operation to filter names starting with
        // 'A' and collect them into a List.
        List<String> names = Arrays.asList("Alice", "Bob", "Amanda", "Charles");
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
    }

    public static void name4() {
        // How would you use Streams to count the number of unique words in a text file?
        try {
            long uniqueWordCount = Files.lines(Paths.get("file.txt"))
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void name5() {
        // How do you convert a list of integers to a list of their squares using
        // Streams?
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    public static void name6() {
        // How do you find the maximum and minimum value in a list of integers using
        // Streams?
        List<Integer> numbers = Arrays.asList(5, 10, -2, 23, 7);
        int max = numbers.stream()
                .max(Integer::compare)
                .orElseThrow(NoSuchElementException::new);
        int min = numbers.stream()
                .min(Integer::compare)
                .orElseThrow(NoSuchElementException::new);
    }

    public static void name7() {
        // How do you join a list of strings into a single string separated by commas
        // using Streams?
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        String result = strings.stream()
                .collect(Collectors.joining(", "));

    }

    public static void name8() {
        // How do you group a list of strings by their length using Streams?
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");
        Map<Integer, List<String>> groupedByLength = strings.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    public static void name9() {
        // How do you count the occurrences of each word in a list of strings using
        // Streams?
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
        Map<String, Long> wordCount = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void name10() {
        // How do you partition a list of numbers into even and odd using Streams?
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
    }

    public static void name11() {
        // How do you find the sum of all even numbers in a list using Streams?
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sumOfEvens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

    }

    public static void name12() {
        // How do you flatMap a list of lists into a single list using Streams?
        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8));
        List<Integer> flatList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

    }

    public static void name13() {
        // How do you find the second highest number in a list using Streams?
        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25);
        int secondHighest = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

    }

    public static void name14() {
        // How do you collect the distinct elements of a list and sort them in natural
        // order using Streams?
        List<Integer> numbers = Arrays.asList(5, 3, 2, 8, 3, 1, 2, 5);
        List<Integer> distinctSorted = numbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static void name15() {
        // How do you generate a stream of the first 10 Fibonacci numbers using Streams?
        List<Integer> fibonacci = Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] })
                .limit(10)
                .map(f -> f[0])
                .collect(Collectors.toList());
    }

    public static void name16() {

        // How do you convert a list of strings to a map with the string as the key and
        // its length as the value using Streams?
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        Map<String, Integer> stringLengthMap = strings.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
    }

    public static void name17() {

        // How do you remove duplicates from a list of integers using Streams?
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static void name18() {

        // How do you check if any string in a list starts with a given prefix using
        // Streams?
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        boolean anyStartsWithA = strings.stream()
                .anyMatch(s -> s.startsWith("a"));
    }

    public static void name19() {
        // How do you find the average length of strings in a list using Streams?
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        double averageLength = strings.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
    }

}
