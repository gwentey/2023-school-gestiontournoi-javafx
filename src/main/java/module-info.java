module fr.lma.pingpong {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens fr.lma.pingpong to javafx.fxml;
    exports fr.lma.pingpong;
}