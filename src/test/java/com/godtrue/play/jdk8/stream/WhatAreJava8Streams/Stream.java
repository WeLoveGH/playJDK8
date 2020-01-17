package com.godtrue.play.jdk8.stream.WhatAreJava8Streams;

import java.util.Arrays;
import java.util.List;

/**
 * @description：
 *
 * counting even number in a list
 *
 * @author：qianyingjie1
 * @create：2020-01-02
 */
public class Stream {
    private static final void old(List<Integer> list){
        int count = 0;
        for (Integer integer : list){
            if(integer % 2 == 0){
                count++;
            }
        }
        System.out.println("count is : " + count);
    }

    /**
     * 过滤器+计数器
     * @param list
     */
    private static final void jdk8(List<Integer> list){
        long count = list.stream()
                .filter(i -> i%2 ==0)
                .count();
        System.out.println("count is : " + count);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        old(list);
        jdk8(list);
    }
}
