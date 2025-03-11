package edu.farmingdale.csc311weatherdataanalyzer;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.List;

public class WeatherScreenController {
    private final WeatherAnalyzer analyzer = new WeatherAnalyzer();
    private List<WeatherRecord> records;

    @FXML
    private Label averageTempLbl;

    @FXML
    private Label hotDaysLbl;

    @FXML
    private Label rainyDaysLbl;

    @FXML
    public void loadWeatherDataBtnClicked(){
        try {
                records = analyzer.parseCSV("weatherdata.csv");
            double avgTemp = analyzer.averageTemperatureForMonth(records,03);
            long rainyDays = analyzer.countRainyDays(records);
            long hotDays = analyzer.countDaysAboveThreshold(records, 30);

            DecimalFormat df = new DecimalFormat("#.##");
            averageTempLbl.setText(df.format(avgTemp) + " °C");
            rainyDaysLbl.setText(String.valueOf(rainyDays));
            hotDaysLbl.setText(String.valueOf(hotDays));
        }catch (IOException e) {
            showErrorDialog("Error loading data", "Could not read the weather data file.");
        }
    }
    private void showErrorDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText("Alert Error Loading data"); // No header text
        alert.setContentText(message);
        alert.showAndWait();
    }
}
