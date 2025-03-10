module edu.farmingdale.csc311weatherdataanalyzer {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.farmingdale.csc311weatherdataanalyzer to javafx.fxml;
    exports edu.farmingdale.csc311weatherdataanalyzer;
}