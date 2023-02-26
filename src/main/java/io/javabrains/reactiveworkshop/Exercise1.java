package io.javabrains.reactiveworkshop;

import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()
        Stream<Integer> numberStream = StreamSources.intNumbersStream();

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        //numberStream.forEach(x -> System.out.println(x));
        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
//        numberStream.forEach(x -> {
//            if (x < 5) {
//                System.out.println(x);
//            }
//        });

        numberStream.filter(x -> x < 5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        StreamSources.intNumbersStream().filter(x -> x > 5)
                .skip(1)
                .limit(2)
                .forEach(x -> System.out.println(x));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        Integer integer = StreamSources.intNumbersStream().filter(x -> x > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(integer);
        // Print first names of all users in userStream
        // TODO: Write code here
        StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        StreamSources.userStream().filter(x -> {
            return StreamSources.intNumbersStream().filter(y -> y == x.getId()).findAny().isPresent();
        }).forEach(number -> System.out.println("James " + number.getFirstName()));
        //need to see the use case for flatmap

    }

}
