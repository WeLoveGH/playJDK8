package com.godtrue.play.jdk8.stream.WhatAreJava8Streams;

import java.util.Arrays;
import java.util.List;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2020-01-02
 */
public class NewVsOldForEach {
    private static final void oldForEach(List<String> list){
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * using lambda expression
     * @param list
     */
    private static final void newForEach(List<String> list){
        list.forEach(s -> System.out.println(s));
    }

    /**
     * using method reference on System.out instance
     * @param list
     */
    private static final void newForEach2(List<String> list){
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Tom","Jim","Doug");
        oldForEach(list);
        newForEach(list);
        newForEach2(list);
    }
}
