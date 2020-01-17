package com.godtrue.play.jdk8.stream.ordering;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2020-01-05
 */
public class Sorted {
    private static final void sorted(){
        Set<Integer> set = new HashSet<>(Arrays.asList(2,1,3));
        Object[] objects = set.stream().sorted().toArray();
        System.out.println(Arrays.toString(objects));
    }

    public static void main(String[] args) {
        sorted();
    }
}
