package fr.lma.pingpong;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AffichageTournoiController implements Initializable {

    @FXML
    private DatePicker dateDebut;
    @FXML
    private DatePicker dateFin;
    @FXML
    private TextField nomTournois;
    @FXML
    private TextField ville;
    @FXML
    private TextField stade;

    public void button_click_menu(ActionEvent actionEvent) {
        AccueilApplication.setFXMLForStage("accueil.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Tournoi t = AccueilApplication.tournoiActuel;
        dateDebut.setValue(t.getDateDebut());
        dateFin.setValue(t.getDateFin());
        ville.setText(t.getVille());
        nomTournois.setText(t.getNom());
        stade.setText(t.getStade());
        System.out.println("test");
    }
}
