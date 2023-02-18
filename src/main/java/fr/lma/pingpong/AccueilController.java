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
import javafx.scene.Parent;


import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AccueilController {

    /** TilePane nécessaire pour le foreach des tournois */
    @FXML
    private TilePane tournoisTilePane;

    @FXML
    private static Parent root; // attribut qui représente la racine de votre FXML

    public static Parent getRoot() {
        return root;
    }

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
        /**
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
         */
    }

    /**
     * Permet de charger un tournoi dans l'ArrayList des Tournois
     * depuis un fichier (type File)
     *
     * @param f Fichier choisie
     */
    /** private void chargerUnTournoiDepuisFichier(File f) {
        try {
            HashMap<String, Object> map = new ObjectMapper().readValue(f, HashMap.class);
            List<Object> matchsJson = new ObjectMapper().convertValue(map.get("matchs"), List.class);
            List<Object> joueursJson = new ObjectMapper().convertValue(map.get("joueurs"), List.class);

            ArrayList<Match> matchs = new ArrayList<>();
            for (Object o : matchsJson) {
                matchs.add(new ObjectMapper().convertValue(o, Match.class));
            }

            ArrayList<Joueur> joueurs = new ArrayList<>();
            for (Object o : joueursJson) {
                joueurs.add(new ObjectMapper().convertValue(o, Joueur.class));
            }
            AccueilApplication.tournois.add(
                    new TournoiSimple(
                            (String) map.get("nom"),
                            new LocalDateStringConverter(DateTimeFormatter.ISO_LOCAL_DATE, null).fromString((String) map.get("dateDebut")),
                            new LocalDateStringConverter(DateTimeFormatter.ISO_LOCAL_DATE, null).fromString((String) map.get("dateFin")),
                            (Integer) map.get("nbJoueurs"),
                            matchs,
                            joueurs,
                            (String) map.get("state"),
                            (String) map.get("ville"))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/


    /**
     * Appelé au lancement de accueil.fxml et permet d'afficher les tournois dans un TilePane
     *
     */
    @FXML
    public void initialize() {
        // Récupérer la référence à la liste des tournois
        ArrayList<Tournoi> tournois = AccueilApplication.tournois;
        root = tournoisTilePane.getParent();

        // accroche un evenement meme si on quitte la page
        root.addEventHandler(TournoiSupprimeEvent.TOURNOI_SUPPRIME, event -> {
            System.out.println("Evenement de suppression détecté !!");
            tournois.clear();
            tournois.addAll(JSONFichier.lireTousLesFichiersJson());
            tournoisTilePane.getChildren().clear(); // supprime tous les AnchorPane existants

            // l'element traité dans le foreach est this et est prit en parametre
            tournois.forEach(this::ajouterTournoiDansTilePane);
        });

        tournois.forEach(this::ajouterTournoiDansTilePane);
    }

    /**
     * Permet d'ajouter chaque tournoi sous forme de AnchorPane dans le TilePane
     *
     * @param tournoi le tournoi a ajouter
     */
    private void ajouterTournoiDansTilePane(Tournoi tournoi) {
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