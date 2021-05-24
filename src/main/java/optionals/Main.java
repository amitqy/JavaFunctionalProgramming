package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {

    /** Optionals are used to properly handle
     *  null values
     */

    public static void main(String[] args) {
        // giving null to optional
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");
        // if optional has null value then return default value
        System.out.println(value);
        // if optional does not have null value then return that value
        Object value2 = Optional.ofNullable("SomeNotNullValue")
                .orElseGet(() -> "default value");
        System.out.println(value2);


        Optional.ofNullable("Hello")
                // takes a consumer
                .ifPresent(someValue-> System.out.println("Saying hello")) ;

        // if optional has null value then return an exception
        Object value3 = Optional.ofNullable(null)
                .orElseThrow(()->new IllegalStateException());

//        It is taking a supplier inside
//        Supplier<IllegalStateException> illegalStateExceptionSupplier = () -> new IllegalStateException();
//        Object value3 = Optional.ofNullable(null)
//                .orElseThrow(illegalStateExceptionSupplier);

        System.out.println(value3);




    }
}
