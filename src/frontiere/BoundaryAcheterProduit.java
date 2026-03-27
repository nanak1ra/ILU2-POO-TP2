package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifIdentite(nomAcheteur)) {
			System.out.println("Je suis désolé " + nomAcheteur
					+ " mais il faut être habitant de notre village pour commercer ici.");
		}

		else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			String[] vendeurs = controlAcheterProduit.trouverVendeurProduit(produit);

			if (vendeurs == null) {
				System.out.println("Désolé, personne ne vend de ce produit sur le marché.");
			}

			else {
				String nomVendeur = selectionnerVendeur(vendeurs, produit);
				faireAchat(nomAcheteur, nomVendeur, produit);

			}
		}
	}

	private String selectionnerVendeur(String[] vendeurs, String produit) {

		StringBuilder propCommercant = new StringBuilder();
		propCommercant.append("Chez quel commerçant souhaitez-vous acheter des " + produit + " :\n");

		for (int i = 0; i < vendeurs.length; i++) {
			propCommercant.append((i + 1));
			propCommercant.append(" - ");
			propCommercant.append(vendeurs[i]);
		}

		int choixCommercant = Clavier.entrerEntier(propCommercant.toString());
		while (choixCommercant <= 0 || choixCommercant > vendeurs.length) {
			choixCommercant = Clavier.entrerEntier(propCommercant.toString());
		}

		return vendeurs[choixCommercant - 1];
	}

	private void faireAchat(String nomAcheteur, String nomVendeur, String produit) {

		System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur + ".");

		int quantite = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
		int quantiteAchetee = controlAcheterProduit.acheterProduit(nomVendeur, quantite);

		if (quantiteAchetee <= 0) {
			System.out.println(
					nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement il n'y en a plus !");
		} else if (quantiteAchetee < quantite) {
			System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement "
					+ nomVendeur + " n'en a plus que " + quantiteAchetee + ". " + nomAcheteur
					+ " achète tout le stock de " + nomVendeur + ".");
		} else {
			System.out.println(nomAcheteur + " achète " + quantiteAchetee + " " + produit + " à " + nomVendeur);
		}
	}

}
