package com.godtrue.play.jdk8.stream.WhatAreJava8Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description：
 *
 * Retrieving even number list
 *
 * @author：qianyingjie1
 * @create：2020-01-02
 */
public class Stream2 {
    private static final void old(List<Integer> list){
        List<Integer> evenList = new ArrayList<>();
        int count = 0;
        for (Integer integer : list){
            if(integer % 2 == 0){
                evenList.add(integer);
            }
        }
        System.out.println("evenList is : " + evenList);
    }

    /**
     * 过滤器+收集器
     * @param list
     */
    private static final void jdk8(List<Integer> list){
        List<Integer> evenList = list.stream()
                .filter(i -> i%2 ==0)
                .collect(Collectors.toList());
        System.out.println("evenList is : " + evenList);
    }

    /**
     * 过滤器+迭代器
     * @param list
     */
    private static final void jdk8_1(List<Integer> list){
        list.stream()
                .filter(i -> i%2 ==0)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        old(list);
        jdk8(list);
        jdk8_1(list);
    }
}
