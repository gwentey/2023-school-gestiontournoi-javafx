package fr.lma.pingpong;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ModifierTournoiController {

    @FXML
    private TextField nomTournoi;
    @FXML
    private DatePicker dateDebutTournoi;
    @FXML
    private DatePicker dateFinTournoi;
    @FXML
    private ToggleGroup nbJoueur;
    @FXML
    private RadioButton nbJoueur8;
    @FXML
    private RadioButton nbJoueur16;
    @FXML
    private RadioButton nbJoueur32;
    @FXML
    private ToggleGroup typeT;
    @FXML
    private RadioButton typeTSimple;
    @FXML
    private RadioButton typeTDouble;
    @FXML
    private TextField stade;
    @FXML
    private TextField ville;

    /**
     * Permet de retourner au menu principal
     * @param actionEvent
     */
    public void afficherSceneMenu(ActionEvent actionEvent) {
        AccueilApplication.setFXMLForStage("accueil.fxml");
    }


    public void modifierTournoi(ActionEvent actionEvent) {}

    }

