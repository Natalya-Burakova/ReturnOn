package dao;

public interface CRUDDao <T> {
    int save(T model);
    int update(T model);
    int delete(T model);
}