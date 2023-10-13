package fleuriste;

import java.util.List;
import java.util.Vector;

public class Bouquet {

	private List<Fleur> fleurs;
	private int prix;
	private String client;
	
	public Bouquet(String client) {
		super();
		this.fleurs = new Vector<Fleur>();
		this.client = client;
	}

	public String getClient() {
		return client;
	}
	
	public List<Fleur> getFleurs() {
		return fleurs;
	}

	public void ajouterFleur(Fleur f) {
		fleurs.add(f);
	}
	
	public int getPrix() {
		return prix;
	}

	public void calculerPrix() {
		int prixTotal = 0;
		for(Fleur f: fleurs) {
			prixTotal += f.getPrixUnitaire() * f.getQuantite();
		}
		prix = prixTotal;
	}
	
	
}
