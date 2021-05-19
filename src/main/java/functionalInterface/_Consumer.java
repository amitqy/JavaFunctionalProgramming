package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {

        Customer maria = new Customer("Maria", "999999999");
        // normal java function
        greetCustomer(maria);
        // using functional interface Consumer
        greetCustomerConsumer.accept(maria);

        // using functional interface BiConsumer
        // passing true as second argument hides the phone number of customer
        greetCustomerConsumerV2.accept(maria,true);

        // using olf java to hide the customer phone number
        greetCustomerV2(maria,true);

    }

    // Consumer takes one argument and returns nothing
    // Consumer<Data Type of argument>
    static Consumer<Customer> greetCustomerConsumer =
            customer ->  System.out.println("Hello" + customer.customerName + ", " +
                    "thanks for registering phone number " + customer.customerPhoneNumber );

    // old java function
    static void greetCustomer(Customer customer){
        System.out.println("Hello" + customer.customerName + ", " +
                "thanks for registering phone number " + customer.customerPhoneNumber );
    }

    // BiConsumer<Data Type of argument, Boolean>
    static BiConsumer<Customer,Boolean> greetCustomerConsumerV2 =
            (customer,showPhoneNumber) ->  System.out.println("Hello" + customer.customerName + ", " +
                    "thanks for registering phone number " + (showPhoneNumber ? "**********" : customer.customerPhoneNumber) );

    // old java function
    static void greetCustomerV2(Customer customer, boolean showPhoneNumber){
        System.out.println("Hello" + customer.customerName + ", " +
                "thanks for registering phone number " + (showPhoneNumber ? "**********" : customer.customerPhoneNumber) );
    }

    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
