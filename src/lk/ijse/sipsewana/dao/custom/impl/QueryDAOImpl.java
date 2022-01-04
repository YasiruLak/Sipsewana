package lk.ijse.sipsewana.dao.custom.impl;

import lk.ijse.sipsewana.dao.custom.QueryDAO;
import lk.ijse.sipsewana.dto.CustomDTO;
import lk.ijse.sipsewana.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 1/1/2022
 * @month : 01
 * @year : 2022
 * @since : 0.1.0
 **/
public class QueryDAOImpl implements QueryDAO {
    @Override
    public void setSession(Session session) {

    }

    @Override
    public ArrayList<CustomDTO> getAll() {

        ArrayList<CustomDTO> allDetails = new ArrayList();

        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        NativeQuery query = session.createSQLQuery
                ("SELECT r.regId,s.nicNo,s.sName,c.id,c.name,r.regDate FROM Registration r INNER JOIN Student s ON r.student_nicNo=s.nicNo INNER JOIN Course c ON r.course_id=c.id");

        ArrayList<Object[]> details = (ArrayList<Object[]>) query.list();

        transaction.commit();

        session.close();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        for (Object[] temp:details) {
            allDetails.add(new CustomDTO(
                    (String) temp[0],
                    (String) temp[1],
                    (String) temp[2],
                    (String) temp[3],
                    (String) temp[4],
                    LocalDate.parse(df.format(temp[5]))
            ));
        }
        return allDetails;
    }

    @Override
    public List<CustomDTO> searchDetail(String s) {
        ArrayList<CustomDTO> allDetails = new ArrayList();

        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        List<Object[]> details = session.createSQLQuery("SELECT r.regId,s.nicNo,s.sName,c.id,c.name,r.RegDate FROM  Registration r INNER JOIN Student s ON r. student_nicNo=s.nicNo INNER JOIN course c ON r. course_id=c.id WHERE id LIKE '%" + s + "%' or c.name LIKE '%" + s + "%' ").list();

        transaction.commit();

        session.close();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        for (Object[] temp:details) {
            allDetails.add(new CustomDTO(
                    (String) temp[0],
                    (String) temp[1],
                    (String) temp[2],
                    (String) temp[3],
                    (String) temp[4],
                    LocalDate.parse(df.format(temp[5]))
            ));
        }

        return allDetails;
    }
}
