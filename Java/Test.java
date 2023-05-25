class A {
    public void print() {
        System.out.println("A");
    }
}

class B extends A {
    public void print() {
        System.out.println("B");
    }
}

class C extends B {
    public void print() {
        System.out.println("C");
    }
}

class CustomException extends Exception {
    String msg;
    CustomException (String msg) {
        // super(msg);
        this.msg = msg;
    }

    String getErrorMsg() {
        return msg;
    }
}

class Test {
    public static void main(String[] args) {
        try {
            throw new CustomException("Custom Exception thrown");
        } catch (CustomException e) {
            System.out.println("Custom exception mgs : " + e.getErrorMsg());
        }
    }

}

// class SuperClass {
//     void abc(Number n) {
//         System.out.println("Super");
//     }
// }

// class SubClass extends SuperClass {
//     void abc(Double n) {
//         System.out.println("Sub");
//     }
// }

// public class Test {
//     public static void main(String[] args) {
//         SubClass obj = new SuperClass();
//         obj.abc(123321);
//     }
// }
