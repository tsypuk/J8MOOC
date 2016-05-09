package additional.chapter5;

/**
 * Created by rtsy on 28.07.2015.
 */
public class Transaction {
    private final Trader _trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        _trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return _trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "_trader=" + _trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
