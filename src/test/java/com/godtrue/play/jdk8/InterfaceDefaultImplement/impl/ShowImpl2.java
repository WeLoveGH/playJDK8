package com.godtrue.play.jdk8.InterfaceDefaultImplement.impl;

import com.godtrue.play.jdk8.InterfaceDefaultImplement.Show;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2020-01-02
 */
public class ShowImpl2 implements Show{
    @Override
    public void show() {
        System.out.println("i am ShowImpl2.show");
    }

    @Override
    public void say() {
        System.out.println("i am ShowImpl2.say");
    }
}
