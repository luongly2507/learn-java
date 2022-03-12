package Threads_And_The_Concurrency;
public class ThreadInterruptedDemo {
    
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

        // busy loop
        while(true){
            double n = Math.random();
            if (n >= 0.49999999 && n <= 0.50000001){
                break;
            }
        }
        threadOne.interrupt();
        threadTwo.interrupt();
    }
}
