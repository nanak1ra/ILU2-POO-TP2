package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean appartenirVillage = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!appartenirVillage) {
			System.out.println("Je suis désolée " + nomVendeur + " mais il faut être "
					+ "un habitant de notre village pour commercer ici.\n");
		} else {
			System.out.println("Bonjour " + nomVendeur + " je vais regarder si je peux vous trouver un étal.\n");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolée " + nomVendeur + " je n'ai plus d'étal qui ne soit pas déjà occupé.\n");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder question = new StringBuilder();
		question.append("C'est parfait, il me reste un étal pour vous.\n");
		question.append("Il me faudrait quelques renseignements :\n");
		question.append("Quel produit souhaitez-vous vendre ?");
		String produit = Clavier.entrerChaine(question.toString());
		int nbproduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbproduit);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numeroEtal);
		}
	}
}
