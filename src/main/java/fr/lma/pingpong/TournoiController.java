package fr.lma.pingpong;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TournoiController {
    @FXML
    private Label villeTournoi;

    public void setTournoi(Tournoi tournoi) {
        villeTournoi.setText(tournoi.getVille());
    }
}


