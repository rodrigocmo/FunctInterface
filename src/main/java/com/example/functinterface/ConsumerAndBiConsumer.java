package com.example.functinterface;

import java.awt.desktop.ScreenSleepEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class ConsumerAndBiConsumer {

    public static void main(String[] args) {

        /*consumerExample();
        System.out.println("------------");
        biConsumerExample();*/
        anThenExample();

    }
    static void consumerExample(){
        // receive args and return nothing
        List<String> list = List.of("Hello", "B2C", "World", "Stack Overflow", "is", "a", "gr8", "platform");

        list.forEach(System.out::println);
    }

    static void biConsumerExample() {

        //receive two args

        List<Integer> number = List.of(1,2,3,4,5,6);
        String test = "test";

        Map<Integer,String> map = new HashMap<>();

        number.forEach(n-> map.put(n,test));

        map.forEach((key,value) ->{
            System.out.println(key + value);
        });

        // do
    }

    static void anThenExample(){

        //Works with the value and then work with the second consumer
        // the first result doesn't interfere with the second consumer

        Consumer<Integer> consumer1 = (value) -> System.out.println(value *= 2);
        Consumer<Integer> consumer2 = (value) -> System.out.println(value *= 2);

        consumer1.andThen(consumer2).accept(15); // both will print 30


        Consumer<Integer> consumer3 = (x) -> System.out.println(x > 10);
        Consumer<Integer> consumer4 = (y) -> System.out.println(y == 20);

        consumer3.andThen(consumer4).accept(15);
    }


}
