package Threads_And_The_Concurrency;

public class ThreadDemo {
    public static void main(String[] args) {
        // Create Runnable
        boolean isDaemon = true;

        Runnable runnable = () -> {
            Thread thread = Thread.currentThread();
            while(true){
                System.out.printf("%s is %salive and in %s state%n",thread.getName(), thread.isAlive()?"":"not ",thread.getState());
            }
        };

        Thread threadOne = new Thread(runnable, "Thread One");
        threadOne.setDaemon(isDaemon);
        System.out.printf("%s is %salive and in %s state%n",threadOne.getName(), threadOne.isAlive()?"":"not ",threadOne.getState());

        Thread threadTwo = new Thread(runnable, "Thread Two");
        threadTwo.setDaemon(isDaemon);
        System.out.printf("%s is %salive and in %s state%n",threadTwo.getName(), threadTwo.isAlive()?"":"not ",threadTwo.getState());

        threadOne.start();
        threadTwo.start();

    }    
}
