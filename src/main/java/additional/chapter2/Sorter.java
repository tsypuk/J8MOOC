package additional.chapter2;

import additional.Apple;
import additional.AppleFilter;

import java.util.Comparator;
import java.util.List;

/**
 * Created by rtsy on 17.07.2015.
 */
public class Sorter {

    public void sortByWeight() {
        AppleFilter appleFilter = new AppleFilter();
        List<Apple> appleList = appleFilter.generateAppleList(20);
        appleList.sort((apple1, apple2) -> apple1.getWeight() - apple2.getWeight());
        System.out.println(appleList);
    }

    public void sortByColor() {
        AppleFilter appleFilter = new AppleFilter();
        List<Apple> appleList = appleFilter.generateAppleList(20);
        appleList.sort(Comparator.comparingInt(Apple::getColorID)/*apple1, apple2)-> apple1.getColorID() - apple2.getColorID()*/);
        System.out.println(appleList);
    }

    public void testFloat() {
        final double delta = 0.0001;
        double d1 = 0.6F;
        d1 += 0.1F;
        d1+= 0.1F;
        double d2 = 0.8F;
        System.out.println(Math.abs(d1 - d2) < delta);
    }

    public static void main(String[] args) {

        Sorter sorter = new Sorter();
        sorter.sortByWeight();
        sorter.sortByColor();
        sorter.testFloat();

    }
}
