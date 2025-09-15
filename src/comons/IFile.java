package comons;

import java.io.IOException;
import java.util.List;

public interface IFile<T, S> {

    List<T> list();
    void persist(T entity) ;
    T findById(S id) ;
    void delete(S id) ;
    void update(T entity) ;
}

