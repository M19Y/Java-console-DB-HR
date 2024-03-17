package belajar.mvc.jdbc.daos;

import java.util.List;

public interface DAO<T, ID> {

  List<T> getAll();

  T findById(ID id);

  List<T> searchByName(String name);

  boolean searchName(String name);

  void create(T t);

  void delete(ID id);

  void update(T t);
}
