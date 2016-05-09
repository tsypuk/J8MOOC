package lesson2;

import additional.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Created by rtsy on 25.07.2015.
 */
public class AppleStream {

    public static int getSumAppleWeightMoreHundred(List<Apple> appleList) {
        int total = appleList.stream()
                .filter(a -> a.getWeight() > 100)
                .mapToInt(Apple::getWeight)
                .sum();
        return total;
    }

    public static int getSumArray(Apple[] apples) {
        return Arrays.stream(apples).mapToInt(Apple::getWeight)
                .sum();
    }

    public static long getGreenApplesCountArray(Apple[] apples) {
        return Arrays.stream(apples).filter((Apple apple) -> apple.getColor() == Apple.appleColors.GREEN).count();
    }

    public static java.util.OptionalInt getMAx(List<Apple> appleList) {
        return appleList.stream()
                .mapToInt(Apple::getWeight)
                .max();
    }
}