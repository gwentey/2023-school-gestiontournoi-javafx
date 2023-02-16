package fr.lma.pingpong;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AffichageTournoi8Controller implements Initializable {

    @FXML
    private DatePicker dateDebutTournoi;
    @FXML
    private DatePicker dateFinTournoi;
    @FXML
    private TextField nomTournoi;
    @FXML
    private TextField villeTournoi;
    @FXML
    private TextField stadeTournoi;

    /**
     * Bouton permettant de revenir au menu d'accueil
     *
     * @param actionEvent
     */
    public void buttonClickMenu(ActionEvent actionEvent) {
        JSONFichier.writeJsonFile(AccueilApplication.tournoiActuel);

        // les tournois sont chargés à nouveau après la création
        AccueilApplication.tournois = JSONFichier.lireTousLesFichiersJson();

        AccueilApplication.setFXMLForStage("accueil.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Tournoi t = AccueilApplication.tournoiActuel;
        this.dateDebutTournoi.setValue(t.getDateDebut());
        this.dateFinTournoi.setValue(t.getDateFin());
        this.villeTournoi.setText(t.getVille());
        this.nomTournoi.setText(t.getNom());
        this.stadeTournoi.setText(t.getStade());
        System.out.println();
    }
}
