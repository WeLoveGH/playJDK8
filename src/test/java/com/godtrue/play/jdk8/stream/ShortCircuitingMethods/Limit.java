package com.godtrue.play.jdk8.stream.ShortCircuitingMethods;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2020-01-05
 */
public class Limit {
    private static final void runWithoutLimit(IntStream stream){
        System.out.println("\nRunning without limit()");
        stream.filter(i -> i % 2 == 0)
                .forEach(System.out::println);
    }

    private static final void runWithLimit(IntStream stream){
        System.out.println("\nRunning with limit(2)");
        stream.filter(i -> i % 2 == 0)
                .limit(2)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        int [] ints = {1,2,3,4,5,6,7,8,9};
        System.out.printf("Source: %s%n", Arrays.toString(ints));
        System.out.println("\nFinding even numbers");
        runWithLimit(Arrays.stream(ints));
        runWithoutLimit(Arrays.stream(ints));
    }
}
