package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.jupiter.api.Test;

import modele.Client;
import modele.Supermarche;

class SupermarcheTests {

	
	@Test
	public void testRepartition() {
		int dureeTraitement = 2;
		ConcurrentLinkedQueue<Client> fileGlobale = new ConcurrentLinkedQueue<>();
		fileGlobale.add(new Client(0, dureeTraitement));
		fileGlobale.add(new Client(0, dureeTraitement));
		fileGlobale.add(new Client(0, dureeTraitement));
		
		fileGlobale.add(new Client(1, dureeTraitement));
		fileGlobale.add(new Client(1, dureeTraitement));
		
		Supermarche s = new Supermarche(2, fileGlobale);
		
		assertEquals(2, s.listeCaisse[0].fileCaisse.size());
		assertEquals(1, s.listeCaisse[1].fileCaisse.size());
		
		assertEquals(4, s.traitementCaisse(0));
		assertEquals(2, s.traitementCaisse(1));
	}

}
