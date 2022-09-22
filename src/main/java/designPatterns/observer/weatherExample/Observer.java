package designPatterns.observer.weatherExample;
/** Observer Pattern Example. From Head First Design Patterns book.
 *  All observers of WeatherData need to implement this interface. */
public interface Observer {
	void update(float temp, float humidity, float pressure);

}
