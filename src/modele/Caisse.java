package modele;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Caisse {

	public ConcurrentLinkedQueue<Client> fileCaisse;
	private boolean caissiereExperimentee;
	
	public int dureeDeTraitement;
	
	public Caisse(boolean caissiereExperimentee) {
		this.dureeDeTraitement = 0;
		
		this.fileCaisse = new ConcurrentLinkedQueue<>();
		this.caissiereExperimentee = caissiereExperimentee;
	}
	
	public void ajouterClient(Client client) {
		this.fileCaisse.add(client);
	}
	
	public void traitementDesClients() {
		while(!this.fileCaisse.isEmpty()) {
			Client clientActuel = this.fileCaisse.poll();
			if(caissiereExperimentee) {
				dureeDeTraitement += clientActuel.getDureeDeTraitement()/2;
			} else {
				dureeDeTraitement += clientActuel.getDureeDeTraitement();
			}
		}
	}
	
}
