module fr.lma.pingpong {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens fr.lma.pingpong to javafx.fxml;
    exports fr.lma.pingpong;
}