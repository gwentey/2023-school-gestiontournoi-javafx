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

    /**
     * Permet de modifier le tournoi selectionné
     * @param actionEvent
     */
    public void afficherSceneModifierTournoi(ActionEvent actionEvent) {
        AccueilApplication.setFXMLForStage("modifierTournoi.fxml");
    }


}