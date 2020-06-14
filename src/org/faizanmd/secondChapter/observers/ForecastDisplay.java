package org.faizanmd.secondChapter.observers;

import java.util.Observable;
import java.util.Observer;

import org.faizanmd.secondChapter.subjects.WeatherData;

public class ForecastDisplay implements Observer, DisplayElement {
	
	private float currentPressure;  
	private float lastPressure;
	private Observable observable;
	
	public ForecastDisplay(Observable observable) {
		super();
		currentPressure = 29.92f;
		this.observable = observable;
		this.observable.addObserver(this);
	}

	@Override
	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}

	@Override
	public void update(Observable observable, Object args) {
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) observable;
			lastPressure = currentPressure;
			this.currentPressure = weatherData.getPressure();
		}
		display();
	}

}
