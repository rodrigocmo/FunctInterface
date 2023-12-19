package com.example.functinterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

public class Supplier {
    public static void main(String[] args) {

        testFunctionInterface();
        testFunctionInterfaceAnotherWay();

    }
    //Returns a value without parameter
    public static void  testFunctionInterface(){

        testFunctionInterfacePart2(Stream.generate(()-> new Random().nextInt())
                .limit(5));
    }

    public static void testFunctionInterfacePart2(Stream<Integer> Integers){
        Map<Integer, Integer> maps =  new HashMap<>();
        Integers.forEach(i->{
            maps.computeIfAbsent(i,key-> new Random().nextInt() );
        });
        maps.entrySet().forEach(map->{
            System.out.println(" Key " +  map.getKey());
            System.out.println(" Value " +  map.getValue());
        });

    }

    public static void testFunctionInterfaceAnotherWay(){
        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";

        Function<Integer, String> quoteIntToString = quote.compose(intToString);
    }
}


