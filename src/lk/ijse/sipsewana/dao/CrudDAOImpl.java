package lk.ijse.sipsewana.dao;

import lk.ijse.sipsewana.entity.SuperEntity;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 12/28/2021
 * @month : 12
 * @year : 2021
 * @since : 0.1.0
 **/
public class CrudDAOImpl <T extends SuperEntity, ID extends Serializable> implements CrudDAO<T,ID> {
    protected Session session;
    private Class <T> entity;

    public CrudDAOImpl() {
        entity = (Class<T>)(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
    }

    @Override
    public boolean add(T entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(ID id) throws Exception {
        return false;
    }

    @Override
    public boolean update(T entity) throws Exception {
        return false;
    }

    @Override
    public T search(ID id) throws Exception {
        return session.get(entity, id);
    }

    @Override
    public ArrayList getAll() throws Exception {
        return (ArrayList) session.createQuery("FROM "+entity.getName()).list();
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}
