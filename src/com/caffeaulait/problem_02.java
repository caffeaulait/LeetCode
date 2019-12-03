package com.caffeaulait;

import java.util.Collections;

public class problem_02 {

}


class GiantDragon{
    /**
     * 饿汉式，无论是否用到这个对象，都会加载，如果在构造方法里写了性能消耗较大，占时较久的代码，比如数据库的建立，就会在启动的时候感觉卡顿
     */

    private GiantDragon(){

    }

    private static GiantDragon instance= new GiantDragon();

    public static GiantDragon getInstance(){
        return instance;
    }
}


class Roshan{

    /**
     * 懒汉式，延迟加载，只有使用的时候才会加载，并且有线程安全的考量，使用懒汉式，在启动的时候，会感觉到比饿汉式略快，
     * 因为并没有做对象的实例化。 但是在第一次调用的时候，会进行实例化操作，感觉上就略慢。
     */

    private Roshan(){

    }

    private static Roshan instance;

    public static Roshan getInstance(){
        if (instance == null){
            instance = new Roshan();
        }
        return instance;
    }

}