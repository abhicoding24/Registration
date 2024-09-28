package com.api;

public class B {
    public static void main(String[]args){
        B b = new B();
        int val = b.test();
        System.out.println(val);
        D d = new D();
        d.test2();
    }
    public int test(){
        C c = new C();
        c.test1();
        return 100;
    }
}
