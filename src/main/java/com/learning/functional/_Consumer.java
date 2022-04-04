package com.learning.functional;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

// consumer is similar to a void function
public class _Consumer {

    // Consumer<T> Represents an operation that accepts a single input argument and returns no result.
    // BiConsumer<T,U> Represents an operation that accepts two input arguments and returns no result.
    // T and U are the input data types

    // IntConsumer - Represents an operation that accepts a single int-valued argument and returns no result.
    // LongConsumer - Represents an operation that accepts a single long-valued argument and returns no result.
    // DoubleConsumer - Represents an operation that accepts a single double-valued argument and returns no result.

    // ObjIntConsumer<T> - Represents an operation that accepts an object-valued and a int-valued argument, and returns no result.
    // ObjLongConsumer<T> - Represents an operation that accepts an object-valued and a long-valued argument, and returns no result.
    // ObjDoubleConsumer<T> - Represents an operation that accepts an object-valued and a double-valued argument, and returns no result.

    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "99999");

        // accept - is used to run consumers
        greetCustomerConsumer.accept(maria);

        // bi-consumer
        greetCustomerFlagBiConsumer.accept(maria, false);
    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " +
                customer.customerPhoneNumber);
    }
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName +
            ", thanks for registering phone number " +
            customer.customerPhoneNumber);

    static void greetCustomerFlag(Customer customer, Boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " +
                (showPhoneNumber ? customer.customerPhoneNumber : "*****"));
    }
    static BiConsumer<Customer, Boolean> greetCustomerFlagBiConsumer = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number " +
                    (showPhoneNumber ? customer.customerPhoneNumber : "*****"));

    static  class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
