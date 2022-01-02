package lk.ijse.sipsewana.dao;

import lk.ijse.sipsewana.dao.custom.CourseDAO;
import lk.ijse.sipsewana.dao.custom.impl.CourseDAOImpl;
import lk.ijse.sipsewana.dao.custom.impl.QueryDAOImpl;
import lk.ijse.sipsewana.dao.custom.impl.RegisterDAOImpl;
import lk.ijse.sipsewana.dao.custom.impl.StudentDAOImpl;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 12/20/2021
 * @month : 12
 * @year : 2021
 * @since : 0.1.0
 **/
public class DAOFactory {

    public enum DAOType{
        COURSE,STUDENT,REGISTRATION,QUERY
    }
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        return (daoFactory != null) ? daoFactory : (daoFactory = new DAOFactory());
    }
    public <T extends SuperDAO> T getDAO(DAOType daoType){
        switch (daoType){
            case COURSE:
                return (T) new CourseDAOImpl();
            case STUDENT:
                return (T) new StudentDAOImpl();
            case REGISTRATION:
                return (T) new RegisterDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            default:
                return null;
        }
    }
}
