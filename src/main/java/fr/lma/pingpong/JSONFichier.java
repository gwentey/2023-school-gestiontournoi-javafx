package fr.lma.pingpong;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class JSONFichier {

    // Attributs
    private static String SE = System.getProperty("os.name").toLowerCase();
    private static String CHEMIN_DONNEES_O;

    private String chemin;



    /**
     * Permet de determiner le chemin d'accès en fonction de l'OS de l'utilisateur
     */
    public static void whatIsMyOS(){
        if (SE.indexOf("mac") >= 0) {
            CHEMIN_DONNEES_O = "src/main/resources/fr/lma/pingpong/data/";
        } else {
            CHEMIN_DONNEES_O = "src\\main\\resources\\fr\\lma\\pingpong\\data\\";
        }
    }

    public static void writeJsonFile(Tournoi tournoi) {
        whatIsMyOS();
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(CHEMIN_DONNEES_O + tournoi.getNom() + ".json"), tournoi);

        } catch (Exception e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }


    public static ArrayList<Tournoi> lireTousLesFichiersJson() {
        whatIsMyOS();
        ArrayList<Tournoi> jsonObjects = new ArrayList<>();
        File folder = new File(CHEMIN_DONNEES_O);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));
        if (files != null) {
            for (File file : files) {
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    Tournoi jsonObject = mapper.readValue(file, TournoiSimple.class);
                    jsonObjects.add(jsonObject);
                } catch (Exception e) {
                    System.err.println("Error reading file: " + file.getAbsolutePath() + ", " + e.getMessage());
                }
            }
        }
        return jsonObjects;
    }
}
