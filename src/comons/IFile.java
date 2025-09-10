package comons;

import java.io.IOException;
import java.util.List;

public interface IFile<T> {

    List<T> load();
    void Save(List<T> list) ;
    T GetOne(String id) ;
    List<T> GetAll() ;
    void Delete(String id) ;
    void Update(T entity) ;
}

