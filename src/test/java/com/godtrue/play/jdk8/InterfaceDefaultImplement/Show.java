package com.godtrue.play.jdk8.InterfaceDefaultImplement;

/**
 * @description：展示接口
 * @author：qianyingjie1
 * @create：2020-01-02
 */
public interface Show {
    default void show(){
        System.out.println("i am a Show.show");
    }

    void say();
}
