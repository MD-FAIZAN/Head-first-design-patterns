package org.faizanmd.secondChapter.observers;

import java.util.Observable;
import java.util.Observer;

import org.faizanmd.secondChapter.subjects.WeatherData;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private float pressure;
	private Observable observable;

	public CurrentConditionsDisplay(Observable observable) {
		super();
		this.observable = observable;
		this.observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature + 
				"F degrees, " + humidity + "% humidity and " + pressure + " bar .");
	}

	@Override
	public void update(Observable observable, Object args) {
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) observable;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			this.pressure = weatherData.getPressure();
		}
		display();
	}

}
