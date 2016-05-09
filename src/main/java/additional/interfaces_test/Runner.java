package additional.interfaces_test;

/**
 * Created by rtsy on 21.07.2015.
 */
public class Runner {
    public static void main(String[] args) {
        ChildInterface childInterface = new ChildImpl();
        ParentInterface parentInterface = new ParentImpl();
        System.out.println(childInterface.getTrue());
        System.out.println(parentInterface.getTrue());
    }
}
