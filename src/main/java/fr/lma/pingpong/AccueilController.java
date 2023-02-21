package fr.lma.pingpong;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.scene.layout.TilePane;
import javafx.scene.Parent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
     */
    @FXML
    public void afficherSceneCreationTournoi() {
        AccueilApplication.setFXMLForStage("creerTournoi.fxml");
    }


    /**
     * Permet d'afficher la fenêtre de sélection des fichiers
     * ainsi que de charger le fichier sélectionné
     */
    @FXML
    public void afficherFileChooser() {

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
           JSONFichier.lireFichierJson(f);
           Event.fireEvent(AccueilController.getRoot(), new TournoiSupprimeEvent());
       } catch (Exception e) {
           e.printStackTrace();
       }

   }


    /**
     * Appelé au lancement d'accueil.fxml.
     * Permet d'afficher les tournois dans un TilePane
     */
    @FXML
    public void initialize() {
        // Récupérer la référence à la liste des tournois
        ArrayList<Tournoi> tournois = AccueilApplication.tournois;
        root = tournoisTilePane.getParent();

        // accroche un évènement meme si on quitte la page
        root.addEventHandler(TournoiSupprimeEvent.TOURNOI_SUPPRIME, event -> {
            System.out.println("Évènement de suppression détecté !!");
            tournois.clear();
            tournois.addAll(JSONFichier.lireTousLesFichiersJson());
            tournoisTilePane.getChildren().clear(); // supprime tous les AnchorPane existants

            // l'élément traité dans le foreach est this et est pris en paramètre
            tournois.forEach(this::ajouterTournoiDansTilePane);
        });

        // accroche un évènement meme si on quitte la page
        root.addEventHandler(TournoiChargeEvent.TOURNOI_CHARGE, event -> {
            System.out.println("Évènement de chargement détecté !!");
            tournois.clear();
            tournois.addAll(JSONFichier.lireTousLesFichiersJson());
            tournoisTilePane.getChildren().clear(); // supprime tous les AnchorPane existants

            // l'élément traité dans le foreach est this et est pris en paramètre
            tournois.forEach(this::ajouterTournoiDansTilePane);
        });

        tournois.forEach(this::ajouterTournoiDansTilePane);
    }

    /**
     * Permet d'ajouter chaque tournoi sous forme de AnchorPane dans le TilePane
     *
     * @param tournoi le tournoi à ajouter
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