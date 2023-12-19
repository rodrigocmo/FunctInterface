package com.example.functinterface;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierInterface {
    public static void main(String[] args) {

        testFunctionInterface();

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


