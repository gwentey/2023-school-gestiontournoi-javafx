package fr.lma.pingpong;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe controller de créerTournoi.fxml
 *
 * @author MaximeVeschembes
 */
public class CreerTournoiController {

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
    private TextField stade;
    @FXML
    private TextField ville;

    /**
     * Permet de retourner au menu principal
     */
    public void afficherSceneMenu() {
        AccueilApplication.setFXMLForStage("accueil.fxml");
    }


    /**
     * Gestion de la création du tournoi
     */
    public void creerTournoi() {

        int nbJ;

        if (nbJoueur.getSelectedToggle().equals(nbJoueur8)) {
            nbJ = 8;
        } else if (nbJoueur.getSelectedToggle().equals(nbJoueur16)) {
            nbJ = 16;
        } else {
            nbJ = 32;
        }

        Tournoi tournoi;
        if (typeT.getSelectedToggle().equals(typeTSimple)) {
            tournoi = new TournoiSimple(nomTournoi.getText(),
                    dateDebutTournoi.getValue(),
                    dateFinTournoi.getValue(),
                    nbJ,
                    new HashMap<>(),
                    new ArrayList<>(6),
                    stade.getText(),
                    ville.getText());
            AccueilApplication.tournoiActuel = tournoi;
            if(nbJoueur.getSelectedToggle().equals(nbJoueur8)){
                AccueilApplication.setFXMLForStage("affichageTournoi8.fxml");
            }else if(nbJoueur.getSelectedToggle().equals(nbJoueur16)){
                AccueilApplication.setFXMLForStage("affichageTournoi16.fxml");
            }else if(nbJoueur.getSelectedToggle().equals(nbJoueur32)){
                AccueilApplication.setFXMLForStage("affichageTournoi32.fxml");
            }
        } else {
            tournoi = new TournoiDouble(nomTournoi.getText(),
                    dateDebutTournoi.getValue(),
                    dateFinTournoi.getValue(),
                    nbJ,
                    new HashMap<>(),
                    new ArrayList<>(6),
                    stade.getText(),
                    ville.getText());
            AccueilApplication.tournoiActuel = tournoi;
        }
    }
}
