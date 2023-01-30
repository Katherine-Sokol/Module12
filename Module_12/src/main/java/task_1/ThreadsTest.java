package task_1;

public class ThreadsTest {

    public static void main(String[] args) {
        Thread thread1 = new OneSecondThread();
        Thread thread2 = new FiveSecondThread();
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " перервано!");
            Thread.currentThread().interrupt();
        }
        thread1.interrupt();
        thread2.interrupt();
    }
}
