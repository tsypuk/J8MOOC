package additional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rtsy on 16.07.2015.
 */
public class My {

    public List<String> initList() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Image");
        stringList.add("Test");
        stringList.add("Alpha");
        stringList.add("Delta");
        return stringList;
    }
    public void sortList(List<String> stringList) {

        System.out.println(stringList);

        stringList.sort((a, b) -> a.length() - b.length());
        System.out.println(stringList);

        stringList.sort((a, b) -> a.compareTo(b));
        System.out.println(stringList);
    }

    public void foreach(List<String> stringList) {
        stringList.forEach(System.out::println);
    }

    public void listReplace() {
        List<Integer> list = new ArrayList<>();
        list.add(222);
        list.add(333);

        list.replaceAll(Integer::signum);
        list.replaceAll(Number::hashCode);
        System.out.println(list);
    }

    public static void main(String[] args) {
        My my = new My();
        my.sortList(my.initList());
        my.foreach(my.initList());
        my.listReplace();
    }
}