import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

class Resource {
    private static int a = 0;

    // List<Integer> list = new ArrayList<>(List.of(0));
    // Vector<Integer> list = new Vector<>(List.of(0));

    /*synchronized*/ void increment() {
        // synchronized(this) {
            a++;
            System.out.println("Updated by : " + Thread.currentThread().getName() + " to :: " + a);
            // list.set(0, list.get(0)+1);
            // System.out.println("Updated by : " + Thread.currentThread().getName() + " to :: " + list.get(0));
        // }
    }
}

public class TestThread {
    
    private Integer balance = 100;

    // private ReentrantLock relock = new ReentrantLock();

    void increaseBalance(TestThread obj) {
        // synchronized(obj) {
            balance += 10;

            try {
                new Thread(() -> {
                    for (int i = 0; i < 5; i++) {
                        System.out.print(".");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        // }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 has started....");
            try {
                Thread.sleep(5000);
            } catch(Exception e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1 has ended....");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 has started....");
            t1.interrupt();
            System.out.println("Thread 2 has ended....");
        });

        t1.start();
        t2.start();
    }

    public static void main2(String[] args) {
        TestThread obj = new TestThread();

        Thread t1 = new Thread(() -> {
            System.out.println("t1 started....");

            obj.increaseBalance(obj);

            System.out.println("t1 ended.... balance :: " + obj.balance);
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2 started....");

            obj.increaseBalance(obj);

            System.out.println("t2 ended.... balance :: " + obj.balance);
        });

        t1.start();
        t2.start();

    }

    public static void main1(String[] args) throws InterruptedException {

        Resource r1 = new Resource();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i < 100; i++) {

                    // synchronized(r1) {
                        // Resource.a++;
                        // System.out.println("Updated by : " + Thread.currentThread().getName() + " to :: " + r1.a);
                    // }

                    r1.increment();

                    try {
                        Thread.sleep(10);
                    } catch(InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i < 100; i++) {
                
                    // synchronized(r1) {
                        // Resource.a++;
                        // System.out.println("Updated by : " + Thread.currentThread().getName() + " to :: " + r1.a);
                    // }

                    r1.increment();

                    try {
                        Thread.sleep(10);
                    } catch(InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });



        t1.start();
        t2.start();

        t1.join();
        t2.join();

        t1.wait();
        t2.wait();

        System.out.println("\n===== [ Main finished !!! ] =====\n");
    }


}
