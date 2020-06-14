package org.faizanmd.secondChapter.observers;

import org.faizanmd.secondChapter.subjects.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private float pressure;
	private Subject weatherData;

	public CurrentConditionsDisplay(Subject weatherData) {
		super();
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature + 
				"F degrees, " + humidity + "% humidity and " + pressure + " bar .");
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

}
