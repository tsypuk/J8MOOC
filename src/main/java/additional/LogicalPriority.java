package additional;

/**
 * Created by rtsy on 20.07.2015.
 */
public class LogicalPriority {

    public static boolean operation1(boolean b1, boolean b2, boolean b3) {
        return  b1 & b2 | b3;
/*
        false false true - > true
        false true false -> false
        true false false -> false

        true false true -> true
        false true true -> true;
        true true false -> true;
                */
    }

    public static boolean operation2(boolean b1, boolean b2, boolean b3) {
        return  b3 | b2 & b1;
/*
        true false false -> true;
        false true false -> false
        false false true -> false

        true false true -> true
        true true false -> true
        false true true -> true
                */
    }
}
