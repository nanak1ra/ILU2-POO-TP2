package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard.\n");
		}

		else {
			StringBuilder sortie = new StringBuilder();
			sortie.append(nomAcheteur);
			sortie.append(", vous trouverez au marché :\n");

			for (int i = 0; i < infosMarche.length; i++) {
				sortie.append("-");
				sortie.append(infosMarche[i]);
				sortie.append(" qui vend ");
				sortie.append(i + 1);
				sortie.append(" ");
				sortie.append(i + 2);
				sortie.append(".\n");
			}
		}
	}
}
