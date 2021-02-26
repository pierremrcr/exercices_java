package natsystem.poe2021.epreuve.exo3.srv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import natsystem.poe2021.epreuve.exo3.dao.DaoPersonne;
import natsystem.poe2021.epreuve.exo3.datamodel.Personne;
import natsystem.poe2021.epreuve.exo3.datamodel.Sexe;
import natsystem.poe2021.epreuve.exo3.exceptions.EntiteException;
import natsystem.poe2021.epreuve.exo3.exceptions.PersistenceException;

public class SrvAnalyse implements ISrvAnalyse {

	private static SrvAnalyse srvAnalyse;
	private static DaoPersonne daoPersonne;

	private SrvAnalyse() {}

	public static SrvAnalyse getInstance() {
		if (srvAnalyse == null) {
			srvAnalyse = new SrvAnalyse();
			daoPersonne = DaoPersonne.getInstance(); 
		}
		return srvAnalyse;
	}


	@Override
	public Double moyenneAge(List<Personne> listPersonnes) {
		Double moyenne = listPersonnes.stream()
				.mapToInt(personne -> personne.getAge())
				.average()
				.getAsDouble();
		return moyenne;
	}


	@Override
	public List<Personne> getListePersonnes() throws PersistenceException {
		List<Personne> listePersonnes = daoPersonne.loadAll();
		Collections.sort(listePersonnes, Personne.ComparatorAge);
		return listePersonnes;
	}


	@Override
	public List<Personne> getListeFemmes() throws PersistenceException {
		List<Personne> listeFemmes = new ArrayList<>();
		List<Personne> listePersonnes = daoPersonne.loadAll();
		for (Personne p : listePersonnes) {
			if (p.getSexe().equals(Sexe.FEMME)) {
				listeFemmes.add(p);
			}
		}
		Collections.sort(listeFemmes, Personne.ComparatorAge);
		return listeFemmes;
	}

	@Override
	public List<Personne> getListeHommes() throws PersistenceException {
		List<Personne> listePersonnes = daoPersonne.loadAll();
		List<Personne> listeHommes = new ArrayList<>();
		for (Personne p : listePersonnes) {
			if(p.getSexe().equals(Sexe.HOMME)) {
				listeHommes.add(p);
			}
		}
		Collections.sort(listeHommes, Personne.ComparatorAge);
		return listeHommes;
	}


	@Override
	public Double getDistance(Personne p1, Personne p2) throws PersistenceException, EntiteException {
		return  (double) Math.round(6378 * Math.acos(
				Math.sin(p1.getLatitude() * 0.01745329252) * Math.sin(p2.getLatitude() * 0.01745329252) + 
				Math.cos(p1.getLatitude() * 0.01745329252) * Math.cos(p2.getLatitude() * 0.01745329252) * 
				Math.cos((p2.getLongitude() - p1.getLongitude()) * 0.01745329252)));	
	}



	@Override
	public Map<Sexe, Double> moyenneAgeParSexe(List<Personne> listPersonnes) {

		Map<Sexe, Double> moyenneAgeParSexe = new HashMap<>();

		List<Personne> listeHommes = new ArrayList<>();
		List<Personne> listeFemmes = new ArrayList<>();

		try {
			
			listeHommes = this.getListeHommes(listPersonnes);
			listeFemmes = this.getListeFemmes(listPersonnes);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		}

		Double moyenneAgeHommes = this.moyenneAge(listeHommes);
		Double MoyenneAgeFemmes = this.moyenneAge(listeFemmes);

		moyenneAgeParSexe.put(Sexe.HOMME, moyenneAgeHommes);
		moyenneAgeParSexe.put(Sexe.FEMME, MoyenneAgeFemmes);

		return moyenneAgeParSexe;

	}

	@Override
	public Map<String, Integer> nombrePersonnesParVille(List<Personne> listPersonnesParVille) {

		Map<String, Integer> nombrePersonnesParVille = new HashMap<>();
		Integer nbPersonnes = 0;
		List<String> villes = new ArrayList<>();

		for(Personne personne : listPersonnesParVille) {
			villes.add(personne.getVille());
		}

		Set<String> villesSansDoublon = new HashSet<>(villes);

		for (String ville : villesSansDoublon) { 	
			for (Personne personne : listPersonnesParVille) { 
				if (ville.equals(personne.getVille())) { 
					nbPersonnes ++;
					nombrePersonnesParVille.put(personne.getVille(), nbPersonnes);
				}
			}
			nbPersonnes = 0;
		}
		
		return nombrePersonnesParVille;
	}

	@Override
	public List<Personne> getListeHommes(List<Personne> listePersonnes) throws PersistenceException {
		List<Personne> listeHommes = new ArrayList<>();
		
		for (Personne p : listePersonnes) {
			if(p.getSexe().equals(Sexe.HOMME)) {
				listeHommes.add(p);
			}
		}
		Collections.sort(listeHommes, Personne.ComparatorAge);
		return listeHommes;
	}

	@Override
	public List<Personne> getListeFemmes(List<Personne> listPersonnes) throws PersistenceException {
		List<Personne> listeFemmes = new ArrayList<>();
		
		for (Personne p : listPersonnes) {
			if(p.getSexe().equals(Sexe.FEMME)) {
				listeFemmes.add(p);
			}
		}
		Collections.sort(listeFemmes, Personne.ComparatorAge);
		return listeFemmes;
	}


	@Override
	public int nombreVillesDepuisNomPersonne(List<Personne> listPersonnes, String nom) {
		
		List<String> villes = new ArrayList<>();
		
		List<Personne>listPersonnesByNom = listPersonnes.stream()
		.filter(personne -> personne.getNom().equals(nom))
        .collect(Collectors.toList());
		
		for (Personne personne : listPersonnesByNom) {
			villes.add(personne.getVille());
		}
		
		Set<String> villesSansDoublon = new HashSet<>(villes);
		
	return villesSansDoublon.size();


}
	
}
