package Multithreading;

class Queue 
{
	private int data=0;
	private boolean isPresent=false;

	synchronized public void setData(int data)
	{
		if(!isPresent)
		{
			this.data=data;
			System.out.println("Producer produced the data : "+data);
			isPresent=true;
			notify();
		}
		else
		{
			try {
				wait(30000);
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	synchronized public void getData()
	{
		if(isPresent==true)
		{
			System.out.println("Consumer consumed the data : "+data);
			isPresent=false;
			notify();
		}
		else
		{
			try {
				wait(30000);
				Thread.sleep(3000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}

class Producer extends Thread
{
	Queue q;
	Producer(Queue q)
	{
		this.q=q;	
	}
	@Override
	public void run() {
		int i=0;
		while(true)
		{
			q.setData(i++);
		}

	}	
}

class Consumer extends Thread
{
	Queue q;
	Consumer(Queue q)
	{
		this.q=q;
	}

	@Override
	public void run() {
		while(true)
		{
			q.getData();
		}
	}
}

public class ProduceConsumer {
	public static void main(String [] args) {

		Queue q = new Queue();
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);

		p.start();
		c.start();
	}
}
