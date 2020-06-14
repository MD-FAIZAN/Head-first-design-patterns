package org.faizanmd.secondChapter.observers;

import org.faizanmd.secondChapter.subjects.Subject;

public class StatisticsDisplay implements Observer, DisplayElement {

	private float minTemperature;
	private float maxTemperature;
	private float tempSum;
	private int numOfUpdates;
	private Subject weatherData;

	public StatisticsDisplay(Subject weatherData) {
		super();
		minTemperature = Float.MAX_VALUE;
		maxTemperature = Float.MIN_VALUE;
		numOfUpdates = 0;
		tempSum = 0.0f;
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Minimum temperature: " + minTemperature + 
				"F degrees, Maximum temperature: " + maxTemperature +
				"F degrees, Average temperature: " + tempSum/numOfUpdates);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		minTemperature = Math.min(temperature, minTemperature);
		maxTemperature = Math.max(temperature, maxTemperature);
		tempSum += temperature;
		++numOfUpdates;
		display();
	}

}
