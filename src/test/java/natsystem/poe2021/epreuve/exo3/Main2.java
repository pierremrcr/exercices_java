package natsystem.poe2021.epreuve.exo3;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import natsystem.poe2021.epreuve.exo3.datamodel.Personne;
import natsystem.poe2021.epreuve.exo3.datamodel.Sexe;
import natsystem.poe2021.epreuve.exo3.exceptions.EntiteException;
import natsystem.poe2021.epreuve.exo3.exceptions.PersistenceException;
import natsystem.poe2021.epreuve.exo3.srv.SrvAnalyse;

public class Main2 {

	private static SrvAnalyse srvAnalyse = SrvAnalyse.getInstance();

	@Test
	public void getListPersonneTest() throws PersistenceException {
		List<Personne> listePersonnes = srvAnalyse.getListePersonnes();
		Assert.assertTrue(listePersonnes.size()==30);
		for (Personne p : listePersonnes) {
			System.out.println(p);
		}

	}

	@Test
	public void getDistanceTest() throws PersistenceException, EntiteException {
		List<Personne> listePersonnes = srvAnalyse.getListePersonnes();
		Personne p1 = listePersonnes.get(1); 
		Personne p2 = listePersonnes.get(2);
		System.out.println(srvAnalyse.getDistance(p1, p2));
		Assert.assertTrue(srvAnalyse.getDistance(p1, p2) != 0);

	}

	@Test
	public void getListHommes() throws PersistenceException {
		List<Personne> listeHommes = srvAnalyse.getListeHommes();
		for(Personne p : listeHommes) {
			Assert.assertTrue(p.getSexe().equals(Sexe.HOMME));	
		}

	}

	@Test
	public void getListFemmes() throws PersistenceException {
		List<Personne> listeFemmes = srvAnalyse.getListeFemmes();
		for(Personne p : listeFemmes) {
			Assert.assertTrue(p.getSexe().equals(Sexe.FEMME));
		}

	}

	@Test
	public void moyenneAgeTest() throws PersistenceException {
		List<Personne> listePersonnes = srvAnalyse.getListePersonnes();
		Double moyenne = srvAnalyse.moyenneAge(listePersonnes);
		Assert.assertEquals(45, Math.round(moyenne));

	}

	@Test
	public void moyenneAgeParSexeTest() throws PersistenceException {

		List<Personne> listePersonnes = srvAnalyse.getListePersonnes();
		Map<Sexe,Double> moyenneAgeParSexe = srvAnalyse.moyenneAgeParSexe(listePersonnes);

		Assert.assertEquals(48, Math.round(moyenneAgeParSexe.get(Sexe.FEMME)));
		Assert.assertEquals(42, Math.round(moyenneAgeParSexe.get(Sexe.HOMME)));

	}

	@Test
	public void nombrePersonnesParVilleTest() throws PersistenceException {
		List<Personne> listePersonnes = srvAnalyse.getListePersonnes();
		Map<String, Integer> nombrePersonnesParVille = srvAnalyse.nombrePersonnesParVille(listePersonnes);
		Assert.assertEquals((Integer)4,  nombrePersonnesParVille.get("LaMouche"));
	}

	@Test
	public void nombreVillesDepuisNomPersonneTest() throws PersistenceException {
		List<Personne> listePersonnes = srvAnalyse.getListePersonnes();
		System.out.println(srvAnalyse.nombreVillesDepuisNomPersonne(listePersonnes, "TOUILLE"));
		Assert.assertEquals(2,srvAnalyse.nombreVillesDepuisNomPersonne(listePersonnes, "TOUILLE"));
	}

	@Test
	public void getDistanceBetweenYoungestManAndOldestWoman() throws PersistenceException, EntiteException   {
		List<Personne> listeHommes = srvAnalyse.getListeHommes();
		List<Personne> listeFemmes = srvAnalyse.getListeFemmes();
		Personne oldestWoman = new Personne();
		Personne youngestMan = new Personne();

		List<Personne> oldestWomen = listeFemmes.stream()
				.collect(Collectors.groupingBy(e -> e.getAge(), TreeMap::new, Collectors.toList()))
				.lastEntry().getValue();

		List<Personne> youngestMen = listeHommes.stream()
				.collect(Collectors.groupingBy(e -> e.getAge(), TreeMap::new, Collectors.toList()))
				.firstEntry().getValue();

		oldestWoman = oldestWomen.get(0);
		youngestMan = youngestMen.get(0);

		Double distance = srvAnalyse.getDistance(oldestWoman, youngestMan);

		System.out.println("La distance entre la femme la plus âgée (" 
				+ oldestWoman.getPrenom() + " " + oldestWoman.getNom()+ ", " + oldestWoman.getAge() + " ans" + ")"
				+ " et l'homme le plus jeune (" + youngestMan.getPrenom() + " " + youngestMan.getNom() + ", " + youngestMan.getAge() + " ans" + ") "
				+ "est de " + Math.round(distance) + " kms. ");

	}


}
