package fr.lma.pingpong;

import javafx.event.ActionEvent;

import java.util.ArrayList;

public class CreerTournoiController {

    private String dateDebut;
    private String dateFin;
    private ArrayList<Match> matchs;
    private Stade stade;

    public void afficherSceneMenu(ActionEvent actionEvent) {
        AccueilApplication.setFXMLForStage("accueil.fxml");
    }
}
