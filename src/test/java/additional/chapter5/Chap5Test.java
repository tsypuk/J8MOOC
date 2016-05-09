package additional.chapter5;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Chap5Test {

    @Test
    public void testFilterUniqueOdd()
            throws Exception {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(4);
        assertEquals(Chap5.filterUniqueOddCount(numbers), 2);
    }

    public void testSum() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        assertEquals(Chap5.getSum(list), Chap5.getSumLamda(list));
        assertEquals(Chap5.getSum(list), Chap5.getSumMethodRed(list));
    }
}