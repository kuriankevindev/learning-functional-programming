package com.learning.optional;

import java.util.Optional;

// helps to deal with null pointer exceptions
public class _Optional {

    public static void main(String[] args) {
        Object defaultValue = Optional.ofNullable(null).orElseGet(() -> "default value");
        System.out.println(defaultValue);

        Object actualValue = Optional.ofNullable("Hello").orElseGet(() -> "default value");
        System.out.println(actualValue);

        // M1
        Optional.ofNullable("john@gmail.com").ifPresent(email -> {
            System.out.println(email);
        });
        //M2
        Optional.ofNullable("john@gmail.com").ifPresent(System.out::println);
        // M3
        Optional.ofNullable("john@gmail.com").ifPresent(email -> System.out.println("Sending email to " + email));
        Optional.ofNullable(null).ifPresent(email -> System.out.println("Sending email to " + email));

        Optional.ofNullable("john@gmail.com").ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                () -> System.out.println("Cannot send email."));
        Optional.ofNullable(null).ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                () -> System.out.println("Cannot send email."));

        Object exceptionValue = Optional.ofNullable(null).orElseThrow(() -> new IllegalStateException("exception"));
        System.out.println(exceptionValue);


    }
}
