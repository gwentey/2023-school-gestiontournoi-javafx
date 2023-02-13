package fr.lma.pingpong;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ModifierTournoiController {

    @FXML
    private DatePicker dateDebutTournoi;
    @FXML
    private DatePicker dateFinTournoi;
    @FXML
    private TextField nomTournoi;
    @FXML
    private TextField villeTournoi;
    @FXML
    private TextField stadeTournoi;

    /**
     * Permet de retourner au menu principal
     * @param actionEvent
     */
    public void afficherSceneMenu(ActionEvent actionEvent) {
        AccueilApplication.setFXMLForStage("accueil.fxml");
    }

    /**
     * Permet de modifier un tournoi
     * @param actionEvent
     */
    public void modifierTournoi(ActionEvent actionEvent) {


    }

    }

