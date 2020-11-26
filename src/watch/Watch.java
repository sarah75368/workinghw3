package watch;
import java.util.*;
import runtime.*;
public class Watch implements Runnable {
	protected static Main obj;
	public int warnings = 0;
	boolean caught = false;
	boolean timeisup = false;

	public Watch() {
		Thread t = new Thread(this);
		t.start();
	}

	public boolean timeIsUp() {
		return timeisup;
	}

	void warning() {
		try {
			System.out.println("Hide map contents before someone sees you!");
			Thread.sleep(10 * 1000);
			timeisup = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (timeisup) {
			System.out.println("You have been caught... and the Marauder’s map has been confiscated.");
			System.exit(0);
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		obj = new Main();
		Timer timer = new Timer();
		TimerTask task = new WatchHelper();
		// instance of date object for fixed-rate execution
		timer.scheduleAtFixedRate(task, 1 * 60 * 1000, 1 * 60 * 1000);
		synchronized (obj) {
			// make the main thread wait
			try {
				obj.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (!caught)
				// counting the number of minutes that have passed
				if (warnings < 5) {
					warnings++;
				} else
					warning();
			timer.cancel();
			timer.purge();
		}

	}
}