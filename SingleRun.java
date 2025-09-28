package Multithreading;


class Run extends Thread
{
    @Override
    synchronized public void run()
    {
        String name = Thread.currentThread().getName(); // ✅ Correct way

         if(name.equals("cricket"))
        {
            try {
                cricket();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(name.equals("kabaddi"))
        {
            try {
                kabaddi();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
     public void cricket() throws Exception
    {
        System.out.println("Cricket Started");
        System.out.println("Toss");
        Thread.sleep(3000);
        System.out.println("First innings completed");
        Thread.sleep(3000);
        System.out.println("Second innings yet to start");
        Thread.sleep(3000);
        System.out.println("Second innings started");
        Thread.sleep(3000);
        System.out.println("Second innings completed");
        Thread.sleep(3000);
        System.out.println("Match completed");
    }
    
    public void kabaddi() throws Exception
    {
        System.out.println("Kabaddi Started");
        Thread.sleep(3000);
        System.out.println("Toss");
        Thread.sleep(3000);
        System.out.println("First half completed");
        Thread.sleep(3000);
        System.out.println("Second half completed");
        Thread.sleep(3000);
        System.out.println("Match finished");
    }
}

public class SingleRun {

    public static void main(String[] args) {
        
        Run r1 = new Run();
        Run r2 = new Run();
        
        r1.setName("cricket");
        r2.setName("kabaddi");
        
        r1.start();
        r2.start();
    }
}
