package additional.chapter2;

/**
 * Created by rtsy on 17.07.2015.
 */
public class LamdaThread {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Thread is running."));
    }
}
