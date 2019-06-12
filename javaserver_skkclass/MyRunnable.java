package javaserver_skkclass;
import java.lang.Runnable;
import java.lang.Thread;

public class MyRunnable implements Runnable{

    public void run(){
        System.out.println("top o' the stack : 1");
    }

    public static void main(String[] args){
        //make a runnable object
        Runnable threadJob = new MyRunnable();
        //make a Thread object
        Thread myThread = new Thread(threadJob);
        //start thread
        myThread.start();
        System.out.println("back in main");
    }
}