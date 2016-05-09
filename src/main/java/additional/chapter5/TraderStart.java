package additional.chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by rtsy on 28.07.2015.
 */
public class TraderStart {

    public static List<Transaction> get2011Transactions(List<Transaction> transactions) {
        return transactions.stream()
                .filter(tr -> tr.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    public static List<String> getUniqueCities(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

    }

    public static List<Trader> getBronksTraderByName(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Bronks".equals(trader.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
//                .filter(tx -> "Bronks".equals(tx.getTrader().getCity()))
//                .map(Transaction::getTrader)
//                .sorted(Comparator.comparing(Trader::getName))
//                .collect(Collectors.toList());
    }

    public static String getAllTradersNameAlphabetic(List<Transaction> transactions) {
        return transactions.stream()
                .map(tx -> tx.getTrader().getName())
                .distinct()
                .reduce("", (x, y) -> x + y);

    }

    public static boolean getBronksAnyTrader(List<Transaction> transactions) {
        return transactions.stream()
                .anyMatch(tx -> "Bronks".equals(tx.getTrader().getCity()));
    }

    public static void getCityTransactions(List<Transaction> transactions, String city) {
        transactions.stream()
                .filter(tx -> tx.getTrader().getCity().equals(city))
                .map(Transaction::getValue)
                .forEach(System.out::println);

    }

    public static java.util.Optional<Integer> getHighestTransaction(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
    }

    public static java.util.Optional<Transaction> getSmallestTransaction(List<Transaction> transactions) {
//        return transactions.stream().min(Comparator.comparing(Transaction::getValue));
        return transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
    }

    public static int getSumOfAllOperations(List<Transaction> transactions) {
//        return transactions.stream()
//                    .map(Transaction::getValue)
//                    .reduce(0, Integer::sum);

        return transactions.stream()
                           .mapToInt(Transaction::getValue)
                           .sum();
    }

    public static void main(String[] args) {
        Trader raul = new Trader("Raul", "Cambridge");
        Trader alex = new Trader("Alex", "London");
        Trader banderos = new Trader("Banderod", "Bronks");
        Trader david = new Trader("David", "Bronks");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(raul, 2011, 300),
                new Transaction(alex, 2011, 250),
                new Transaction(banderos, 2010, 200),
                new Transaction(raul, 2010, 400),
                new Transaction(raul, 2012, 200),
                new Transaction(alex, 2013, 400),
                new Transaction(david, 2011, 200)
        );

        System.out.println("2011 year transactions: " + get2011Transactions(transactions));
        System.out.println("Unique cities of Traders: "+ getUniqueCities(transactions));
        System.out.println("Bronks traders: " + getBronksTraderByName(transactions));
        System.out.println("Traders long name: " + getAllTradersNameAlphabetic(transactions));
        System.out.println("Bronks: " + getBronksAnyTrader(transactions));
        getCityTransactions(transactions, "Bronks");
        System.out.println("Highest transaction value: " + getHighestTransaction(transactions));
        System.out.println("Smallest transaction value: " + getSmallestTransaction(transactions));
        System.out.println("Sum of all operations: " + getSumOfAllOperations(transactions));

        IntStream intStream = generateIntStream(1, 10);
        System.out.println("The count of records: " + intStream.count());
        System.out.println("Pythagorean triple: ");
        getPythagorianTriple()
                .limit(5)
                .forEach(pair -> System.out.println(Arrays.toString(pair)));
    }

    private static Stream<int[]> getPythagorianTriple() {
        Stream<int[]> pythagorianTriples =
        IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(1, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .boxed()
                                .map(b -> new int[] {a, b, (int) Math.sqrt(a * a + b * b)}));
        return pythagorianTriples;
    }

    private static IntStream generateIntStream(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .peek(System.out::println)
                 .filter(value -> value % 2 == 0)
                 .peek(System.out::println);

    }
}