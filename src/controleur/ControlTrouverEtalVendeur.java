package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		Gaulois vendeur = village.trouverHabitant(nomVendeur);
		Etal etal = null;
		if (village.trouverHabitant(nomVendeur) != null) {
			etal = village.rechercherEtal(vendeur);
		}
		return etal;
	}

	public String[] trouverVendeurProduit(String produit) {
		String[] vendeurs = null;
		Gaulois[] vendeursGaulois = village.rechercherVendeursProduit(produit);

		if (vendeursGaulois != null) {
			int len = vendeursGaulois.length;
			vendeurs = new String[len];

			for (int i = 0; i < len; i++) {
				vendeurs[i] = vendeursGaulois[i].getNom();
			}
		}
		return vendeurs;
	}

}
