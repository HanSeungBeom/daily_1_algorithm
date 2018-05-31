package algorithm;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Observable;
import java.util.Observer;


//Simple Observer Pattern

class NewsAgency extends Observable{
	private String news;
	
	public void setNews(String news){
		this.news = news;
		setChanged();
		notifyObservers(news);
	}
}

class NewsChannel implements Observer{
	private String news;
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		setNews((String)arg);
	}
	
	public void setNews(String news){
		this.news = news;
		System.out.println(hashCode()+": updated!!");
	}
}

//Observer Pattern with PropertyChangeListener

class PCLNewsAgency{
	private String news;
	private PropertyChangeSupport support;
	
	public PCLNewsAgency(){
		support = new PropertyChangeSupport(this);
	}
	public void addPropertyChangeListener(PropertyChangeListener pcl){
		support.addPropertyChangeListener(pcl);
	}
	public void removePropertyChangeListener(PropertyChangeListener pcl){
		support.removePropertyChangeListener(pcl);
	}
	public void setNews(String value){
		support.firePropertyChange("news", this.news, value);
		this.news = value;
	}
}

class PCLNewsChannel implements PropertyChangeListener{
	private String news;
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		this.setNews((String)evt.getNewValue());
	}
	public void setNews(String news){
		this.news = news;
		System.out.println(hashCode()+" updated:"+news);
	}
}

interface Channel{
	public void update(Object news);
}

public class _180531_observerPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PCLNewsAgency observable = new PCLNewsAgency();
		PCLNewsChannel observer1 = new PCLNewsChannel();
		PCLNewsChannel observer2 = new PCLNewsChannel();
		PCLNewsChannel observer3 = new PCLNewsChannel();
		observable.addPropertyChangeListener(observer1);
		observable.addPropertyChangeListener(observer2);
		observable.addPropertyChangeListener(observer3);
		observable.setNews("hello!");
		
	}

}
