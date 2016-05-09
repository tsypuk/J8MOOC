package additional.chapter5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by rtsy on 01.08.2015.
 */
public class GenerateStream {

    public static void main(String[] args) {
        generateFromList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        generateFromValues();
        generateEmptyStream();
        generateFromArray();
        findUniqueLowerCaseWordsInFile();
        createStreamWithIterate();
        generateRandomValues();
    }

    private static void generateRandomValues() {
        System.out.println("generateRandomValues()");
        Stream.generate(Math::random)
              .limit(10)
              .forEach(System.out::println);
    }

    private static void createStreamWithIterate() {
        Stream.iterate(0, n -> n +2)
              .limit(10)
              .forEach(System.out::println);
    }

    private static void findUniqueLowerCaseWordsInFile() {
        long uniqueWords = 0;
        try (Stream<String> lines =
                     Files.lines(Paths.get("C:\\temp.txt"), Charset.defaultCharset())) {
                          uniqueWords = lines.flatMap(
                                  line -> Arrays.stream(line.split(" ")))
                                             .map(String::toLowerCase)
                                             .distinct()
                                             .count();
        } catch (IOException e) {

        }
        System.out.println("Unique words count: " + uniqueWords);
    }

    private static void generateFromArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        int sum = Arrays.stream(array)
                .limit(10)
                .filter(value -> value % 2 == 0)
                .peek(System.out::println)
                .sum();
        System.out.println("Sum = " + sum);
    }

    private static void generateEmptyStream() {
        Stream<String> stream = Stream.empty();
    }

    private static void generateFromValues() {
        Stream<String> stream = Stream.of("Java 8", "OACA", "OCP", "Lambda");
        stream.map(String::toLowerCase)
                .forEach(System.out::println);
    }

    private static void generateFromList(List<Integer> list) {
        list.stream()
                .map(value -> value * 2)
                .forEach(System.out::println);
    }
}
