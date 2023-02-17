package fr.lma.pingpong;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

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

    @FXML
    private Circle circleMatch1;
    @FXML
    private Circle circleMatch2;
    @FXML
    private Circle circleMatch3;
    @FXML
    private Circle circleMatch4;
    @FXML
    private Circle circleMatch5;
    @FXML
    private Circle circleMatch6;
    @FXML
    private Circle circleMatch7;

// ...


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

    @FXML
    private void handleCircleClick(MouseEvent event) {
        Circle circle = (Circle) event.getSource();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Remplir le " +  circle.getId());
        alert.setHeaderText(null);

        // Créer les ChoiceBox et les TextField
        ChoiceBox choiceBox1 = new ChoiceBox();
        TextField textField1 = new TextField();
        ChoiceBox choiceBox2 = new ChoiceBox();
        TextField textField2 = new TextField();

        // Créer le GridPane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Ajouter les éléments au GridPane
        gridPane.add(choiceBox1, 0, 0);
        gridPane.add(textField1, 1, 0);

        // Ajouter une ligne vide
        gridPane.add(new Label(), 0, 1);

        // Ajouter les éléments au GridPane
        gridPane.add(choiceBox2, 0, 2);
        gridPane.add(textField2, 1, 2);

        // Définir les contraintes de colonnes pour que les ChoiceBox prennent 80% de la largeur
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(60);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(40);
        gridPane.getColumnConstraints().addAll(column1, column2);

        alert.getDialogPane().setContent(gridPane);
        alert.showAndWait();
    }


}
