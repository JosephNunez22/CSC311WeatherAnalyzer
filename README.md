# CSC311WeatherAnalyzer
Weather Data Analyzer

Overview
The Weather Data Analyzer is a Java-based application designed to efficiently process and analyze weather data.
It allows users to parse weather data from a CSV file and provides various functionalities such as calculating the
average temperature, identifying days with temperatures above a specific threshold, counting rainy days, and categorizing
the weather based on temperature.

This application utilizes modern Java features, including Java Records, Lambdas, Streams, Enhanced Switch Statements, and Text Blocks, among others, introduced from Java 15 to Java 23.

Features
Parse weather data: Reads weather data (temperature, humidity, precipitation) from a CSV file.
Average Temperature: Calculates the average temperature for a specific month.
Temperature Threshold: Identifies days with temperatures above a given threshold.
Rainy Days Count: Counts the number of rainy days in the dataset.
Weather Categorization: Uses the enhanced switch statement to categorize weather based on temperature (e.g., "Hot", "Warm", "Cold").
Efficient Data Processing: Utilizes lambdas and streams to process weather data efficiently.
Technologies Used
Java 15+ (Records, Enhanced Switch, Text Blocks, Lambdas, Streams)
JDK 18+ (Markdown Javadoc support)

Installation
Clone the repository:
git clone https://github.com/JosephNunez22/CSC311WeatherAnalyzer.git

Install Java 15+: Ensure you have Java 15 or later installed.

Compile the Project: Navigate to the project directory and compile the Java files:

Calculate the Average Temperature: The application will compute the average temperature for a specified month.
Filter Days Based on Temperature: Identify days where the temperature exceeded a given threshold.
Count Rainy Days: The program will count the number of days with precipitation.
Categorize Weather: The program categorizes weather based on temperature (e.g., "Hot", "Warm", "Cold").

Weather Report for March:
- Average Temperature: 23.89°C
- Rainy Days: 21
- Hot Days: 5

Documentation
The application’s code is thoroughly documented using Markdown Javadoc. You can view the documentation for each method, including code examples, directly in the source files.

To generate the full Javadoc, run:

Fork the repository
Create a new branch for your feature or fix
Make your changes
Submit a pull request with a description of your changes
Be sure to follow the project's coding standards and best practices. For any issues or feature requests, please open an issue on the GitHub repository.
