package org.faizanmd.secondChapter;

import org.faizanmd.secondChapter.observers.CurrentConditionsDisplay;
import org.faizanmd.secondChapter.observers.ForecastDisplay;
import org.faizanmd.secondChapter.observers.HeatIndexDisplay;
import org.faizanmd.secondChapter.observers.StatisticsDisplay;
import org.faizanmd.secondChapter.subjects.WeatherData;

public class WeatherStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		
		weatherData.setMeasurements(80.0f, 65.0f, 30.4f);
		
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
		weatherData.setMeasurements(82.0f, 70.0f, 29.2f);
		weatherData.setMeasurements(78.0f, 90.0f, 29.2f);
	}

}
