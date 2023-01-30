package task_2;

import java.util.List;


public class ThreadsTest {
    public static void main(String[] args) {
        List <ProcessThread> threads = ProcessThread.createThreads();

        for (ProcessThread thread : threads) {
            thread.start();
        }


        ProcessThread.print(50, threads);


    }
}
