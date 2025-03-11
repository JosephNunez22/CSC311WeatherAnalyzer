package edu.farmingdale.csc311weatherdataanalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherAnalyzer implements WeatherAnalyzerInterface {
/** Parses a CSV file containing weather data and returns a list of WeatherRecord objects.
    If the file is not found, an IOException is thrown.*/
    @Override
    public List<WeatherRecord> parseCSV(String filePath) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new IOException("File not found: " + filePath);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines()
                    .skip(1) // Skip header
                    .map(line -> line.split(","))
                    .filter(parts -> parts.length == 4)
                    .map(parts -> new WeatherRecord(
                            parts[0].trim(),
                            Double.parseDouble(parts[1].trim()),
                            Integer.parseInt(parts[2].trim()),
                            Double.parseDouble(parts[3].trim())
                    ))
                    .collect(Collectors.toList());
        }
    }
    /** Calculates the average temperature for a specific month from the list of weather records.
        The date is parsed using the format M/d/yyyy, and the average temperature for the given month is returned.
        If there are no records for the given month, NaN is returned.*/
    @Override
    public double averageTemperatureForMonth(List<WeatherRecord> records, int month) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy"); // Adjust format if needed
        return records.stream()
                .filter(record -> {
                    try {
                        LocalDate date = LocalDate.parse(record.date(), formatter);
                        return date.getMonthValue() == month;
                    } catch (Exception e) {
                        System.err.println("Invalid date format: " + record.date());
                        return false;
                    }
                })
                .mapToDouble(WeatherRecord::temperature)
                .average()
                .orElse(Double.NaN);
    }

    @Override
    public long countDaysAboveThreshold(List<WeatherRecord> records, double threshold) {
        return records.stream().filter(record -> record.temperature() > threshold).count();
    }

    @Override
    public long countRainyDays(List<WeatherRecord> records) {
        return records.stream().filter(record -> record.precipitation() > 0).count();
    }

    @Override
    public String categorizeWeather(double temperature) {
        return switch ((int) temperature / 10) {
            case 0, 1 -> "Cold";
            case 2 -> "Warm";
            case 3, 4, 5 -> "Hot";
            default -> "Extreme";
        };
    }
    public String getMonthName(int month) {
        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "Invalid Month";
        };
    }
}
