package watch;

import common.Observer;
import common.Subject;

public class Watch1 implements Runnable, Observer<String> {
	int counter = 0;
	boolean timeisup= false;
	public Watch1() {
		Thread t = new Thread(this);
		t.start();
	}
	public boolean timeIsUp() {
		return timeisup;
	}

	public void warning() {
		try {
			System.out.println("Hide map contents before someone sees you!");
			timeisup = true;
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (timeisup) {
			System.out.println("You have been caught... and the Marauder’s map has been confiscated.");
			System.exit(0);
		}
	}

	public void run() {

		while (true) {
			try {			
				Thread.sleep(60*1000);
				counter++;
				System.out.println(counter + " minutes passed");
				if(counter == 5) {
					warning();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void update(String data) {
		if(data.contains("mischief managed"))
			timeisup = false;		
	}
}