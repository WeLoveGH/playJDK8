package com.godtrue.play.jdk8.InterfaceDefaultImplement;

import com.godtrue.play.jdk8.InterfaceDefaultImplement.impl.ShowImpl;
import com.godtrue.play.jdk8.InterfaceDefaultImplement.impl.ShowImpl2;

/**
 * @description：
 * @author：qianyingjie1
 * @create：2020-01-02
 */
public class Test {
    public static void main(String[] args) {
        Show show = new ShowImpl();
        show.show();
        show.say();


        Show show2 = new ShowImpl2();
        show2.show();
        show2.say();
    }
}
