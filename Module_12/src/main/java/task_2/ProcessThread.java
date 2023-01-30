package task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProcessThread extends Thread {

    private int number;
    private AtomicBoolean processed = new AtomicBoolean(true);
    private NumberProcessor processor;

    public ProcessThread(NumberProcessor processor) {
        this.processor = processor;
    }

    public void process(int number) {
        this.number = number;
        processed.set(false);
    }

    public boolean isProcessed() {
        return processed.get();
    }

    @Override
    public void run() {
        while (true) {
            if (processed.get()) {
                continue;
            }
            processor.process(number);
            processed.set(true);
        }
    }

    public static List<ProcessThread> createThreads() {
        ProcessThread fizzThread = new ProcessThread(n -> {
            if (n % 3 == 0 && n % 15 != 0) {
                System.out.println("fizz");
            }
        });

        ProcessThread buzzThread = new ProcessThread(n -> {
            if (n % 5 == 0 && n % 15 != 0) {
                System.out.println("buzz");
            }
        });

        ProcessThread fizzbuzzThread = new ProcessThread(n -> {
            if (n % 15 == 0) {
                System.out.println("fizzbuzz");
            }
        });

        ProcessThread numberThread = new ProcessThread(n -> {
            if (n % 5 != 0 && n % 3 != 0) {
                System.out.println(n);
            }
        });

        List<ProcessThread> threads = new ArrayList<>();
        threads.add(fizzbuzzThread);
        threads.add(fizzThread);
        threads.add(buzzThread);
        threads.add(numberThread);

        return threads;
    }

    public static void print(int number, List<ProcessThread> threads) {
        for (int i = 1; i <= number; i++) {
            for (ProcessThread thread : threads) {
                thread.process(i);
            }
            while (true) {
                int processedCount = 0;
                for (ProcessThread thread : threads) {
                    if (thread.isProcessed()) {
                        processedCount++;
                    }
                }
                if (processedCount == threads.size()) {
                    break;
                }
            }
        }
    }
}

