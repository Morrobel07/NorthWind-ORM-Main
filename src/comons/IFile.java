package comons;

import java.util.List;

public interface IFile<T, S> {

    List<T> list();
    void persist(List<T> list ) ;
    void add(T entity)  ;
    T findById(S id) ;
    void delete(S id) ;
    void update(T entity) ;
}

