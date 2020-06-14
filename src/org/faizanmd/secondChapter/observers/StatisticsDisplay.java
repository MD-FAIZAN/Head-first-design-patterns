package org.faizanmd.secondChapter.observers;

import java.util.Observable;
import java.util.Observer;

import org.faizanmd.secondChapter.subjects.WeatherData;

public class StatisticsDisplay implements Observer, DisplayElement {

	private float minTemperature;
	private float maxTemperature;
	private float temperature;
	private float tempSum;
	private int numOfUpdates;
	private Observable observable;

	public StatisticsDisplay(Observable observable) {
		super();
		minTemperature = Float.MAX_VALUE;
		maxTemperature = Float.MIN_VALUE;
		numOfUpdates = 0;
		tempSum = 0.0f;
		this.observable = observable;
		this.observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Minimum temperature: " + minTemperature + 
				"F degrees, Maximum temperature: " + maxTemperature +
				"F degrees, Average temperature: " + tempSum/numOfUpdates);
	}

	@Override
	public void update(Observable observable, Object args) {
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) observable;
			this.temperature = weatherData.getTemperature();
			minTemperature = Math.min(temperature, minTemperature);
			maxTemperature = Math.max(temperature, maxTemperature);
			tempSum += temperature;
			++numOfUpdates;
		}
		display();
	}

}
