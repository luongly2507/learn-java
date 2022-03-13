package Threads_And_The_Concurrency;
public class ThreadSleepDemo {
    public static void main(String[] args) {
        // Create Runnable
        boolean isDaemon = true;

        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            int count = 0;
            while (!Thread.interrupted()){
                System.out.println(name + ": "+count++);
            }
        };

        Thread threadOne = new Thread(runnable, "Thread One");
        Thread threadTwo = new Thread(runnable, "Thread Two");

        threadOne.start();
        threadTwo.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadOne.interrupt();
        threadTwo.interrupt();
    }
}
