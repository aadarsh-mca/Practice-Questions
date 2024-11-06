class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }

    int getCount() {
        return count;
    }
}

public class TestMultiThreading {
    
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for(int i=0; i<100; i++) {
                    counter.increment();
                    System.out.println("Count Thread 1 : " + counter.getCount());
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int i=0; i<100; i++) {
                counter.increment();
                System.out.println("Count Thread 2 : " + counter.getCount());
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final count : " + counter.getCount());
    }


}