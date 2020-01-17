package com.godtrue.play.jdk8.stream.ordering;

import java.util.stream.IntStream;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2020-01-05
 */
public class Skip {
    private static final void skip(){
        PerformanceTestUtil.runTest("unordered parallel skip",() ->{
            IntStream intStream = IntStream.range(1,1000 * 1000 * 100);
            intStream.unordered().parallel().skip(100).toArray();
        });

        PerformanceTestUtil.runTest("ordered parallel skip",() -> {
            IntStream intStream = IntStream.range(1,1000 * 1000 * 100);
            intStream.parallel().skip(1000).toArray();
        });
    }

    public static void main(String[] args) {
        skip();
    }
}
