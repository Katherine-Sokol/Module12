package task_1;

public class OneSecondThread extends Thread{
    private int count = 0;
    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Thread.sleep(1000);
                count++;
                System.out.println("Минуло " + count + " секунд від моменту запуску програми");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " перервано!");
                Thread.currentThread().interrupt();
            }
        }
    }
}
