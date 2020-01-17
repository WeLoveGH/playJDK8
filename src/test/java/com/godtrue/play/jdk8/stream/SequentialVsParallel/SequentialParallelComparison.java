package com.godtrue.play.jdk8.stream.SequentialVsParallel;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2020-01-04
 */
public class SequentialParallelComparison {
    public static void main(String[] args) {
        String [] strings = {"1","2","3","4","5","6","7","8","9"};
        System.out.println("\nRunning sequential\n");
        long startTime = System.nanoTime();
        run(Arrays.stream(strings).sequential());
        long endTime = System.nanoTime();
        long costTime4Sequential = endTime - startTime;
        System.out.println("Running sequential cost time is : " + costTime4Sequential);



        System.out.println("\nRunning parallel\n");
        startTime = System.nanoTime();
        run(Arrays.stream(strings).parallel());
        endTime = System.nanoTime();
        long costTime4Parallel = endTime - startTime;
        System.out.println("Running parallel cost time is : " + costTime4Parallel);

        System.out.println("\nSequential Vs Parallel is : " + (costTime4Sequential - costTime4Parallel));
    }

    public static final void run(Stream<String> stream){
        stream.forEach(s -> {
            System.out.println(LocalTime.now() + " - value: " + s + " - thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
    }
}

/*

通过观察日志可以发下：

1：串行执行，是一个执行完，另个才能开始执行，相对来数花费的时间更多
2：并行执行，能充分利用多核的优势，执行的速度更快效率更高

Running sequential

17:59:21.206 - value: 1 - thread: main
17:59:21.407 - value: 2 - thread: main
17:59:21.607 - value: 3 - thread: main
17:59:21.807 - value: 4 - thread: main
17:59:22.007 - value: 5 - thread: main
17:59:22.207 - value: 6 - thread: main
17:59:22.407 - value: 7 - thread: main
17:59:22.607 - value: 8 - thread: main
17:59:22.807 - value: 9 - thread: main
Running sequential cost time is : 1928717960

Running parallel

17:59:23.012 - value: 6 - thread: main
17:59:23.013 - value: 3 - thread: ForkJoinPool.commonPool-worker-1
17:59:23.013 - value: 2 - thread: ForkJoinPool.commonPool-worker-2
17:59:23.013 - value: 4 - thread: ForkJoinPool.commonPool-worker-3
17:59:23.213 - value: 1 - thread: ForkJoinPool.commonPool-worker-3
17:59:23.214 - value: 8 - thread: ForkJoinPool.commonPool-worker-2
17:59:23.214 - value: 5 - thread: main
17:59:23.214 - value: 7 - thread: ForkJoinPool.commonPool-worker-1
17:59:23.413 - value: 9 - thread: ForkJoinPool.commonPool-worker-3
Running parallel cost time is : 606031409

Sequential Vs Parallel is : 1322686551

 */