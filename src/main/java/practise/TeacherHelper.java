package practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

public class TeacherHelper {
    private SessionFactory sessionFactory;

    public TeacherHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<TeacherEntity> listOfTeachers(){
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<TeacherEntity> cq = cb.createQuery(TeacherEntity.class);

        Root<TeacherEntity> root = cq.from(TeacherEntity.class);

        Selection[] selections = {root.get("name"), root.get("phoneNumber")};

        cq.select(cb.construct(TeacherEntity.class, selections))
                .where(cb.equal(root.get("lastName"), "LastName2"));

        Query query = session.createQuery(cq);

        List<TeacherEntity> list = query.getResultList();

        session.close();

        return list;
    }

    public void deleteById(long id){
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        TeacherEntity teacher = session.get(TeacherEntity.class, id);

        session.delete(teacher);

        session.getTransaction().commit();

        session.close();
    }

    public  void deleteCriteria(){
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<TeacherEntity> cd = cb.createCriteriaDelete(TeacherEntity.class);

        Root<TeacherEntity> root = cd.from(TeacherEntity.class);

        cd.where(root.get("name").in("name1", "name4"));

        Query query = session.createQuery(cd);

        int deleted = query.executeUpdate();

        System.out.println("Удалено: " + deleted);

        session.getTransaction().commit();

        session.close();
    }
}
