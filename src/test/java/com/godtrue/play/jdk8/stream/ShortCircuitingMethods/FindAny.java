package com.godtrue.play.jdk8.stream.ShortCircuitingMethods;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2020-01-05
 */
public class FindAny {
    private static final void findAny(){
        IntStream stream = IntStream.of(1,2,3,4,5,6,7,8,9);
        stream = stream.filter(i -> i % 3 == 0);
        OptionalInt optionalInt = stream.findAny();
        if (optionalInt.isPresent()){
            System.out.println(optionalInt.getAsInt());
        }
    }

    private static final void findAny2(){
        IntStream stream = IntStream.of(1,2,3,4,5,6,7,8,9);
        stream = stream.parallel().filter(i -> i % 3 == 0);
        OptionalInt optionalInt = stream.findAny();
        if (optionalInt.isPresent()){
            System.out.println(optionalInt.getAsInt());
        }
    }

    private static final void findAny3(){
        IntStream stream = IntStream.of(1,2,3,4,5,6,7,8,9).parallel();
        stream = stream.filter(i -> i % 3 == 0);
        OptionalInt optionalInt = stream.findAny();
        if (optionalInt.isPresent()){
            System.out.println(optionalInt.getAsInt());
        }
    }

    public static void main(String[] args) {
        findAny();
        findAny2();
        findAny3();
    }
}
