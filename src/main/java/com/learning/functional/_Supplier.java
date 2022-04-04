package com.learning.functional;

import java.util.List;
import java.util.function.Supplier;

// supplier is similar to a function that has no input arguments
public class _Supplier {

    // Supplier<T> - Represents a supplier of results.
    // T is the output data type

    // BooleanSupplier - Represents a supplier of boolean-valued results.
    // IntSupplier - Represents a supplier of int-valued results.
    // LongSupplier - Represents a supplier of long-valued results.
    // DoubleSupplier - Represents a supplier of double-valued results.

    public static void main(String[] args) {

        // get - is used to run suppliers
        System.out.println(getDBConnectionUrlSupplier.get());
        System.out.println(getDBConnectionUrlListSupplier.get());
    }

    static String getDBConnectionUrl () {
        return "jdbc://localhost:8080/users";
    }
    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:8080/users";
    static Supplier<List<String>> getDBConnectionUrlListSupplier = () -> List.of("jdbc://localhost:8080/users","jdbc://localhost:80/users");
}
