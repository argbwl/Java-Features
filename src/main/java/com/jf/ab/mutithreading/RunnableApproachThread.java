package com.jf.ab.mutithreading;

import lombok.Getter;
import lombok.Setter;

public class RunnableApproachThread implements Runnable {
    private Thread thread;

    @Setter @Getter
    private int count;

    private static final int DEFAULT_MILLIS = 500;

    @Getter @Setter
    private String threadName;

    public RunnableApproachThread(String threadName) {
        //create a new thread :: apart from main thread
        thread = new Thread(this, threadName);
        System.out.println("new child created >> "+thread.getName());
    }

    public RunnableApproachThread(int count, String threadName) {
        this.count=10;
        this.threadName=threadName;
        //create a new thread :: apart from main thread
        thread = new Thread(this, threadName);
        System.out.println("new child created >> "+thread.getName());
    }

    public Thread getCurrentRunnableThread(){
        return this.thread;
    }


    @Override
    public void run() {
        //run method, this will have logic to execute programs
        System.out.println("Thread Started >> " + getCurrentRunnableThread());
        loopCount(this.getCount(),DEFAULT_MILLIS);
    }

    public void loopCount(int times, long millis){
        try {
            for (int k = 0; k <= times; k++) {
                System.out.println(Thread.currentThread().getName()+ " >> " + k);
                Thread.sleep(millis);
            }
            System.out.println(Thread.currentThread().getName()+" exiting");
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main() started");
        RunnableApproachThread runThread = new RunnableApproachThread("runThread-0");
        runThread.setCount(5);
        runThread.getCurrentRunnableThread().start();


        RunnableApproachThread runThread1 = new RunnableApproachThread(5, "runThread-1");
        runThread1.getCurrentRunnableThread().start();



        Thread thread1 = new RunnableApproachThread(2,"thread-1").getCurrentRunnableThread();
        thread1.join();
        //Priority does not work as expected on all OS, it may vary or not work
        thread1.setPriority(8);
        thread1.start();
        runThread.loopCount(5,1000);
        System.out.println("main() end");

    }




}
