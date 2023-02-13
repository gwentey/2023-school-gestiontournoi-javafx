package fr.lma.pingpong;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.util.converter.LocalDateStringConverter;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AccueilController {

    /**
     * Permet d'afficher l'écran de création de tournoi
     *
     * @param actionEvent
     */
    @FXML
    public void afficherSceneCreationTournoi(ActionEvent actionEvent) {
        AccueilApplication.setFXMLForStage("creerTournoi.fxml");
    }

    /**
     * Permet d'afficher le fenêtre de sélection des fichiers
     * ainsi que de charger le fichier sélectionné
     *
     * @param actionEvent
     */
    @FXML
    public void afficherFileChooser(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File fichierChoisi = fileChooser.showOpenDialog(AccueilApplication.stage);
        if (fichierChoisi != null && fichierChoisi.exists() && fichierChoisi.canRead()) {
            try {
                chargerUnTournoiDepuisFichier(fichierChoisi);
                for (Tournoi t : AccueilApplication.tournois) {
                    System.out.println(t.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Permet de charger un tournoi dans l'ArrayList des Tournois
     * depuis un fichier (type File)
     *
     * @param f Fichier choisie
     */
    private void chargerUnTournoiDepuisFichier(File f) {
        try {
            HashMap<String, Object> map = new ObjectMapper().readValue(f, HashMap.class);
            List<Object> matchsJson = new ObjectMapper().convertValue(map.get("matchs"), List.class);
            ArrayList<Match> matchs = new ArrayList<>();
            for (Object o : matchsJson) {
                matchs.add(new ObjectMapper().convertValue(o, Match.class));
            }
            AccueilApplication.tournois.add(
                    new TournoiSimple(
                            (String) map.get("nom"),
                            new LocalDateStringConverter(DateTimeFormatter.ISO_LOCAL_DATE, null).fromString((String) map.get("dateDebut")),
                            new LocalDateStringConverter(DateTimeFormatter.ISO_LOCAL_DATE, null).fromString((String) map.get("dateFin")),
                            (Integer) map.get("nbJoueurs"),
                            matchs,
                            (String) map.get("state"),
                            (String) map.get("ville"))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de modifier le tournoi selectionné
     *
     * @param actionEvent
     */
    @FXML
    public void afficherSceneModifierTournoi(ActionEvent actionEvent) {
        AccueilApplication.setFXMLForStage("modifierTournoi.fxml");
    }
}