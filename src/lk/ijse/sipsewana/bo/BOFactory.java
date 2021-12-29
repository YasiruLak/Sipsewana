package lk.ijse.sipsewana.bo;

import lk.ijse.sipsewana.bo.custom.impl.CourseBOImpl;
import lk.ijse.sipsewana.bo.custom.impl.StudentBOImpl;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 12/20/2021
 * @month : 12
 * @year : 2021
 * @since : 0.1.0
 **/
public class BOFactory {

    public enum BOType{
        COURSE, STUDENT
    }

    private static BOFactory boFactory;

    private BOFactory(){

    }
    public static BOFactory getBoFactory(){
        return (boFactory != null) ? boFactory : (boFactory = new BOFactory());
    }

    public <T extends SuperBO> T getBO(BOType boType) {
        switch (boType){
            case COURSE:
                return (T) new CourseBOImpl();
            case STUDENT:
                return (T) new StudentBOImpl();
            default:
                return null;
        }
    }
}
