package fr.lma.pingpong;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
     */
    public void afficherSceneMenu() {
        AccueilApplication.setFXMLForStage("accueil.fxml");
    }

    }

