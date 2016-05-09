package additional.chapter3;

import additional.Apple;
import additional.AppleFilter;

import java.util.Comparator;
import java.util.List;

/**
 * Created by rtsy on 26.07.2015.
 */
public class ComparatorChaining {

    public static void main(String[] args) {
        List<Apple> inventory = new AppleFilter().generateAppleList(100);
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        System.out.println(inventory);
    }
}
