module fr.lma.pingpong {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;


    opens fr.lma.pingpong to javafx.fxml;
    exports fr.lma.pingpong;
}