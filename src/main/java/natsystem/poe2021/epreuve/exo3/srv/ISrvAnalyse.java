package natsystem.poe2021.epreuve.exo3.srv;

import java.util.List;
import java.util.Map;

import natsystem.poe2021.epreuve.exo3.datamodel.Personne;
import natsystem.poe2021.epreuve.exo3.datamodel.Sexe;
import natsystem.poe2021.epreuve.exo3.exceptions.EntiteException;
import natsystem.poe2021.epreuve.exo3.exceptions.PersistenceException;

public interface ISrvAnalyse {

	Double moyenneAge(List<Personne> listPersonnes);

	Map<Sexe,Double> moyenneAgeParSexe(List<Personne> listPersonnes);

	Map<String, Integer> nombrePersonnesParVille(List<Personne> listPersonnesParVille);

	List<Personne> getListePersonnes() throws PersistenceException;

	List<Personne> getListeHommes(List<Personne> listePersonnes) throws PersistenceException;

	List<Personne> getListeFemmes(List<Personne> listPersonnes) throws PersistenceException;

	List<Personne> getListeFemmes() throws PersistenceException;

	List<Personne> getListeHommes() throws PersistenceException;

	Double getDistance(Personne p1, Personne p2) throws PersistenceException, EntiteException;

	int nombreVillesDepuisNomPersonne(List<Personne> listPersonnes, String nom);

}
