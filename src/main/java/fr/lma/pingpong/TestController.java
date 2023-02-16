package fr.lma.pingpong;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import java.io.IOException;
import java.util.ArrayList;

public class TestController {

    @FXML
    private TilePane tournoisTilePane;

    public void initialize() {
        // Récupérer la référence à la liste des tournois
        ArrayList<Tournoi> tournois = AccueilApplication.tournois;

        // Ajouter chaque tournoi sous forme de AnchorPane dans le TilePane
        for (Tournoi tournoi : tournois) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tournoi.fxml"));
                AnchorPane tournoiPane = fxmlLoader.load();
                tournoiPane.getChildren().stream()
                        .filter(n -> n instanceof Label)
                        .map(n -> (Label) n)
                        .forEach(label -> {
                            switch (label.getText()) {
                                case "Ville du tournoi":
                                    label.setText(tournoi.getVille());
                                    break;

                                default:
                                    break;
                            }
                        });
                tournoisTilePane.getChildren().add(tournoiPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

