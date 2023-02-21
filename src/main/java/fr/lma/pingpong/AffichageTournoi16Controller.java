package fr.lma.pingpong;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;

public class AffichageTournoi16Controller implements Initializable {
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

    @FXML
    private Circle match1;
    @FXML
    private Circle match2;
    @FXML
    private Circle match3;
    @FXML
    private Circle match4;
    @FXML
    private Circle match5;
    @FXML
    private Circle match6;
    @FXML
    private Circle match7;
    @FXML
    private Circle match8;
    @FXML
    private Circle match9;
    @FXML
    private Circle match10;
    @FXML
    private Circle match11;
    @FXML
    private Circle match12;
    @FXML
    private Circle match13;
    @FXML
    private Circle match14;
    @FXML
    private Circle match15;
    private ArrayList<Circle> circles = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Tournoi t = AccueilApplication.tournoiActuel;
        this.dateDebutTournoi.setValue(t.getDateDebut());
        this.dateFinTournoi.setValue(t.getDateFin());
        this.villeTournoi.setText(t.getVille());
        this.nomTournoi.setText(t.getNom());
        this.stadeTournoi.setText(t.getStade());

        circles.add(this.match1);
        circles.add(this.match2);
        circles.add(this.match3);
        circles.add(this.match4);
        circles.add(this.match5);
        circles.add(this.match6);
        circles.add(this.match7);
        circles.add(this.match8);
        circles.add(this.match9);
        circles.add(this.match10);
        circles.add(this.match11);
        circles.add(this.match12);
        circles.add(this.match13);
        circles.add(this.match14);
        circles.add(this.match15);

        Set<String> circleStr = t.getMatchs().keySet();
        if(t.getMatchs().isEmpty()){
            for (Circle c:circles){
                c.setFill(Color.rgb(154,159,167));
            }
        }
        for(int i =0; i<t.getMatchs().size();i++){
            for (Circle c:circles){
                if(circleStr.contains(c.getId())){
                    c.setFill(Color.rgb(24,25,28));
                }else{
                    c.setFill(Color.rgb(154,159,167));
                }
            }
        }
    }

    /**
     * Bouton permettant de revenir au menu d'accueil
     *
     * @param actionEvent
     */
    public void buttonClickMenu(ActionEvent actionEvent) {

        if(nomTournoi.getText() != AccueilApplication.tournoiActuel.getNom() || dateDebutTournoi.getValue() != AccueilApplication.tournoiActuel.getDateDebut()) {
            JSONFichier.supprimerTournoi(AccueilApplication.tournoiActuel);
        }

        AccueilApplication.tournoiActuel.setNom(nomTournoi.getText());
        AccueilApplication.tournoiActuel.setDateDebut(dateDebutTournoi.getValue());
        AccueilApplication.tournoiActuel.setDateFin(dateFinTournoi.getValue());
        AccueilApplication.tournoiActuel.setStade(stadeTournoi.getText());
        AccueilApplication.tournoiActuel.setVille(villeTournoi.getText());

        JSONFichier.writeJsonFile(AccueilApplication.tournoiActuel);

        // les tournois sont chargés à nouveau après la création
        AccueilApplication.tournois = JSONFichier.lireTousLesFichiersJson();

        AccueilApplication.setFXMLForStage("accueil.fxml");
    }

    public void openEditJoueurs(){
        AccueilApplication.setFXMLForStage("tableauJoueurs.fxml");
    }

    @FXML
    public void handleCircleClick(MouseEvent event) {
        // récupère du Circle cliqué
        Circle circle = (Circle) event.getSource();

        // Créer les ChoiceBox et les TextField
        ChoiceBox<String> choiceBox1 = new ChoiceBox<>();
        TextField textField1 = new TextField();
        ChoiceBox<String> choiceBox2 = new ChoiceBox<>();
        TextField textField2 = new TextField();
        // Remplir les ChoiceBox avec les noms des joueurs


        // Récupérer la liste des joueurs du tournoi
        ArrayList<Joueur> joueurs = AccueilApplication.tournoiActuel.getJoueurs();

        for (Joueur joueur : joueurs) {
            choiceBox1.getItems().add(joueur.getPrenom() + " " + joueur.getNom());
            choiceBox2.getItems().add(joueur.getPrenom() + " " + joueur.getNom());
            choiceBox1.setPrefWidth(200);
            choiceBox2.setPrefWidth(200);
        }

        // Vérifier si la clé existe dans la map
        if (AccueilApplication.tournoiActuel.getMatchs().containsKey(circle.getId())) {
            System.out.println("MATCH DETECTEEEEE");
            Match match = AccueilApplication.tournoiActuel.getMatchs().get(circle.getId());
            Joueur joueur1 = match.getJoueur1();
            Joueur joueur2 = match.getJoueur2();
            int score1 = match.getScore1();
            int score2 = match.getScore2();

            // pré-selectionner les choix
            choiceBox1.getSelectionModel().select(joueur1.getPrenom() + " " + joueur1.getNom());
            choiceBox2.getSelectionModel().select(joueur2.getPrenom() + " " + joueur2.getNom());

            textField1.setText(String.valueOf(score1));
            textField2.setText(String.valueOf(score2));
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Remplir le " + circle.getId());
        alert.setHeaderText(null);
        Image img = new Image(this.getClass().getResource("img/ping-pong.png").toString());
        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        alert.setGraphic(imageView);

        // Ajouter l'écouteur d'événements pour changer le curseur en pointeur
        alert.getDialogPane().setOnMouseEntered(event1 -> {
            Scene scene = alert.getDialogPane().getScene();
            if (scene != null) {
                scene.setCursor(Cursor.HAND);
            }
        });

        // Ajouter l'écouteur d'événements pour restaurer le curseur par défaut
        alert.getDialogPane().setOnMouseExited(event2 -> {
            Scene scene = alert.getDialogPane().getScene();
            if (scene != null) {
                scene.setCursor(Cursor.DEFAULT);
            }
        });


        // Si la liste des joueurs est vide, afficher une alerte
        if (joueurs.isEmpty()) {
            Alert noJoueursAlert = new Alert(Alert.AlertType.WARNING);

            // Ajouter l'écouteur d'événements pour changer le curseur en pointeur
            noJoueursAlert.getDialogPane().setOnMouseEntered(event3 -> {
                Scene scene = noJoueursAlert.getDialogPane().getScene();
                if (scene != null) {
                    scene.setCursor(Cursor.HAND);
                }
            });

            // Ajouter l'écouteur d'événements pour restaurer le curseur par défaut
            noJoueursAlert.getDialogPane().setOnMouseExited(event4 -> {
                Scene scene = noJoueursAlert.getDialogPane().getScene();
                if (scene != null) {
                    scene.setCursor(Cursor.DEFAULT);
                }
            });

            noJoueursAlert.setTitle("Liste de joueurs vide");
            noJoueursAlert.setHeaderText(null);
            noJoueursAlert.setContentText("La liste des joueurs est vide. Veuillez ajouter des joueurs.");
            noJoueursAlert.showAndWait();
            return;
        }



        // Créer le GridPane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Ajouter les éléments au GridPane
        gridPane.add(new Label("🏓 Joueurs :"), 0, 0);
        gridPane.add(choiceBox1, 0, 1);
        gridPane.add(textField1, 1, 1);

        // Ajouter une ligne vide
        gridPane.add(new Label(), 0, 2);

        // Ajouter les éléments au GridPane
        gridPane.add(new Label("🏆 Score"), 1, 0);
        gridPane.add(choiceBox2, 0, 4);
        gridPane.add(textField2, 1, 4);

        // Définir les contraintes de colonnes pour que les ChoiceBox prennent 80% de la largeur
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(60);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(40);
        gridPane.getColumnConstraints().addAll(column1, column2);

        alert.getDialogPane().setContent(gridPane);

        // Ajouter le bouton Annuler
        ButtonType cancelButton = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().add(cancelButton);

        // Vérifier que les deux ChoiceBox et les deux TextField ont été remplis
        ButtonType buttonType = alert.showAndWait().orElse(ButtonType.CANCEL);
        if (buttonType == ButtonType.OK) {
            if (choiceBox1.getValue() == null || choiceBox2.getValue() == null ||
                    textField1.getText().isEmpty() || textField2.getText().isEmpty()) {
                Alert warningAlert = new Alert(Alert.AlertType.WARNING);


                // Ajouter l'écouteur d'événements pour changer le curseur en pointeur
                warningAlert.getDialogPane().setOnMouseEntered(event3 -> {
                    Scene scene = warningAlert.getDialogPane().getScene();
                    if (scene != null) {
                        scene.setCursor(Cursor.HAND);
                    }
                });

                // Ajouter l'écouteur d'événements pour restaurer le curseur par défaut
                warningAlert.getDialogPane().setOnMouseExited(event4 -> {
                    Scene scene = warningAlert.getDialogPane().getScene();
                    if (scene != null) {
                        scene.setCursor(Cursor.DEFAULT);
                    }
                });

                warningAlert.setTitle("Attention !");
                warningAlert.setHeaderText(null);
                warningAlert.setContentText("Veuillez remplir tous les champs !");
                warningAlert.showAndWait();
            } else {
                // Les champs sont remplis, ajouter les informations du match à la liste des matchs
                Joueur joueur1 = joueurs.get(choiceBox1.getSelectionModel().getSelectedIndex());
                Joueur joueur2 = joueurs.get(choiceBox2.getSelectionModel().getSelectedIndex());
                int score1 = Integer.parseInt(textField1.getText());
                int score2 = Integer.parseInt(textField2.getText());
                Match match = new Match(joueur1, joueur2, score1, score2);

                AccueilApplication.tournoiActuel.ajouterMatch(circle.getId(), match);

                Set<String> circleStr = AccueilApplication.tournoiActuel.getMatchs().keySet();
                for(int i =0; i<AccueilApplication.tournoiActuel.getMatchs().size();i++){
                    for (Circle c:circles){
                        if(circleStr.contains(c.getId())){
                            c.setFill(Color.rgb(24,25,28));
                        }else{
                            c.setFill(Color.rgb(154,159,167));
                        }
                    }
                }
            }
        }
    }

}
