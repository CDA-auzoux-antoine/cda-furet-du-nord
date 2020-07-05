package cda.libraire.idao.implementation;

import java.util.List;

public interface IDao<T> {
	T create(T t);

	T update(T t);

	void delete(T t);

	T find(String id);

	List<T> selectAll();
}
