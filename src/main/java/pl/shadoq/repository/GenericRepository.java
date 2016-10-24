package pl.shadoq.repository;

/**
 * Created by Jan on 2015-10-31.
 */
public interface GenericRepository<T> {
    public Long add(T emp);
    public T get(Long id);
    public Boolean update(Long id, T emp);
    public Boolean delete(T emp);
}
