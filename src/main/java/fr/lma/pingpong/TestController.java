package fr.lma.pingpong;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Callback;

import java.util.ArrayList;

public class TestController {

    @FXML
    private TilePane tournoisTilePane;

    public void initialize() {
        // Récupérer la référence à la liste des tournois
        ArrayList<Tournoi> tournois = AccueilApplication.tournois;

        // Ajouter chaque tournoi sous forme de carré dans le TilePane
        for (Tournoi tournoi : tournois) {
            Pane carre = new Pane();
            carre.setPrefSize(100, 100);
            carre.setStyle("-fx-background-color: #F2F2F2; -fx-border-color: #CCCCCC; -fx-border-width: 1px; -fx-border-radius: 5px; -fx-padding: 10px;");
            carre.getChildren().add(new Label(tournoi.getNom()));

            tournoisTilePane.getChildren().add(carre);
        }
    }
}


