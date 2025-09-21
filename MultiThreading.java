package Multithreading;
import java.util.Scanner;

class AddNum extends Thread {
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        int sum = a + b;
        System.out.println("Sum = " + sum);
    }
}
class  PrintNum extends  Thread
{
    @Override
    public  void  run()
    {
        System.out.println("Printing numbers");
        for(int i=1;i<=10;i++)
        {
            try {
                System.out.println(i);
                Thread.sleep(3000);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
}

class PrintChar extends  Thread
{
    @Override
    public  void run()
    {
        for (char c='a';c<='e';c++)
        {
            try{
                System.out.println(c);
                Thread.sleep(3000);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
public class MultiThreading {
    public static void main(String[] args) {
        AddNum add = new AddNum();
        PrintNum num=new PrintNum();
        PrintChar cha=new  PrintChar();

        add.start();
        num.start();
        cha.start();
    }
}
