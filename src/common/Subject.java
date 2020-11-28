package common;
import java.util.*;

public abstract class Subject<Type> {
	  protected List<Observer<Type>> observers = new LinkedList<Observer<Type>>();

	    /*Add Observer to observers */
	    public void addObserver(Observer<Type> obs) {
	        if (obs == null) {
	            throw new IllegalArgumentException();
	        }
	        synchronized (observers) {
	            if (observers.contains(obs)) {
	                return;
	            }
	            observers.add(obs);
	        }
	    }

	    /*Method to notify observers  */
	    public void notifyObservers(Type data) {
	        List<Observer<Type>> toNotify = null;

	        synchronized (observers) {
	            toNotify = new LinkedList<Observer<Type>>(observers);
	        }

	        for (Observer<Type> obs : toNotify) {
	            obs.update( data);
	        }	    
	        }
	    
	    /*Method to remove observers from list*/
	    public void removeObserver(Observer<Type> obs) {
	        if (obs == null) {
	            throw new IllegalArgumentException();
	        }
	        
	        synchronized (observers) {
	            int index = observers.indexOf(obs);
	            if (index == -1)
	                return;
	            observers.remove(index);
	        }
	    }
}
