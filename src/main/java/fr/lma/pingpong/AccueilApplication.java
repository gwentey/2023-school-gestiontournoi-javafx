package fr.lma.pingpong;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class AccueilApplication extends Application {

    // Attribut statique falicitant la modification du .fxml utilisé par le stage courrant
    public static Stage stage;

    public static Tournoi tournoiActuel;
    public static ArrayList<Tournoi> tournois = new ArrayList<>();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {


        // Tous les tournois sont chargés au démarrage (nécessaire ce que ce soit la première chose à charger)
        tournois = JSONFichier.lireTousLesFichiersJson();
        System.out.println(tournois);

        // Scène d'accueil
        FXMLLoader fxmlLoader = new FXMLLoader(AccueilApplication.class.getResource("accueil.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 720);

        stage.setTitle("Ping Pong - Gestion");
        stage.getIcons().add(new Image(Objects.requireNonNull(AccueilApplication.class.getResourceAsStream("img/ping-pong.png"))));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        AccueilApplication.stage = stage;
    }

    /**
     * Permet de changer le fichier FXML couremment utilisé par le stage (fenêtre d'application) ouverte
     * @param nomFichierFXML Nom du fichier FXML (avec extension) à charger
     */
    public static void setFXMLForStage(String nomFichierFXML) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(AccueilApplication.class.getResource(nomFichierFXML));
            Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
            Stage stage = AccueilApplication.stage;
            stage.setScene(scene);
        } catch (IOException ioe) {
            System.err.println("Le Fichier FXML "+nomFichierFXML+" n'a pas pu être chargé");
            System.err.println(ioe);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}