package designpatterns23;

/**
 * 关于多态的几种方法(下面的一段说明可以看一看)
 * Created by lizhen on 2017/12/19.
 * 一是子类与父类的关系，二是重载方法的调用问题。
 * 子类对象可以直接当成父类对象使用，但反过来就不可以。
 * 举例来说，人是父类，学生是人的子类，所以学生对象一定具备人对象的属性，但是人对象就未必具有学 生对象的特性。
 * 所以学生对象可以当做人对象来使用，但是人对象就不能当做学生对象使用。
 * 注意当把子类对象当成父类对象使用时，子类对象将失去所有的子类特性，只保留与父类同名的属性和方法
 * （同名方法不仅是函数名相同，而且参数类型也要一样，否则不予保留）。
 *  一个类中如果定义了重载的方法，则系统在调用方法时，会根据参数的类型自动选择调用合适的方法。
 */
public class polymorphism {

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println(a1.show(b));   //① aa
        System.out.println(a1.show(c));   //② aa
        System.out.println(a1.show(d));   //③ ad
        System.out.println(a2.show(b));   //④ ba
        System.out.println(a2.show(c));   //⑤ ba
        System.out.println(a2.show(d));  // ⑥ ad
        System.out.println(b.show(b));    //⑦ bb
        System.out.println(b.show(c));    //⑧ bb
        System.out.println(b.show(d));    //⑨ ad
    }


}

class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }
}

class B extends A {
    public String show(B obj) {
        return ("B and B");
    }

    public String show(A obj) {
        return ("B and A");
    }
}

class C extends B { }

class D extends B {}
