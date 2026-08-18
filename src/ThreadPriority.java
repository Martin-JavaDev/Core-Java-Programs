public class ThreadPriority {
//Thread priority is used to provide a scheduling hint to the JVM/OS. A higher-priority thread may receive scheduling preference over lower-priority threads, but priority does not guarantee execution order because actual scheduling is platform and OS dependent
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(ThreadPriority::doWork, "T1");
        Thread t2 = new Thread(ThreadPriority::doWork, "T2");
        Thread t3 = new Thread(ThreadPriority::doWork, "T3");

        t1.setPriority(3);
        t2.setPriority(10);
        t3.setPriority(1);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }

    static void doWork() {

        long sum = 0;

        for (long i = 0; i < 1_000_000_000L; i++) {
            sum += i;
        }

        System.out.println(
                Thread.currentThread().getName()
                + " completed"
        );
    }
}