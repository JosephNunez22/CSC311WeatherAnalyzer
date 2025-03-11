package edu.farmingdale.csc311weatherdataanalyzer;

import java.io.IOException;
import java.util.List;

public interface WeatherAnalyzerInterface {
    /** parseCSV(String filePath): Describes that this method reads weather data from a CSV file and returns a list of WeatherRecord objects. It also specifies that an IOException may be thrown if there's an issue reading the file.
     averageTemperatureForMonth(List<WeatherRecord> records, int month): Specifies that this method calculates the average temperature for a specific month and returns a double value.
     countDaysAboveThreshold(List<WeatherRecord> records, double threshold): Describes that this method counts how many days have temperatures above a given threshold and returns that count as a long.
     countRainyDays(List<WeatherRecord> records): States that this method counts how many days had rainfall (rainy days) in the provided list of weather records and returns that count.
     categorizeWeather(double temperature): Explains that this method categorizes the weather based on the given temperature and returns a string representing the category (e.g., "Cold", "Warm", or "Hot"). */
    List<WeatherRecord> parseCSV(String filePath) throws IOException;
    double averageTemperatureForMonth(List<WeatherRecord> records, int month);
    long countDaysAboveThreshold(List<WeatherRecord> records, double threshold);
    long countRainyDays(List<WeatherRecord> records);
    String categorizeWeather(double temperature);
}
