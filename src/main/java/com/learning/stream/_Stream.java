package com.learning.stream;

import com.learning.functional.ImperativeAndDeclarative;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)
        );

        people.stream().map(person -> person.gender).collect(Collectors.toSet()).forEach(System.out::println);
        people.stream().map(person -> person.name).collect(Collectors.toSet()).forEach(System.out::println);

        // M1
        // Alt + Ctrl + V -> to extract to variable -> 'person -> person.name'
        people.stream().map(person -> person.name).mapToInt(String::length).forEach(System.out::println);

        // M2
        // Atl + Enter -> replace method reference with lambda -> 'String::length'
        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;
        people.stream().map(personStringFunction).mapToInt(length).forEach(println);

        // M3
//      Function<Person, String> personStringFunction = person -> person.name;
//      ToIntFunction<String> length = s -> s.length();
//      IntConsumer println = x -> System.out.println(x);
//      people.stream().map(personStringFunction).mapToInt(length).forEach(println);

        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
        boolean containsOnlyFemales = people.stream().allMatch(personPredicate);
        System.out.println(containsOnlyFemales);

        boolean containsFemales = people.stream().anyMatch(person -> Gender.FEMALE.equals(person.gender));
        System.out.println(containsFemales);

        boolean isBobAbsent = people.stream().noneMatch(person -> "Bob".equals(person.name));
        System.out.println(isBobAbsent);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }

}
