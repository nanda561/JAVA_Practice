package Multithreading;

class Captain extends Thread {
    @Override
    public void run() {
        System.out.println("Captain: Leading the team...");
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Captain action " + i);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("Captain interrupted");
        }
        System.out.println("Captain: Finished duties");
    }
}

class BowlingCoach extends Thread {
    @Override
    public void run() {
        while (true) { // infinite background training
            System.out.println("BowlingCoach: Practicing bowling techniques...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("BowlingCoach interrupted");
                break;
            }
        }
        System.out.println("BowlingCoach: Ended training");
    }
}

class BattingCoach extends Thread {
    @Override
    public void run() {
        while (true) { // infinite background training
            System.out.println("BattingCoach: Practicing batting techniques...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("BattingCoach interrupted");
                break;
            }
        }
        System.out.println("BattingCoach: Ended training");
    }
}

public class DameonThreading {
    public static void main(String[] args) {
        Captain captain = new Captain();
        BowlingCoach bowlingCoach = new BowlingCoach();
        BattingCoach battingCoach = new BattingCoach();

        // Make coaches daemon threads
        bowlingCoach.setDaemon(true);
        battingCoach.setDaemon(true);

        // Start threads
        captain.start();
        bowlingCoach.start();
        battingCoach.start();
      

        // main thread ends after captain finishes
        System.out.println("Main: Game day started!");
    }
}
