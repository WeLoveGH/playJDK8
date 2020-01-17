package com.godtrue.play.jdk8.stream.WhatAreJava8Streams;

import java.util.Arrays;
import java.util.List;

/**
 * @description：
 *
 * Finding whether all integers are less than 10 in the list
 *
 * @author：qianyingjie1
 * @create：2020-01-02
 */
public class Stream4 {
    private static final void old(List<Integer> list){
        boolean b = true;
        for (Integer integer : list){
            if(integer >= 10){
                b = false;
                break;
            }
        }
        System.out.println("b is : " + b);
    }

    /**
     * 是否全匹配
     * @param list
     */
    private static final void jdk8(List<Integer> list){
        boolean b = list.stream()
                .allMatch( i -> i < 10);
        System.out.println("b is : " + b);
    }

    /**
     * 是否任意一个能匹配
     * @param list
     */
    private static final void jdk8_1(List<Integer> list){
        boolean b = list.stream()
                .anyMatch(i -> i >= 10);
        System.out.println("b is : " + b);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        old(list);
        jdk8(list);
        jdk8_1(list);
    }
}
