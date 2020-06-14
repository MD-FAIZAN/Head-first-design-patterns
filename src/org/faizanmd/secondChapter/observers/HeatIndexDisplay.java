package org.faizanmd.secondChapter.observers;

import java.util.Observable;
import java.util.Observer;

import org.faizanmd.secondChapter.subjects.WeatherData;

public class HeatIndexDisplay implements Observer, DisplayElement {

	private Observable observable;
	private float heatIndex;
	private float temperature;
	private float humidity;
	
	public HeatIndexDisplay(Observable observable) {
		super();
		heatIndex = 0.0f;
		this.observable = observable;
		this.observable.addObserver(this);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Heat index is " + heatIndex);
	}

	@Override
	public void update(Observable observable, Object args) {
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) observable;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			heatIndex = (float)
					(
					(16.923 + (0.185212 * temperature)) + 
					(5.37941 * humidity) - 
					(0.100254 * temperature * humidity) + 
					(0.00941695 * (temperature * temperature)) + 
					(0.00728898 * (humidity * humidity)) + 
					(0.000345372 * (temperature * temperature * humidity)) - 
					(0.000814971 * (temperature * humidity * humidity)) +
					(0.0000102102 * (temperature * temperature * humidity * humidity)) - 
					(0.000038646 * (temperature * temperature * temperature)) + 
					(0.0000291583 * (humidity * humidity * humidity)) +
					(0.00000142721 * (temperature * temperature * temperature * humidity)) + 
					(0.000000197483 * (temperature * humidity * humidity * humidity)) - 
					(0.0000000218429 * (temperature * temperature * temperature * humidity * humidity)) +
					(0.000000000843296 * (temperature * temperature * humidity * humidity * humidity)) -
					(0.0000000000481975 * (temperature * temperature * temperature * humidity * humidity * humidity)));
		}
		display();
	}

}
