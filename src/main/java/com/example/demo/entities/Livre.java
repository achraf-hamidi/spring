package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Livre {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private Integer pagenNmber;
    @Column(unique=true)
    @NotNull
    private  String ISBN ;
    @NotNull
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date datePublication;
    @NotNull
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dernierConsultation;

    private boolean estDisponible ;
    @NotNull
    private String Titre;
    @NotNull
    private String maisonEdition;
    @NotNull
    private String Auteur;

    public Livre() {
    }

    public Livre(Integer id, Integer pagenNmber, String isbn, Date datePublication, Date dernierConsultation, boolean estDisponible, String titre, String maisonEdition, String auteur) {
        this.id = id;
        this.pagenNmber = pagenNmber;
        ISBN = isbn;
        this.datePublication = datePublication;
        this.dernierConsultation = dernierConsultation;
        this.estDisponible = estDisponible;
        Titre = titre;
        this.maisonEdition = maisonEdition;
        Auteur = auteur;
    }





    public Integer getPagenNmber() {
        return pagenNmber;
    }

    public String getISBN() {
        return ISBN;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public Date getDernierConsultation() {
        return dernierConsultation;
    }

    public boolean isEstDisponible() {
        return estDisponible;
    }

    public String getTitre() {
        return Titre;
    }

    public String getMaisonEdition() {
        return maisonEdition;
    }

    public String getAuteur() {
        return Auteur;
    }


    public void setPagenNmber(@NonNull Integer pagenNmber) {
        this.pagenNmber = pagenNmber;
    }



    public void setDatePublication( @NonNull Date datePublication) {
        this.datePublication = datePublication;
    }

    public void setDernierConsultation(@NonNull Date dernierConsultation) {
        this.dernierConsultation = dernierConsultation;
    }

    public void setEstDisponible(boolean estDisponible) {
        this.estDisponible = estDisponible;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public void setMaisonEdition(@NonNull String maisonEdition) {
        this.maisonEdition = maisonEdition;
    }

    public void setAuteur(@NonNull String auteur) {
        Auteur = auteur;
    }
}
