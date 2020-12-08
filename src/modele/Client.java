package modele;

public class Client {

	private int date;
	private int dureeTraitement;
	
	public Client(int date, int dureeTraitement) {
		this.date = date;
		this.dureeTraitement = dureeTraitement;
	}
	
	public int getDate() {
		return this.date;
	}
	
	public int getDureeDeTraitement() {
		return this.dureeTraitement;
	}
	
	
}
