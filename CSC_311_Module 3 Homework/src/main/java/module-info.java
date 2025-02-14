module edu.farmingdale.csc_311_module_3_homework {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens edu.farmingdale.csc_311_module_3_homework to javafx.fxml;
    exports edu.farmingdale.csc_311_module_3_homework;
}