package fr.lma.pingpong;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TableauJoueursController implements Initializable {

    @FXML
    TableView<Joueur> tableview;
    @FXML
    TextField nomJoueur;
    @FXML
    TextField prenomJoueur;
    @FXML
    TableColumn<Joueur, String> noms;
    @FXML
    TableColumn<Joueur, String> prenoms;
    private int nbJoueurs = 6;

    private ObservableList<Joueur> joueurs = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableview.setMaxSize(2,nbJoueurs);
        joueurs.addAll(AccueilApplication.tournoiActuel.getJoueurs());
        noms.setCellValueFactory(new PropertyValueFactory<Joueur, String>("nom"));
        prenoms.setCellValueFactory(new PropertyValueFactory<Joueur, String>("prenom"));

        tableview.setItems(joueurs);
    }

    public void retourTournoi(){
        if(AccueilApplication.tournoiActuel.getNbJoueurs()==8){
            AccueilApplication.setFXMLForStage("affichageTournoi8.fxml");
        }else{
            AccueilApplication.setFXMLForStage("affichageTournoi16.fxml");
        }
    }

    public void ajouterJoueur(){
        String prenom = this.prenomJoueur.getText();
        String nom = this.nomJoueur.getText();
        AccueilApplication.tournoiActuel.addJoueur(new Joueur(nom,prenom));
        joueurs.clear();
        joueurs.addAll(AccueilApplication.tournoiActuel.getJoueurs());
        tableview.setItems(joueurs);
    }
}
