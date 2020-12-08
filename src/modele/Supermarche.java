package modele;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Supermarche {

	private ConcurrentLinkedQueue<Client> fileGlobale;
	private int nombreCaisses;
	public Caisse[] listeCaisse;

	public Supermarche(int nombreCaisses, ConcurrentLinkedQueue<Client> fileGlobale) {
		this.fileGlobale = fileGlobale;
		this.nombreCaisses = nombreCaisses;

		this.listeCaisse = new Caisse[nombreCaisses];
		this.creationCaisse();
		this.repartitionParCaisse();
		
	}
	
	public void ajouterClient(Client client) {
		this.fileGlobale.add(client);
	}

	public void creationCaisse() {
		for(int i = 0; i < this.nombreCaisses; i++) {
			this.listeCaisse[i] = new Caisse(false);
		}
	}

	public void repartitionParCaisse() {
		try {
			//Premier client: on sauvegarde sa date d'arrivé pour la comparer aux clients suivants
			Client clientReferent = this.fileGlobale.peek();
			
			while(!this.fileGlobale.isEmpty() && clientReferent.getDate() == this.fileGlobale.peek().getDate()) {
				for(int i = 0; i < this.nombreCaisses; i++) {
					
					//Si la liste n'est pas vide et que le client suivant arrive à la même date que le client Référent
					//alors on lui attribue une caisse
					if(!this.fileGlobale.isEmpty() && clientReferent.getDate() == this.fileGlobale.peek().getDate()) {
					
						Client clientActuel = this.fileGlobale.peek();this.fileGlobale.poll();
						this.listeCaisse[i].ajouterClient(clientActuel);
					
					}
				}
			}
			
		} catch(Exception e) {
			e.fillInStackTrace();
		}
	}
	
	public int traitementCaisse(int numeroCaisse) {
		this.listeCaisse[numeroCaisse].traitementDesClients();
		return this.listeCaisse[numeroCaisse].dureeDeTraitement;
	}
}
 