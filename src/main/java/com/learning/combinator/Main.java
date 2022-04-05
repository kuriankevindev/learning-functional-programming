package com.learning.combinator;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Alice",
                "alice@gmail.com", "+0987654321",
                LocalDate.of(2000,1,1));

        System.out.println(new CustomerValidatorService().isValid(customer));
    }
}
