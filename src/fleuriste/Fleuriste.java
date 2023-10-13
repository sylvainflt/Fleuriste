package fleuriste;

import java.util.List;
import java.util.Vector;

public class Fleuriste implements InterfaceFleuriste{

	private List<String> clients;
	
	private List<Bouquet> bouquetsCommandes;
	
	private List<Fleur> stockDeFleurs;
	
	private Bouquet bouquetEnCours;

	public Fleuriste() {
		super();
		clients = new Vector<String>();
		bouquetsCommandes = new Vector<Bouquet>();
		stockDeFleurs = new Vector<Fleur>();
		stockDeFleurs.add(new Fleur("rose", 10, 30));
		stockDeFleurs.add(new Fleur("violette", 3, 20));
		stockDeFleurs.add(new Fleur("tulipe", 6, 60));
	}

	public List<String> getClients() {
		return clients;
	}

	public List<Bouquet> getBouquetsCommandes() {
		return bouquetsCommandes;
	}

	public Bouquet getBouquetEnCours() {
		return bouquetEnCours;
	}

	@Override
	public void creationBouquet(String prenom, String nom) {
		bouquetEnCours = new Bouquet(prenom+" "+nom);
		clients.add(prenom+" "+nom);
	}

	@Override
	public int quantiteEnStock(String nomFleur) {
		int quantite = 0;
		for(Fleur f: stockDeFleurs) {
			if(nomFleur.equals(f.getNom())) {
				quantite = f.getQuantite();
				return quantite;
			}
		}
		return quantite;
	}

	@Override
	public float prixDUneFleur(String nomFleur) {
		float prixUnitaire = 0;
		for(Fleur f: stockDeFleurs) {
			if(nomFleur.equals(f.getNom())) {
				prixUnitaire = f.getPrixUnitaire();
				return prixUnitaire;
			}
		}
		return prixUnitaire;
	}

	@Override
	public void ajoutFleur(String nomFleur, int qte) {
		float prixUnitaire = prixDUneFleur(nomFleur);
		bouquetEnCours.ajouterFleur(new Fleur(nomFleur, prixUnitaire, qte));
		// on enleve la fleur du stock
		for(Fleur f : stockDeFleurs) {
			if(f.getNom().equals(nomFleur)) {
				f.retirerQuantite(qte);
			}
		}
	}

	@Override
	public void facturation() {
		System.out.println("le bouquet pour "+bouquetEnCours.getClient()+" contient : ");
		for(Fleur f : bouquetEnCours.getFleurs()) {
			System.out.println(f.getQuantite()+ " "+f.getNom()+" a "+f.getPrixUnitaire()+" €");
		}		
		bouquetEnCours.calculerPrix();
		System.out.println("soit un total de "+bouquetEnCours.getPrix()+" €");
		System.out.println("-----------------------");
		System.out.println("Le bouquet est terminé.");
		System.out.println("-----------------------");
		
		bouquetsCommandes.add(bouquetEnCours);		
	}
	
	
	
}
