package fr.lma.pingpong;

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
     * @param tournoi tournoi
     */
    public void setTournoi(Tournoi tournoi) {
        villeTournoi.setText(tournoi.getVille());
        nomTournoi.setText(tournoi.getNom());
        dateTournoi.setText(tournoi.getDateDebut().toString());

    }


    /**
     * Permet la suppression d'un Tournoi
     */
    @FXML
    private void suppressionTournoi() {
        // Suppression du tournoi de l'ArrayList
        for (Tournoi tournoi : AccueilApplication.tournois) {

            if (tournoi.getNom().equals(nomTournoi.getText()) && tournoi.getDateDebut().equals(LocalDate.parse(dateTournoi.getText()))) {
                // suppression dans l'ArrayList
                AccueilApplication.tournois.remove(tournoi);
                // suppression du fichier JSON
                JSONFichier.supprimerTournoi(tournoi);
                // lance l'événement suppression : afin de reload la page
                Event.fireEvent(AccueilController.getRoot(), new TournoiSupprimeEvent());

                break;
            }
        }

        // rechargement des tournois
        AccueilApplication.tournois = JSONFichier.lireTousLesFichiersJson();

    }


    /**
     * Permet d'afficher la scene de modification du tournoi sélectionné
     */
    @FXML public void afficherSceneModifierTournoi()
    {
        boolean find = false;
        for (Tournoi tournoi : AccueilApplication.tournois) {
            if (tournoi.getNom().equals(nomTournoi.getText())) {
                AccueilApplication.tournoiActuel = tournoi;
                find = true;
            }
        }
        if(!find){
            System.out.println("Erreur : Le tournoi n'a pas été trouvé dans l'ArrayList");
        }else{
            if(AccueilApplication.tournoiActuel.getNbJoueurs()==8){
                AccueilApplication.setFXMLForStage("affichageTournoi8.fxml");
            }else if (AccueilApplication.tournoiActuel.getNbJoueurs()==16){
                AccueilApplication.setFXMLForStage("affichageTournoi16.fxml");
            }else if (AccueilApplication.tournoiActuel.getNbJoueurs()==32){
                AccueilApplication.setFXMLForStage("affichageTournoi32.fxml");
            }
        }
    }
}


