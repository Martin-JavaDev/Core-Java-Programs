public class ThreadCreatedByLamdaExp {

    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println("Thread is running");
        };
        Thread t = new Thread(r);
        t.start();
    }
}
