package fleuriste;

import java.util.Scanner;

public class DemoFleuriste {

	public static void main(String[] args) {
		
		Fleuriste fleuriste = new Fleuriste();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Veuillez saisir votre prénom : ");
		String prenom = sc.next();
		System.out.println("Veuillez saisir votre nom : ");
		String nom = sc.next();		
		fleuriste.creationBouquet(prenom, nom);
		
		System.out.println("Voulez vous ajouter des fleurs ?");
		boolean ajouterFleurs = sc.next().equalsIgnoreCase("oui");
		while(ajouterFleurs) {
			System.out.println("Quelle fleur voulez vous ajouter ?");
			String fleurAAjouter = sc.next();
			System.out.println("Nous disposons de "+fleuriste.quantiteEnStock(fleurAAjouter)+" "+fleurAAjouter);
			System.out.println("A un prix de "+fleuriste.prixDUneFleur(fleurAAjouter)+" € l'unité");
			System.out.println("Quelle quantité voulez vous ?");
			int quantiteAAjouter = sc.nextInt();
			fleuriste.ajoutFleur(fleurAAjouter, quantiteAAjouter);
			fleuriste.getBouquetEnCours().calculerPrix();
			System.out.println("le prix du bouquet est de "+fleuriste.getBouquetEnCours().getPrix()+ " €");
			System.out.println("Voulez vous ajouter des fleurs ?");
			ajouterFleurs = sc.next().equalsIgnoreCase("oui");
		}
		fleuriste.facturation();
	}
	
}
