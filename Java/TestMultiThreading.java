class Counter implements Runnable {
    public void run() {
        for(int i=1; i<=5; i++) {
            System.out.println(i + " from my thread");
        }
    }
    public void run(int a) {
        for(int i=1; i<=5; i++) {
            System.out.println(i + " from my run() overloaded");
        }
    }
}

public class TestMultiThreading {
    
    public static void main(String[] args) throws InterruptedException, IllegalMonitorStateException {
        Counter counter = new Counter();

        Thread evenThread = new Thread(new Runnable() {
            public void run() {
                for(int i=0; i<=20; i++) {
                    if(i % 2 == 0) {
                        System.out.println(i + " - ");
                    }
                }
            }
        });
        Thread oddThread = new Thread(() -> {
            for(int i=0; i<=20; i++) {
                if(i % 2 != 0) {
                    System.out.println(i + ", ");
                }
            }
        });
        evenThread.start();
        oddThread.start();

    }


}