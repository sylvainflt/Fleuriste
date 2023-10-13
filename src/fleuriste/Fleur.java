package fleuriste;

public class Fleur {

	private String nom;
	private float prixUnitaire;
	private int quantite;
	
	public Fleur(String nom, float prixUnitaire, int quantite) {
		super();
		this.nom = nom;
		this.prixUnitaire = prixUnitaire;
		this.quantite = quantite;
	}

	public String getNom() {
		return nom;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public int getQuantite() {
		return quantite;
	}
	
	public void retirerQuantite(int quantiteARetirer) {
		if(quantiteARetirer <= quantite) {
			quantite -= quantiteARetirer;
		}else {
			System.out.println("quantité insuffisante");
		}
	}
	
	
}
