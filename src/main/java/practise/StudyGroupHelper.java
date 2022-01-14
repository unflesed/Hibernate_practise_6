package practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudyGroupHelper {
    private SessionFactory sessionFactory;

    public StudyGroupHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<StudyGroupEntity> listOfGroups(){
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<StudyGroupEntity> cq = cb.createQuery(StudyGroupEntity.class);

        Root<StudyGroupEntity> root = cq.from(StudyGroupEntity.class);

        cq.select(root);

        Query query = session.createQuery(cq);

        List<StudyGroupEntity> groups = query.getResultList();

        session.close();

        return groups;

    }

}
