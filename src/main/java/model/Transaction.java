package model;

import java.util.Date;

public class Transaction {
	public enum TypeTransaction {
        VIRINT, VIREST, VIRCHAC, VIRMULTA
    }

    private String reference;
    private TypeTransaction type;
    private Date timeStamp;
    private Compte compteSource;
    private Compte compteDestination;
    
 // Constructeur par défaut
    public Transaction() {
    }

    public Transaction(String reference, TypeTransaction type, Compte compteSource, Compte compteDestination) {
        this.reference = reference;
        this.type = type;
        this.timeStamp = new Date();
        this.compteSource = compteSource;
        this.compteDestination = compteDestination;
    }

 // Méthode pour calculer le type de transaction selon les critères fournis
    
    private TypeTransaction calculerTypeTransaction() {
        Client clientSource = compteSource.getClient();
        Client clientDestination = compteDestination.getClient();

        if (clientSource == null || clientDestination == null) {
            throw new IllegalArgumentException("Les comptes doivent avoir des clients associés.");
        }

        if (clientSource.getNumClient().equals(clientDestination.getNumClient())) {
            return TypeTransaction.VIRINT;  // Même banque
        } else if (clientSource.getAdresse().equals(clientDestination.getAdresse())) {
            return TypeTransaction.VIREST;  // Même pays
        } else if (!clientSource.getNumClient().equals(clientDestination.getNumClient()) &&
                   !clientSource.getAdresse().equals(clientDestination.getAdresse())) {
            return TypeTransaction.VIRCHAC;  // Banques et pays différents
        } else {
            return TypeTransaction.VIRMULTA;  // Par défaut, pour des clients de la même banque
        }
    }

    // Getters et Setters pour les champs
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public TypeTransaction getType() {
        return type;
    }

    public void setType(TypeTransaction type) {
        this.type = type;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Compte getCompteSource() {
        return compteSource;
    }

    public void setCompteSource(Compte compteSource) {
        this.compteSource = compteSource;
    }

    public Compte getCompteDestination() {
        return compteDestination;
    }

    public void setCompteDestination(Compte compteDestination) {
        this.compteDestination = compteDestination;
    }
}

