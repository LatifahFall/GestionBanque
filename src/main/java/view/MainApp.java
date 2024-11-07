package view;

import model.Client;
import model.Compte;
import model.Transaction;
import model.Transaction.TypeTransaction;
import utils.JsonConverter;
import java.util.Date;

public class MainApp{

	public static void main(String[] args) {

        // QUESTION 1 : Création des objets Client, Compte, et Transaction
        Client client1 = new Client("001", "Dupont", "Jean", "France", "0123456789", "jean.dupont@mail.com");
        Client client2 = new Client("002", "Martin", "Paul", "France", "0987654321", "paul.martin@mail.com");
        Client client3 = new Client("003", "Doe", "John", "USA", "1234567890", "john.doe@mail.com");

        Compte compte1 = new Compte("C001", new Date(), "EUR", client1);
        Compte compte2 = new Compte("C002", new Date(), "EUR", client2);
        Compte compte3 = new Compte("C003", new Date(), "USD", client3);
        
        TypeTransaction type1 = TypeTransaction.VIREST;
        TypeTransaction type2 = TypeTransaction.VIRCHAC;
        TypeTransaction type3 = TypeTransaction.VIRINT;


        System.out.println("Clients et Comptes créés avec succès.");

        // QUESTION 3 : Calcul automatique du type de transaction
        Transaction transaction1 = new Transaction("T001", type1, compte1, compte2); // Devrait être VIREST (même pays)
        System.out.println("Transaction 1 Type: " + transaction1.getType());

        Transaction transaction2 = new Transaction("T002", type2, compte1, compte3); // Devrait être VIRCHAC (banque et pays différents)
        System.out.println("Transaction 2 Type: " + transaction2.getType());

        Transaction transaction3 = new Transaction("T003", type3, compte1, compte1); // Devrait être VIRINT (même client/banque)
        System.out.println("Transaction 3 Type: " + transaction3.getType());

        // QUESTION 4 : Sérialisation et désérialisation JSON
        try {
            // Sérialisation des objets en JSON
            String clientJson = JsonConverter.toJson(client1);
            System.out.println("Client en JSON : " + clientJson);

            String compteJson = JsonConverter.toJson(compte1);
            System.out.println("Compte en JSON : " + compteJson);

            String transactionJson = JsonConverter.toJson(transaction1);
            System.out.println("Transaction en JSON : " + transactionJson);

            // Désérialisation du JSON en objets
            Client clientFromJson = JsonConverter.fromJson(clientJson, Client.class);
            System.out.println("Client désérialisé depuis JSON : " + clientFromJson.getNom() + " " + clientFromJson.getPrenom());

            Compte compteFromJson = JsonConverter.fromJson(compteJson, Compte.class);
            System.out.println("Compte désérialisé depuis JSON : " + compteFromJson.getNumCompte());

            Transaction transactionFromJson = JsonConverter.fromJson(transactionJson, Transaction.class);
            System.out.println("Transaction désérialisée depuis JSON : " + transactionFromJson.getReference() + " de type " + transactionFromJson.getType());
        } catch (Exception e) {
            System.err.println("Erreur lors de la sérialisation/désérialisation JSON : " + e.getMessage());
        }
    }

}
