package br.udesc.ceavi.designpatterns.projetopratico.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {

	T insert(T object) throws SQLException;

	int delete(T object) throws SQLException;

	List<T> findAll() throws SQLException;

	T findById(Long id) throws SQLException;
	
}
