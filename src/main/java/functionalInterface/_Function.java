package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {

        // an old java function
        int increment = increment(1);
        System.out.println(increment);

        // using functional style. apply() takes the input argument
        Integer increment2 = incrementByOne.apply(1);
        System.out.println(increment2);

        // we want to merge many functions to do one work
        // after incrementing by 1, we want to multiply immediately
        // new way of combining
        Function<Integer, Integer> incrementByOneAndMultiplyBy10 = incrementByOne.andThen(multiplyByTen);
        System.out.println(incrementByOneAndMultiplyBy10.apply(1));

        // A  BiFunction
        Integer incrementByOneAndMultiply  = incrementByOneAndMultiplyBiFunction.apply(4,6);
        System.out.println(incrementByOneAndMultiply);


    }
    // normal function in java

    static int increment(int number){
        return number+1;
    }
    // Function<Input Type,Return Type>
    static Function<Integer,Integer> incrementByOne = number-> ++number;

    static Function<Integer,Integer> multiplyByTen = number->number*10;

    // a Bi-Function is a function, which takes 2 arguments and returns one output
    // BiFunction<Input Type1,Input Type2,Return Type>
    static BiFunction<Integer,Integer,Integer> incrementByOneAndMultiplyBiFunction = (numberToIncrementByOne,numberToMultiplyBy)->
            (numberToIncrementByOne+1)*numberToMultiplyBy;

    // old style function
    static int incrementByOneAndMultiply(int number,int numToMultiplyBy){
        return (number+1)*(numToMultiplyBy);
    }

}
