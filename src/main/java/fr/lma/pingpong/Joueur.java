package fr.lma.pingpong;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

public class Joueur {

    // Attributs
    private String nom;
    private String prenom;

    // Constructeurs

    public Joueur(String p_nom, String p_prenom) {
        this.nom = p_nom;
        this.prenom = p_prenom;
    }

    // Accesseurs

    // Getter
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    // Setter
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    //Nécessaire à la deserialization
    public Joueur() {

    }
}
