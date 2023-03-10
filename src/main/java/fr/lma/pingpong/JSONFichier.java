package fr.lma.pingpong;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;

public class JSONFichier {

    // Attributs
    private static final String SE = System.getProperty("os.name").toLowerCase();
    private static String CHEMIN_DONNEES_O;

    /**
     * Supprime le fichier JSON associé au tournoi spécifié.
     *
     * @param tournoi Le tournoi qu'il faut supprimer.
     */
    public static void supprimerTournoi(Tournoi tournoi) {
        whatIsMyOS();
        String nomFichier = CHEMIN_DONNEES_O + tournoi.getNom() + "-" + tournoi.getDateDebut() + ".json";
        File fichier = new File(nomFichier);
        if (fichier.exists()) {
            if(!fichier.delete()){
                System.out.println("Erreur de suppression du fichier");
            }else{
                System.out.println("Fichier " + nomFichier + " supprimé avec succès.");
            }
        } else {
            System.out.println("Le fichier " + nomFichier + " n'existe pas.");
        }

    }


    /**
     * Permet de determiner le chemin d'accès en fonction de l'OS de l'utilisateur
     */
    public static void whatIsMyOS(){
        if (SE.contains("mac")) {
            CHEMIN_DONNEES_O = "src/main/resources/fr/lma/pingpong/data/";
        } else {
            CHEMIN_DONNEES_O = "src\\main\\resources\\fr\\lma\\pingpong\\data\\";
        }
    }

    /**
     * Écrit un objet Tournoi dans un fichier JSON, en utilisant le nom et la date de début du tournoi pour déterminer le nom du fichier.
     *
     * @param tournoi l'objet Tournoi à enregistrer dans le fichier JSON
     */
    public static void writeJsonFile(Tournoi tournoi) {
        whatIsMyOS();
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(CHEMIN_DONNEES_O + tournoi.getNom() + "-" + tournoi.getDateDebut() + ".json"), tournoi);

        } catch (Exception e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    /**
     * Permet de lire tous les fichiers JSON dans le répertoire data et de les convertir en objets Tournoi.
     * Les fichiers sont filtrés par leur extension '.json'.
     *
     * @return une liste d'objets Tournoi correspondant aux fichiers JSON trouvés
     */
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
    /**
     * Permet de d'ajouter un fichier JSON dans le répertoire data
     * @param file le fichier JSON à lire
     */
    public static void lireFichierJson(File file) {
        whatIsMyOS();
        try {
            ObjectMapper mapper = new ObjectMapper();
            Tournoi tournoi = mapper.readValue(file, TournoiSimple.class);
            JSONFichier.writeJsonFile(tournoi);

        } catch (Exception e) {
            System.err.println("Error reading file: " + file.getAbsolutePath() + ", " + e.getMessage());
        }
    }



}
