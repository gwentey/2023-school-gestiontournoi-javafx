package fr.lma.pingpong;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AccueilController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void afficherSceneCreationTournoi(ActionEvent actionEvent) {
        AccueilApplication.setFXMLForStage("creerTournoi.fxml");
    }

    public void afficherFileChooser(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File fichierChoisi = fileChooser.showOpenDialog(AccueilApplication.stage);
        if (fichierChoisi.exists() && fichierChoisi.canRead()) {
            try {
                chargerUnTournoiDepuisFichier(fichierChoisi);
                for (Tournoi t : AccueilApplication.tournois) {
                    System.out.println(t.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Permet de modifier le tournoi selectionné
     * @param actionEvent
     */
    public void afficherSceneModifierTournoi(ActionEvent actionEvent) {
        AccueilApplication.setFXMLForStage("modifierTournoi.fxml");
    }


    /**
     * Permet de charger un tournoi dans l'ArrayList des Tournois
     * depuis un fichier (type File)
     *
     * @param f Fichier choisie
     */
    private void chargerUnTournoiDepuisFichier(File f) {
        try {
            HashMap<String, Object> map = new ObjectMapper().readValue(f, HashMap.class);
            List<Object>matchsJson = new ObjectMapper().convertValue(map.get("matchs"), List.class);
            ArrayList<Match> matchs = new ArrayList<>();
            for (Object o : matchsJson) {
                matchs.add(new ObjectMapper().convertValue(o, Match.class));
            }
            AccueilApplication.tournois.add(
                    new TournoiSimple(
                            (String) map.get("nom"),
                            new LocalDateStringConverter(DateTimeFormatter.ISO_LOCAL_DATE, null).fromString((String) map.get("dateDebut")),
                            new LocalDateStringConverter(DateTimeFormatter.ISO_LOCAL_DATE, null).fromString((String) map.get("dateFin")),
                            (Integer) map.get("nbJoueurs"),
                             matchs,
                            (String) map.get("state"),
                            (String) map.get("ville"))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}