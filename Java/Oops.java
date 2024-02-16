public class Oops {
    public static void main(String[] args) {
        // A a = new A();
        // a.show();

        // B b = new B();
        // b.show();

        // A a = new B();
        // a.show();
    }
}

/**
 * Concept of Inheritance
 * 
 * A a = new A();
 * a.show();
 * 
 * B b = new B();
 * b.show();
 * 
 * A a = new B();
 * a.show();
 * 
 */
class A {
    A() {
        System.out.println("in A");
    }
    void show() {
        System.out.println("show in A");
    }
}

class B extends A {
    B() {
        System.out.println("in B");
    }
    void show() {
        System.out.println("show in B");
    }
}