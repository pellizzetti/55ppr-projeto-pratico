package br.udesc.ceavi.designpatterns.projetopratico.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.udesc.ceavi.designpatterns.projetopratico.models.Customer;

public interface GenericDao<T> {

	public T insert(T object) throws SQLException;

	public int delete(T object) throws SQLException;

	public List<T> findAll() throws SQLException;

	public T findById(Long id) throws SQLException;
}
