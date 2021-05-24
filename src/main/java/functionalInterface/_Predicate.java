package functionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        // Task is to validate phone numbers

        //using old java style
        System.out.println("using old java style");
        System.out.println(isPhoneNumberValid("07099788712"));
        System.out.println(isPhoneNumberValid("0909978872"));

        //using predicates
        System.out.println("using predicates");
        System.out.println(isPhoneNumberValidPredicate.test("07099788712"));
        System.out.println(isPhoneNumberValidPredicate.test("0909978872"));

        // cool thing about predicates is that we can combine many predicates together
        // predicate 1 -> starts with 07, length is 11
        // predicate 2 -> contains 3
        // combining 2 predicates together

        // and means both predicates should be true to make final result true
        System.out.println("combining 2 predicates together");
        System.out.println(isPhoneNumberValidPredicate.and(containNumber3).test("07039788712"));
        System.out.println(isPhoneNumberValidPredicate.and(containNumber3).test("07049788712"));
        // or means any one predicates can be true to make final result true
        System.out.println(isPhoneNumberValidPredicate.or(containNumber3).test("07049788712"));

        // using BiPredicates
        System.out.println("Using BiPredicates");
        System.out.println(areStringsEqual.test("abc","abc"));
        System.out.println(areStringsEqual.test("abd","abc"));


    }


    // using old java style
    static boolean isPhoneNumberValid(String phoneNumber){
        return (phoneNumber.startsWith("07")) && (phoneNumber.length() == 11);
    }

    // takes an input and returns boolean
    // Predicate<Input Type>
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> (phoneNumber.startsWith("07")) && (phoneNumber.length() == 11);

    static Predicate<String> containNumber3 = phoneNumber->(phoneNumber.contains("3"));

    // takes two inputs and return boolean
    // BiPredicate<Input Type1 ,Input Type2 >
    static BiPredicate<String ,String > areStringsEqual = (string1,string2) -> string1.equals(string2);
}
