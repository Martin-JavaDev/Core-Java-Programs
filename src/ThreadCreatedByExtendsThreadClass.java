public class ThreadCreatedByExtendsThreadClass extends Thread {

    @Override
    public void run() {
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {

        ThreadCreatedByExtendsThreadClass threadTest = new ThreadCreatedByExtendsThreadClass();
        threadTest.start();
    }

}
