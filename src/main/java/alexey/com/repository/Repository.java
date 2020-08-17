package alexey.com.repository;

import java.util.List;

public interface Repository<T,E>{
    void create(T entity);
    T read(E key);
    void update(T entity);
    void delete(T entity);
    List<T> getAll();

}
