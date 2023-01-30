package fr.lma.pingpong;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AccueilController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void afficherSceneCreationTournoi(ActionEvent actionEvent) {
        AccueilApplication.setFXMLForStage("creerTournoi.fxml");
    }


}