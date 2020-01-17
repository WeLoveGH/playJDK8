package com.godtrue.play.jdk8.stream.ShortCircuitingMethods;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2020-01-05
 */
public class NoneMatch {
    private static final void noneMatch(){
        IntStream stream = IntStream.of(1,2,3,4,5,6,7,8,9);
        boolean match = stream.noneMatch(i -> i % 1 == 0);
        System.out.println(match);
    }

    private static final void noneMatch2(){
        IntStream stream = IntStream.of(1,2,3,4,5,6,7,8,9);
        boolean match = stream.noneMatch(i -> i % 13 == 0);
        System.out.println(match);
    }

    private static final void noneMatch3(){
        Stream<String> stream = Stream.of("one","two","three","four");
        boolean match = stream.noneMatch(s -> s.length() > 0 && Character.isUpperCase(s.charAt(0)));
        System.out.println(match);
    }

    public static void main(String[] args) {
        noneMatch();
        noneMatch2();
        noneMatch3();
    }
}
