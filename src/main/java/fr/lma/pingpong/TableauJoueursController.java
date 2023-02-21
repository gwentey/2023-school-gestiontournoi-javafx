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

    private final ObservableList<Joueur> joueurs = FXCollections.observableArrayList();

    /**
     * Appelé au chargement de la page, permet de récupérer les joueurs du tournoi et de les afficher à l'écran
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        joueurs.addAll(AccueilApplication.tournoiActuel.getJoueurs());
        noms.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenoms.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        tableview.setItems(joueurs);
    }

    /**
     * Permet de retourner au tournoi actuel
     */
    public void retourTournoi(){
        if(AccueilApplication.tournoiActuel.getNbJoueurs()==8){
            AccueilApplication.setFXMLForStage("affichageTournoi8.fxml");
        }else if(AccueilApplication.tournoiActuel.getNbJoueurs()==16){
            AccueilApplication.setFXMLForStage("affichageTournoi16.fxml");
        }else if(AccueilApplication.tournoiActuel.getNbJoueurs()==32){
            AccueilApplication.setFXMLForStage("affichageTournoi32.fxml");
        }
    }

    /**
     * Permet d'ajouter un joueur à la liste des joueurs du tournoi.
     * Se déclenche avec le bouton Ajouter de la page ListeJoueurs.
     */
    public void ajouterJoueur(){
        String prenom = this.prenomJoueur.getText().substring(0,1).toUpperCase() + this.prenomJoueur.getText().substring(1).toLowerCase();
        String nom = this.nomJoueur.getText().substring(0,1).toUpperCase() + this.nomJoueur.getText().substring(1).toLowerCase();
        AccueilApplication.tournoiActuel.addJoueur(new Joueur(nom,prenom));
        joueurs.clear();
        joueurs.addAll(AccueilApplication.tournoiActuel.getJoueurs());
        tableview.setItems(joueurs);
    }
}
