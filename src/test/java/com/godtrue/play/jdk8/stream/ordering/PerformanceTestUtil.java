package com.godtrue.play.jdk8.stream.ordering;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2020-01-05
 */
public class PerformanceTestUtil {
    public static final void runTest(String msg,Runnable runnable){
        setPrintStreamDisabled(true);

        runnable.run();
        setPrintStreamDisabled(false);

        long startTime = getTimeElapsed(0);
        runnable.run();
        System.out.printf("%s time taken: %s%n",msg,timeToString(getTimeElapsed(startTime)));
    }

    private static final String timeToString(long nanos){
        Optional<TimeUnit> first = Stream.of(TimeUnit.DAYS,TimeUnit.HOURS,TimeUnit.MINUTES,TimeUnit.SECONDS,TimeUnit.MILLISECONDS,TimeUnit.MICROSECONDS)
                .filter(u -> u.convert(nanos,TimeUnit.NANOSECONDS) > 0)
                .findFirst();
        TimeUnit unit = first.isPresent() ? first.get() : TimeUnit.NANOSECONDS;
        double value = (double) nanos / TimeUnit.NANOSECONDS.convert(1,unit);
        return String.format("%.4g %s",value,unit.name().toLowerCase());
    }

    private static final long getTimeElapsed(long startTime){
        return System.nanoTime() - startTime;
    }

    private static final void setPrintStreamDisabled(boolean b){
        if(b){
            System.out.println(blankPrintStream);
        }else{
            System.out.println(originalPrintStream);
        }
    }

    private static final PrintStream originalPrintStream = System.out;

    private static final PrintStream blankPrintStream = new PrintStream(new OutputStream() {
        @Override
        public void write(int b) throws IOException {

        }

        @Override
        public void write(byte [] b,int off,int len) throws IOException{

        }
    });
}
