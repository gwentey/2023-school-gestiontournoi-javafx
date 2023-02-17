package fr.lma.pingpong;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TableauJoueursController implements Initializable {

    @FXML
    TableView tableview;
    @FXML
    TableColumn noms;
    @FXML
    TableColumn prenoms;
    private int nbJoueurs = 6;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableview.setMaxSize(2,nbJoueurs);

    }

    public void retourMenu(){
        AccueilApplication.setFXMLForStage("affichageTournoi8.fxml");
    }
}
