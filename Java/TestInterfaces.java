interface SomeInterface {
    void abstractMethod();

    default void defaultMethod_1() {
        System.out.println("Deafult method 1...");
    }

    default void defaultMethod_2() {
        System.out.println("Deafult method 2...");
    }
}

interface SomeOtherInterface extends SomeInterface {

}

public class TestInterfaces implements SomeInterface {
    
    @Override
    public void defaultMethod_1() {
        System.out.println("Deafult Method 1...implemented in child class.....");
    }

    @Override
    public void abstractMethod() {
        defaultMethod_1();
        // SomeInterface.super.defaultMethod_1();
        defaultMethod_2();
    }

    public static void main(String[] args) {
        TestInterfaces obj = new TestInterfaces();
        
        obj.abstractMethod();
    }
}
