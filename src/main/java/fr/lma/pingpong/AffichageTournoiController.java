package fr.lma.pingpong;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class AffichageTournoiController implements Initializable {

    public void button_click_menu(ActionEvent actionEvent) {
        AccueilApplication.setFXMLForStage("accueil.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
