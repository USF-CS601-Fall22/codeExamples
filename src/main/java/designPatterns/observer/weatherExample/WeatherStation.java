package designPatterns.observer.weatherExample;

/** Driver class for the Observer pattern example.
 *  From Head First Design Patterns book.
 */
public class WeatherStation {

	public static void main(String[] args) {
		// Subject ("Observable")
		WeatherData weatherData = new WeatherData();

		// Three Observers (want to be notified whenever Subject changes)
		CurrentConditionsDisplay currentDisplay = 
			new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

		// setMeasurements makes changes to WeatherData. WeatherData will notify
		// all observers, and they will print info to the console
		weatherData.setMeasurements(80, 65, 30.4f);
		System.out.println();

		//weatherData.removeObserver(forecastDisplay); // removed one observer

		weatherData.setMeasurements(82, 70, 29.2f);
		System.out.println();

		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
