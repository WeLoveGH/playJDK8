package com.godtrue.play.jdk8.stream.ShortCircuitingMethods;

import java.util.stream.Stream;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2020-01-05
 */
public class Limit2 {
    private static final int MAX_LIMIT_NUMBER = 10;

    private static final void runWithLimit(int limit){
        System.out.println("\nRunning runWithLimit\nThe limit is : " + limit);
        Stream<Integer> stream = Stream.iterate(1,i -> i + 1);
        stream.filter(i -> i % 2 == 0)
                .limit(limit)
                .forEach(System.out::println);
    }

    private static final void runWithLimit2(int limit){
        System.out.println("\nRunning runWithLimit2\nThe limit is : " + limit);
        Stream<Integer> stream = Stream.iterate(1,i -> i + 1);
        stream.limit(limit)
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        for (int i = 0; i <= Limit2.MAX_LIMIT_NUMBER; i++) {
            runWithLimit(i);
            runWithLimit2(i);
        }
    }
}

/*

通过日志观察，我们可以得到如下的观点：

1：limit的使用位置很重要
2：limit的作用就是找到对应的数据，就不再继续执行了

Running runWithLimit
The limit is : 0

Running runWithLimit2
The limit is : 0

Running runWithLimit
The limit is : 1
2

Running runWithLimit2
The limit is : 1

Running runWithLimit
The limit is : 2
2
4

Running runWithLimit2
The limit is : 2
2

Running runWithLimit
The limit is : 3
2
4
6

Running runWithLimit2
The limit is : 3
2

Running runWithLimit
The limit is : 4
2
4
6
8

Running runWithLimit2
The limit is : 4
2
4

Running runWithLimit
The limit is : 5
2
4
6
8
10

Running runWithLimit2
The limit is : 5
2
4

Running runWithLimit
The limit is : 6
2
4
6
8
10
12

Running runWithLimit2
The limit is : 6
2
4
6

Running runWithLimit
The limit is : 7
2
4
6
8
10
12
14

Running runWithLimit2
The limit is : 7
2
4
6

Running runWithLimit
The limit is : 8
2
4
6
8
10
12
14
16

Running runWithLimit2
The limit is : 8
2
4
6
8

Running runWithLimit
The limit is : 9
2
4
6
8
10
12
14
16
18

Running runWithLimit2
The limit is : 9
2
4
6
8

Running runWithLimit
The limit is : 10
2
4
6
8
10
12
14
16
18
20

Running runWithLimit2
The limit is : 10
2
4
6
8
10

 */