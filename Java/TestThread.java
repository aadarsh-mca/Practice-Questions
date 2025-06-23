import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
    
    public static void main(String[] args) throws InterruptedException {

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

        // t1.join();
        // t2.join();

        System.out.println("\n===== [ Main finished !!! ] =====\n");
    }


}
