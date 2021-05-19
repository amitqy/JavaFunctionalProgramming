package functionalInterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = increment(1);
        System.out.println(increment);

        // using functional style, apply takes the input argument
        Integer increment2 = incrementByOne.apply(1);
        System.out.println(increment2);

        // new way of combining
        Function<Integer, Integer> incrementByOneAndMultiplyBy10 = incrementByOne.andThen(multiplyByTen);
        System.out.println(incrementByOneAndMultiplyBy10.apply(1));



    }
    // normal function in java

    static int increment(int number){
        return number+1;
    }
    // Function<Input Type,Return Type>
    static Function<Integer,Integer> incrementByOne = number-> ++number;

    // we want to merge many functions to do one work
    // after incrementing by 1, we want to apply this function immediately
    // see line 14
    static Function<Integer,Integer> multiplyByTen = number->number*10;

}
