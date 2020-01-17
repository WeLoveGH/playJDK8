package com.godtrue.play.jdk8.stream.ShortCircuitingMethods;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2020-01-05
 */
public class AnyMatch {
    private static final void anyMatch(){
        IntStream stream = IntStream.of(1,2,3,4,5,6,7,8,9);
        boolean match = stream.anyMatch(i -> i % 3 == 0);
        System.out.println(match);
    }

    private static final void anyMatch2(){
        IntStream stream = IntStream.of(1,2,3,4,5,6,7,8,9);
        boolean match = stream.anyMatch(i -> i % 13 == 0);
        System.out.println(match);
    }

    private static final void anyMatch3(){
        Stream<String> stream = Stream.of("one","two","three","four");
        boolean match = stream.anyMatch(s -> s.contains("our"));
        System.out.println(match);
    }

    public static void main(String[] args) {
        anyMatch();
        anyMatch2();
        anyMatch3();
    }
}
