package additional.chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by rtsy on 26.07.2015.
 */
public class DishStream {

    public static List<Dish> generateMenuList(int caloriesLimit, int count) {
        return Stream.generate(() -> new Dish("Dish" + (char)(97 + new Random().nextInt(20)), new Random().nextInt(caloriesLimit)))
                .limit(10).collect(Collectors.toList());
    }

    /**
     * Old style Java7.
     */
    public static List<String> getLowCaloriesDishNamesList(List<Dish> menu) {
        List<Dish> lowCaloriesDish = new ArrayList<>();
        List<String> lowCaloriesDishesNames = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 300) {
                lowCaloriesDish.add(dish);
            }
        }
        Collections.sort(lowCaloriesDish, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        for (Dish dish : lowCaloriesDish) {
            lowCaloriesDishesNames.add(dish.getName());
        }
        System.out.println(lowCaloriesDishesNames);
        return lowCaloriesDishesNames;
    }

    /**
     * New Java8 style
     */
    public static List<String> getLowCaloriesDishNamesListJava8(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> dish.getCalories() < 300)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public static long getLowCaloriesDishCount(List<Dish> menu, int caloriesLimit) {
        long counter = 0;
        for (Dish dish : menu) {
            if (dish.getCalories() < caloriesLimit) {
                counter ++;
            }
        }
        return counter;
    }

    public static long getLowCaloriesDishCountJava8(List<Dish> menu, int caloriesLimit) {
        return menu.stream()
                .filter(dish -> dish.getCalories() < caloriesLimit)
                .count();
    }
}