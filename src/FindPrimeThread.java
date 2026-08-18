public class FindPrimeThread {


    //    Basic Thread Implementation
    static void findPrimes(int start, int end) {

        int count = 0;

        for (int number = start; number <= end; number++) {

            if (number < 2) {
                continue;
            }

            boolean isPrime = true;

            for (int i = 2; i * i <= number; i++) {

                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
            }
        }

        System.out.println(
                Thread.currentThread().getName()
                + " → Prime count = " + count
        );
    }

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        Thread t1 = new Thread(
                () -> findPrimes(1, 10_000_000),
                "Thread-1"
        );

        Thread t2 = new Thread(
                () -> findPrimes(10_000_001, 20_000_000),
                "Thread-2"
        );

        Thread t3 = new Thread(
                () -> findPrimes(20_000_001, 30_000_000),
                "Thread-3"
        );

        Thread t4 = new Thread(
                () -> findPrimes(30_000_001, 40_000_000),
                "Thread-4"
        );

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        long endTime = System.currentTimeMillis();

        System.out.println("Total Time = "
                           + (endTime - startTime) + " ms");
    }
}