package com.godtrue.play.jdk8.stream.WhatAreJava8Streams;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description：
 *
 * Finding all sub-directory names in a directory. Using new static methods, Arrays#stream(T[] array)
 *
 * @author：qianyingjie1
 * @create：2020-01-02
 */
public class Stream5 {
    private static final void old(List<Integer> list){
        List<String> allDirNames = new ArrayList<>();
        for (File file : new File("d:\\").listFiles()){
            if(file.isDirectory()){
                allDirNames.add(file.getName());
            }
        }
        System.out.println("allDirNames is : " + allDirNames);
    }

    /**
     * 过滤器+收集器
     * @param list
     */
    private static final void jdk8(List<Integer> list){
        List<String> allDirNames = Arrays.stream(new File("d:\\").listFiles())
                .filter(File::isDirectory)
                .map(File::getName)
                .collect(Collectors.toList());
        System.out.println("allDirNames is : " + allDirNames);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        old(list);
        jdk8(list);
    }
}
