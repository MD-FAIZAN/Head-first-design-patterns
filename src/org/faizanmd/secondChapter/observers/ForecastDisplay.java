package org.faizanmd.secondChapter.observers;

import org.faizanmd.secondChapter.subjects.Subject;

public class ForecastDisplay implements Observer, DisplayElement {
	
	private float currentPressure;  
	private float lastPressure;
	private Subject weatherData;
	
	public ForecastDisplay(Subject weatherData) {
		super();
		currentPressure = 29.92f;
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
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
	public void update(float temperature, float humidity, float pressure) {
		lastPressure = currentPressure;
		currentPressure = pressure;
		display();
	}

}
