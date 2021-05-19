package functionalInterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = increment(1);
        System.out.println(increment);

        // using functional style, apply takes the input argument
        Integer increment2 = incrementByOne.apply(1);
        System.out.println(increment2);


    }
    // normal function in java
    static int increment(int number){
        return number+1;
    }
    // Function<Input Type,Return Type>
    static Function<Integer,Integer> incrementByOne = number-> ++number;

}
