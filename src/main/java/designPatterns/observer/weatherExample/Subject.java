package designPatterns.observer.weatherExample;

/** Any "observable" subject will need to implement this interface. In this example, WeatherData
 * is a subject (observable). Example from Head First Design Patterns */
public interface Subject {
	void registerObserver(Observer o);
	void removeObserver(Observer o);
	void notifyObservers();
}
