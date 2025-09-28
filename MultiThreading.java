package Multithreading;

import java.util.Scanner;

class MyTask implements Runnable {
    private String taskName;

    static {
        System.out.println("Static block from MyTask");
    }

    MyTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            switch (taskName) {
                case "add":
                    addNumbers();
                    break;
                case "printNum":
                    printNumbers();
                    break;
                case "printChar":
                    printChars();
                    break;
                default:
                    System.out.println("Unknown Task");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void addNumbers() {
        System.out.println("Adding Started");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number: ");
        int a = sc.nextInt();
        System.out.println("Enter second number: ");
        int b = sc.nextInt();

        int sum = a + b;
        System.out.println("Sum = " + sum);
        System.out.println("Adding Finished");

        sc.close();
    }

    private void printNumbers() throws InterruptedException {
        System.out.println("Printing Numbers");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            Thread.sleep(3000);
        }
        System.out.println("Printing Numbers Finished");
    }

    private void printChars() throws InterruptedException {
        System.out.println("Printing Characters");
        for (char c = 'a'; c <= 'e'; c++) {
            System.out.println(c);
            Thread.sleep(3000);
        }
        System.out.println("Printing Characters Finished");
    }
}

public class MultiThreading {
    public static void main(String[] args) throws InterruptedException {
    	
        Thread t1 = new Thread(new MyTask("add"));
        Thread t2 = new Thread(new MyTask("printNum"));
        Thread t3 = new Thread(new MyTask("printChar"));

        t1.start();
        t1.join(); // wait for addNumbers() to finish before others
        t2.start();
        t3.start();
    }
}
