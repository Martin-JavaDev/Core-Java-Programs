public class MulitpleThreads {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> System.out.println("Thread 1 Started"), "Thread-1");

        Thread t2 = new Thread(() -> System.out.println("Thread 2 Started"), "Thread-2");

        Thread t3 = new Thread(() -> System.out.println("Thread 3 Started"), "Thread-3");

        Thread t4 = new Thread(() -> System.out.println("Thread 4 Started"), "Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
//        Waiting thread to complete
        System.out.println("Main Thread Ended");
    }
}
