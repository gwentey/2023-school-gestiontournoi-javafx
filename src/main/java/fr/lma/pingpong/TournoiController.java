package fr.lma.pingpong;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.LocalDate;

public class TournoiController {
    @FXML
    private Label nomTournoi;
    @FXML
    private Label villeTournoi;
    @FXML
    private Label dateTournoi;


    /**
     * Permet de reconstruire partiellement les informations souhaitées
     * pour l'affichage d'un tournoi dans AccueilController
     *
     * @param tournoi
     */
    public void setTournoi(Tournoi tournoi) {
        villeTournoi.setText(tournoi.getVille());
        nomTournoi.setText(tournoi.getNom());
        dateTournoi.setText(tournoi.getDateDebut().toString());

    }


    /**
     * Permet la supression d'un Tournoi
     *
     * @param event
     */
    @FXML
    private void suppressionTournoi(ActionEvent event) {
        // Suppression du tournoi de l'ArrayList
        for (Tournoi tournoi : AccueilApplication.tournois) {

            if (tournoi.getNom().equals(nomTournoi.getText()) && tournoi.getDateDebut().equals(LocalDate.parse(dateTournoi.getText()))) {
                // supression dans l'arraylist
                AccueilApplication.tournois.remove(tournoi);
                // supression du fichier JSON
                JSONFichier.supprimerTournoi(tournoi);
                // lance l'événement supression : afin de reload la page
                Event.fireEvent(AccueilController.getRoot(), new TournoiSupprimeEvent());

                break;
            }
        }

        // rechargement des tournois
        AccueilApplication.tournois = JSONFichier.lireTousLesFichiersJson();

    }


    /**
     * Permet de modifier le tournoi selectionné
     *
     * @param actionEvent
     */
    @FXML public void afficherSceneModifierTournoi(ActionEvent actionEvent)
    {
        boolean find = false;
        for (Tournoi tournoi : AccueilApplication.tournois) {
            if (tournoi.getNom().equals(nomTournoi.getText())) {
                AccueilApplication.tournoiActuel = tournoi;
                find = true;
            }
        }
        if(!find){
            System.out.println("Erreur : Le tournoi n'a pas été trouvé dans l'arraylist");
        }else{
            if(AccueilApplication.tournoiActuel.getNbJoueurs()==8){
                AccueilApplication.setFXMLForStage("affichageTournoi8.fxml");
            }
        }
    }
}


