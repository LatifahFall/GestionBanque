package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;

public class Compte {
	
	private String numCompte;
    private Date dateCrea;
    private Date dateUpdate;
    private String devise;

    @JsonBackReference
    private Client client;
    
 // Constructeur par défaut
    public Compte() {
    }

    public Compte(String numCompte, Date dateCrea, String devise, Client client) {
        this.numCompte = numCompte;
        this.dateCrea = dateCrea;
        this.dateUpdate = dateCrea;
        this.devise = devise;
        this.client = client;
    }

    // Getters et setters
    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public Date getDateCrea() {
        return dateCrea;
    }

    public void setDateCrea(Date dateCrea) {
        this.dateCrea = dateCrea;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
