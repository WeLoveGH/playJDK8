package com.godtrue.play.jdk8.stream.StreamLazyEvaluation;

import java.time.LocalTime;
import java.util.stream.IntStream;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2020-01-04
 */
public class LazyEvaluation {
    private static final void sequential(){
        IntStream stream = IntStream.range(1,5);
        stream = stream.peek(i -> log("starting",i))
                .filter(i -> {
                   log("filtering",i);
                   return i % 2 ==0;
                })
                .peek(i -> log("post filtering"));
        log("Invoking terminal method count");
        log("The count is ",stream.count());
    }

    private static final void parallel(){
        IntStream stream = IntStream.range(1,5).parallel();
        stream = stream.peek(i -> log("starting",i))
                .filter(i -> {
                    log("filtering",i);
                    return  i % 2 == 0;
                })
                .peek(i -> log("post filtering",i));
        log("Invoking terminal method count");
        log("The count is ",stream.count());
    }

    private static final void log(Object... objects){
        String s = LocalTime.now().toString();
        for (Object object : objects){
            s += " - " + object.toString();
        }
        System.out.println(s);
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        sequential();

        System.out.println("\n\n\n");

        parallel();
    }
}
