package lk.ijse.sipsewana.dao;

import lk.ijse.sipsewana.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 12/20/2021
 * @month : 12
 * @year : 2021
 * @since : 0.1.0
 **/
public interface CrudDAO <Entity extends SuperEntity, ID extends Serializable> extends SuperDAO {
    boolean add(Entity entity) throws Exception;
    boolean delete(ID id) throws Exception;
    boolean update(Entity entity) throws Exception;
    Entity search(ID id) throws Exception;
    List getAll() throws Exception;
}
