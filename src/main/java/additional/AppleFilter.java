package additional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by rtsy on 17.07.2015.
 */
public class AppleFilter {
    private static final int APPLE_WEIGHT_LIMIT = 5;

    public List<Apple> generateAppleList(int size) {
        Random random = new Random();
        return Stream.generate(() -> new Apple(random.nextInt(APPLE_WEIGHT_LIMIT), Apple.appleColors.values()[random.nextInt(Apple.appleColors.values().length)])).limit(size).collect(Collectors.toList());
    }

    public List<Apple> filterOneStream(List<Apple> appleList) {
        return appleList.stream().filter(getHeavyGreenApples()).collect(Collectors.toList());
    }

    public List<Apple> filterParallelStream(List<Apple> appleList) {
        return appleList.parallelStream().filter(getHeavyGreenApples()).collect(Collectors.toList());
    }

    private Predicate<Apple> getHeavyGreenApples() {
        return (Apple apple) -> apple.getColor() == Apple.appleColors.GREEN &&
                apple.getWeight() > 150;
    }

    public static void main(String[] args)
            throws InterruptedException {
        final int LIMIT = 90000000;
        AppleFilter appleFilter = new AppleFilter();

        List<Apple> appleList = appleFilter.generateAppleList(LIMIT);
        System.out.println(LocalDateTime.now());
        appleFilter.filterOneStream(appleList);
        System.out.println(LocalDateTime.now());
        Thread.sleep(5000);
        List<Apple> appleListParallel = appleFilter.generateAppleList(LIMIT);
        System.out.println(LocalDateTime.now());
        appleFilter.filterOneStream(appleListParallel);
        System.out.println(LocalDateTime.now());
    }
}