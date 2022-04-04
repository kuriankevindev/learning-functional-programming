package com.learning.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

// function is similar to a method that returns a non-boolean value
public class _Function {

    // Function<T,R> - Represents a function that accepts one argument and produces a result.
    // BiFunction<T,U,R> - Represents a function that accepts two arguments and produces a result.
    // T and U are the input data types and R is the output data type

    // IntFunction<R> - Represents a function that accepts an int-valued argument and produces a result.
    // LongFunction<R> - Represents a function that accepts a long-valued argument and produces a result.
    // DoubleFunction<R> - Represents a function that accepts a double-valued argument and produces a result.

    // IntToDoubleFunction - Represents a function that accepts an int-valued argument and produces a double-valued result.
    // IntToLongFunction - Represents a function that accepts an int-valued argument and produces a long-valued result.

    // LongToDoubleFunction - Represents a function that accepts a long-valued argument and produces a double-valued result.
    // LongToIntFunction	- Represents a function that accepts a long-valued argument and produces an int-valued result.

    // DoubleToIntFunction - Represents a function that accepts a double-valued argument and produces an int-valued result.
    // DoubleToLongFunction -Represents a function that accepts a double-valued argument and produces a long-valued result.

    // ToIntFunction<T> - Represents a function that produces an int-valued result.
    // ToIntBiFunction<T,U> - Represents a function that accepts two arguments and produces an int-valued result.

    // ToLongFunction<T> - Represents a function that produces a long-valued result.
    // ToLongBiFunction<T,U> - Represents a function that accepts two arguments and produces a long-valued result.

    // ToDoubleFunction<T> - Represents a function that produces a double-valued result.
    // ToDoubleBiFunction<T,U> - Represents a function that accepts two arguments and produces a double-valued result.

    public static void main(String[] args) {

        // apply - is used to run functions
        System.out.println(incrementByOneFunction.apply(0));

        // andThen - is used to chain functions
        Function<Integer, Integer> incrementByOneAndMultiplyByTenFunction = incrementByOneFunction.andThen(multiplyByTenFunction);
        System.out.println(incrementByOneAndMultiplyByTenFunction.apply(0));

        // bi-function
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(0, 10));

    }

    static int incrementByOne(int number) {
        return number + 1;
    }
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static int multiplyByTen(int number) {
        return number * 10;
    }
    static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;

    static int incrementByOneAndMultiply(int number, int multiplicationFactor) {
        return (number + 1) * multiplicationFactor;
    }
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction = (number, multiplicationFactor) -> (number + 1) * multiplicationFactor;
}
