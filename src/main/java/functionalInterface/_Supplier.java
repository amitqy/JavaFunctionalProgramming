package functionalInterface;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        // Task -> Make a function that returns a value
        // using old java style
        System.out.println("Using old java style");
        System.out.println(getDBConnectionUrl());
        // using supplier
        System.out.println("Using Supplier");
        System.out.println(getDBConnectionUrlSupplier.get());

    }


    // purpose of this function is to simply return a value
    static String getDBConnectionUrl(){
        return "jdbc://localhost:5432/users";
    }
    // This supplies a string value
    // Supplier<Return Type>
    static Supplier<String> getDBConnectionUrlSupplier = ()->"jdbc://localhost:5432/users";
}
