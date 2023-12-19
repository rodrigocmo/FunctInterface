package com.example.functinterface;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierInterface {
    public static void main(String[] args) {

        testFunctionInterface();
        System.out.println("-----------------");
        testSupplierOK();

    }


    public static void testSupplierError(){
        //this will throw error java.lang.IllegalStateException: stream has already been operated upon or closed

        List<String> list = List.of("Hello", "B2C", "World", "Stack Overflow", "is", "a", "gr8", "platform");

        Stream<String> stream = list.stream()
                .filter(s -> s.length() <= 5)
                .map(s -> s.substring(1));

        System.out.println(stream.anyMatch(s -> Character.isLetter(s.charAt(0))));
        System.out.println(stream.anyMatch(s -> Character.isDigit(s.charAt(0))));
    }

    public static void testSupplierOK(){
        List<String> list = List.of("Hello", "B2C", "World", "Stack Overflow", "is", "a", "gr8", "platform");

        Supplier<Stream<String>> streamSupplier = () -> list.stream()
                .filter(s -> s.length() <= 5)
                .map(s -> s.substring(1));

        System.out.println(streamSupplier.get().anyMatch(s -> Character.isLetter(s.charAt(0))));

        System.out.println(streamSupplier.get().anyMatch(s -> Character.isDigit(s.charAt(0))));
    }


    //Returns a value without args
    //Supplier only assign the value when you need it
    public static void  testFunctionInterface(){

        testFunctionInterfacePart2(Stream.generate(()-> new Random().nextInt())
                .limit(5));
    }

    public static void testFunctionInterfacePart2(Stream<Integer> Integers) {
        Map<Integer, Integer> maps = new HashMap<>();
        Integers.forEach(i -> {
            maps.computeIfAbsent(i, key -> new Random().nextInt());
        });
        maps.entrySet().forEach(map -> {
            System.out.println(" Key " + map.getKey());
            System.out.println(" Value " + map.getValue());
        });

    }

}


