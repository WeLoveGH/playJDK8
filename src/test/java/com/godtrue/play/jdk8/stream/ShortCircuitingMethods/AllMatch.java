package com.godtrue.play.jdk8.stream.ShortCircuitingMethods;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2020-01-05
 */
public class AllMatch {
    private static final void allMatch(){
        IntStream stream = IntStream.of(1,2,3,4,5,6,7,8,9);
        boolean match = stream.allMatch(i -> i % 1 == 0);
        System.out.println(match);
    }

    private static final void allMatch2(){
        IntStream stream = IntStream.of(1,2,3,4,5,6,7,8,9);
        boolean match = stream.allMatch(i -> i % 3 == 0);
        System.out.println(match);
    }

    private static final void allMatch3(){
        Stream<String> stream = Stream.of("one","two","three","four");
        boolean match = stream.anyMatch(s -> s.length() > 0 && Character.isLowerCase(s.charAt(0)));
        System.out.println(match);
    }

    public static void main(String[] args) {
        allMatch();
        allMatch2();
        allMatch3();
    }
}
