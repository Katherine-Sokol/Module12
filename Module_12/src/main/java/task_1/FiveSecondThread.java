package task_1;

public class FiveSecondThread extends Thread{
    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Thread.sleep(5000);
                System.out.println("Минуло 5 секунд");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " перервано!");
                Thread.currentThread().interrupt();
            }
        }
    }
}
