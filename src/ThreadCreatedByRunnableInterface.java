public class ThreadCreatedByRunnableInterface implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        ThreadCreatedByRunnableInterface threadTest = new ThreadCreatedByRunnableInterface();
        Thread thread = new Thread(threadTest);
        thread.start();
    }
}
