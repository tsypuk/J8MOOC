package additional.chapter5;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by rtsy on 26.07.2015.
 */
public class Chap5 {

    public static void filterUniqueOdd(List<Integer> numbers) {
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    public static long filterUniqueOddCount(List<Integer> numbers) {
        return numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .count();
    }

    public static List<String> createPairs() {
        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(3, 4);

        List<String> pairs = nums1.stream()
                .flatMap(i -> nums2.stream()
                                .map(j -> i + ":" + j)
                ).collect(Collectors.toList());
        return pairs;
    }

    public static List<String> createPairsDividedByThree() {
        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(3, 4);

        List<String> pairs = nums1.stream()
                .flatMap(i -> nums2.stream()
                                .filter(j -> (i + j) % 3 == 0)
                                .map(j -> i + ":" + j)
                )
                .collect(Collectors.toList());
        return pairs;
    }

    public static List<Integer> getSquares(List<Integer> list) {
        return list.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    public static void findElement() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Optional<Integer> result = list.stream()
                    .filter(s -> s == 3)
                    .findAny();
        System.out.println(result.orElse(0));
    }

    public static int getSum(List<Integer> list) {
        int sum = 0;
        for (int el : list) {
            sum += el;
        }
        return sum;
    }

    public static int getSumLamda(List<Integer> list) {
        return list.stream()
                .reduce(0, (x, y) -> x + y);
    }

    public static int getSumMethodRed(List<Integer> list) {
        return list.stream()
                .reduce(Integer::sum).orElse(0);
    }

    public static Optional<Integer> getMax(List<Integer> list) {
        return list.stream()
                .reduce(Integer::max);
    }

    public static void main(String[] args) {

        System.out.println(String.format("%d%%", 5));
        List<String> list = createPairs();
        System.out.println(list);

        List<String> list2 = createPairsDividedByThree();
        System.out.println(list2);

        List<Integer> integerList = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        System.out.println(integerList + "\n" +getSquares(integerList));

        findElement();
    }
}