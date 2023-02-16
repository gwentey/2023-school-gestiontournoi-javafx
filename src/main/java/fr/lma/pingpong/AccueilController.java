package fr.lma.pingpong;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.util.converter.LocalDateStringConverter;
import javafx.scene.layout.TilePane;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AccueilController {

    @FXML
    private TilePane tournoisTilePane;


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
     * A SUPRIMER
     */
    @FXML
    public void afficherSceneTest(ActionEvent actionEvent) {
        AccueilApplication.setFXMLForStage("test.fxml");
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

    @FXML
    public void initialize() {
        // Récupérer la référence à la liste des tournois
        ArrayList<Tournoi> tournois = AccueilApplication.tournois;


        tournoisTilePane.setStyle("-fx-background-color: -fx-primary-color");
        // Ajouter chaque tournoi sous forme de AnchorPane dans le TilePane
        for (Tournoi tournoi : tournois) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tournoi.fxml"));
                AnchorPane tournoiPane = fxmlLoader.load();
                TournoiController tournoiController = fxmlLoader.getController();
                tournoiController.setTournoi(tournoi);
                tournoisTilePane.getChildren().add(tournoiPane);
                tournoisTilePane.setMargin(tournoiPane, new Insets(10));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




}