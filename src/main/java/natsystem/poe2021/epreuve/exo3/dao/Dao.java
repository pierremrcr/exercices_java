package natsystem.poe2021.epreuve.exo3.dao;

import java.util.List;

import natsystem.poe2021.epreuve.exo3.exceptions.PersistenceException;

public interface Dao <T> {
	
	List<T> loadAll() throws PersistenceException;

}
