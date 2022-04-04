package com.learning.functional;

import java.util.function.Predicate;

// predicate is similar to a function that returns boolean value
public class _Predicate {

    // Predicate<T>	- Represents a predicate (boolean-valued function) of one argument.
    // BiPredicate<T,U> - Represents a predicate (boolean-valued function) of two arguments.
    // T and U are the input data types

    // IntPredicate - Represents a predicate (boolean-valued function) of one int-valued argument.
    // LongPredicate - Represents a predicate (boolean-valued function) of one long-valued argument.
    // DoublePredicate - Represents a predicate (boolean-valued function) of one double-valued argument.

    public static void main(String[] args) {

        // test - is used to run predicates
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0700000000"));

        // and/or - is used to chain predicates
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("07000300000"));
        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("07000000000"));
    }

    static  boolean isPhoneNumberValid (String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
}
