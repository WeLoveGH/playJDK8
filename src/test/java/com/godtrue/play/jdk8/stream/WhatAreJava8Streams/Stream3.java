package com.godtrue.play.jdk8.stream.WhatAreJava8Streams;

import java.util.Arrays;
import java.util.List;

/**
 * @description：
 *
 * Finding sum of all even numbers
 *
 * @author：qianyingjie1
 * @create：2020-01-02
 */
public class Stream3 {
    private static final void old(List<Integer> list){
        int sum = 0;
        for (Integer integer : list){
            if(integer % 2 == 0){
                sum += integer;
            }
        }
        System.out.println("sum is : " + sum);
    }

    /**
     * 过滤器+求和
     * @param list
     */
    private static final void jdk8(List<Integer> list){
        int sum = list.stream()
                .filter(i -> i%2 ==0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("sum is : " + sum);
    }

    private static final void jdk8_1(List<Integer> list){
        int sum = list.stream()
                .filter(i -> i%2 ==0)
                .reduce(0,(i,c) -> i + c);
        System.out.println("sum is : " + sum);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        old(list);
        jdk8(list);
        jdk8_1(list);
    }
}
