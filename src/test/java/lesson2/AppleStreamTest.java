package lesson2;

import additional.Apple;
import additional.AppleFilter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class AppleStreamTest {

    private AppleFilter _appleFilter;

    @BeforeClass
    public void init() {
        _appleFilter = new AppleFilter();
    }

    @Test
    public void testGetSumAppleWeightMoreHundred()
            throws Exception {
        List<Apple> appleList = _appleFilter.generateAppleList(10);
        int total = AppleStream.getSumAppleWeightMoreHundred(appleList);
        assertEquals(total, getTotal(appleList));
    }

    @Test
    public void testMax() {
        List<Apple> appleList = _appleFilter.generateAppleList(100);
        assertEquals(AppleStream.getMAx(appleList).orElse(0), getMax(appleList));
    }

    @Test
    public void testArraySum() {
        Apple[] ar = new Apple[0];
        AppleStream.getSumArray(_appleFilter.generateAppleList(10).toArray(ar));
    }

    private static int getMax(List<Apple> appleList) {
        int max = 0;
        for (Apple apple : appleList) {
            if (apple.getWeight() > max) {
                max = apple.getWeight();
            }
        }
        return max;
    }

    private static int getTotal(List<Apple> appleList) {
        int sum = 0;
        for (Apple apple : appleList) {
            if (apple.getWeight() > 100) {
                sum += apple.getWeight();
            }
        }
        return sum;
    }
}