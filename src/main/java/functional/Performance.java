package functional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rtsy on 31.07.2015.
 * Take a look at programming tricks of using J8
 * https://www.youtube.com/watch?v=Ee5t_EGjv0A
 */
public class Performance {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        System.out.println(
                numbers.parallelStream()
                    .mapToInt(Performance::doubleIt)
                    .sum()
        );
    }

    private static int doubleIt(int value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value * 2;
    }
}
