package natsystem.poe2021.epreuve.exo3;

import java.util.List;

import natsystem.poe2021.epreuve.exo3.dao.DaoPersonne;
import natsystem.poe2021.epreuve.exo3.datamodel.Personne;
import natsystem.poe2021.epreuve.exo3.exceptions.PersistenceException;

public class Main {

	public static void main(String[] args) throws PersistenceException {
		
		DaoPersonne daoPersonne = DaoPersonne.getInstance();
		
		List<Personne> listePersonnes = daoPersonne.loadAll();
		
		System.out.println("nb personnes : " + listePersonnes.size());
		
		for (Personne personne : listePersonnes) {
			System.out.println(personne.getAge());
		}
		
		
			
	}

}
