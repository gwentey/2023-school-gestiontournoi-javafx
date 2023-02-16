package fr.lma.pingpong;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
    private void surpressionTournoi(ActionEvent event) {
        System.out.println("FONCTION SUPRESSION APPELEE");
        // Suppression du tournoi de l'ArrayList
        for (Tournoi tournoi : AccueilApplication.tournois) {
            if (tournoi.getNom().equals(nomTournoi.getText())) {
                AccueilApplication.tournois.remove(tournoi);
                System.out.println("CE TOURNOI A ETE SUPPRIMEE : " + tournoi);
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
        AccueilApplication.setFXMLForStage("modifierTournoi.fxml");
    }
}


