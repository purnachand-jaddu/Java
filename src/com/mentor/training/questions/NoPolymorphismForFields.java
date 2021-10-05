package com.mentor.training.questions;

public class NoPolymorphismForFields {

    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.a);

        B b = new B();
        System.out.println(b.a);

        A c = new B();
        System.out.println(c.a);
    }
}

class A
{
    int a = 5;
}

class B extends A
{
    int a = 6;
}
