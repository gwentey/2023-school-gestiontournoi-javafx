package fr.lma.pingpong;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TournoiController {
    @FXML
    private Label nomTournoi;
    @FXML
    private Label villeTournoi;
    @FXML
    private Label dateTournoi;


    public void setTournoi(Tournoi tournoi) {
        villeTournoi.setText(tournoi.getVille());
        nomTournoi.setText(tournoi.getNom());
        dateTournoi.setText(tournoi.getDateDebut().toString());

    }
}


