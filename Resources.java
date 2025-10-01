package Multithreading;

class RoadPoneglyph extends Thread
{
	String res1="Road Poneglyph1";
	String res2="Road Poneglyph2";
	String res3="Road Poneglyph3";
	String res4="Road Poneglyph4";
	
	//boolean onepieceFound=false;

	@Override
	public void run() {
		
		
		String s=getName();

		if(s.equals("luffy"))
		{
			luffy();
			
		}
		else if(s.equals("blackBeard"))
		{
			blackBeard();
		
		}
		else if(s.equals("shanks"))
		{
			shanks();
			
		}
	}

	public void luffy()
	{
		try {
			Thread.sleep(3000);
			synchronized (res1) {
				System.out.println("Monkey D Luffy Accquired"+res1);
				Thread.sleep(3000);
				synchronized (res2) {
					System.out.println("Monkey D Luffy Accquired"+res2);
					Thread.sleep(3000);
					synchronized (res3) {
						System.out.println("Monkey D Luffy Accquired"+res3);
						Thread.sleep(3000);
						synchronized (res4) {
							System.out.println("Monkey D Luffy Accquired"+res4);

							System.out.println("...Monkey D Luffy Found the One piece... and Became King of Pirates");
							System.exit(0);

							
						}
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void blackBeard()
	{
		try {
			Thread.sleep(3000);
			synchronized (res1) {
				System.out.println("Black Beard Accquired"+res1);
				Thread.sleep(3000);
				synchronized (res2) {
					System.out.println("Black Beard Accquired"+res2);
					Thread.sleep(3000);
					synchronized (res3) {
						System.out.println("Black Beard Accquired"+res3);
						Thread.sleep(3000);
						synchronized (res4) {
							System.out.println("Black Beard Accquired"+res4);

							System.out.println("..Black Beard Found the One piece... and Became King of Pirates");
							System.exit(0);

							
						}
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void shanks()
	{
		try {
			Thread.sleep(3000);
			synchronized (res1) {
				System.out.println("Shanks Accquired"+res1);
				Thread.sleep(3000);
				synchronized (res2) {
					System.out.println("Shanks Accquired"+res2);
					Thread.sleep(3000);
					synchronized (res3) {
						System.out.println("Shanks Accquired"+res3);
						Thread.sleep(3000);
						synchronized (res4) {
							System.out.println("Shanks Accquired"+res4);

							System.out.println("..Shanks Found the One piece... and Became King of Pirates");
							System.exit(0);

						}
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Resources {

	public static void main(String[] args) 
	{
		
		RoadPoneglyph rp1 = new RoadPoneglyph(); 
		RoadPoneglyph rp2 = new RoadPoneglyph(); 
		RoadPoneglyph rp3 = new RoadPoneglyph(); 

		rp1.setName("luffy");
		rp2.setName("blackBeard");
		rp3.setName("shanks");
		rp1.start();
		rp2.start();
		rp3.start();
	}

}
