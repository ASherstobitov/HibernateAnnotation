package alexey.com.repository;

import alexey.com.HibernateUtil;
import alexey.com.Person;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class PersonRepository implements Repository<Person, Integer> {


    public void create(Person entity) {

    }

    @Override
    public Person read(Integer key) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Person person;
        try (Session session = sessionFactory.openSession()) {
            person = session.get(Person.class, key);
        }
        return person;
    }

    public void update(Person entity) {

    }

    public void delete(Person entity) {

    }

    @Override
    public List<Person> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Person> cr = cb.createQuery(Person.class);
            Root<Person> root = cr.from(Person.class);
            cr.select(root);

            Query<Person> query = session.createQuery(cr);
            List<Person> results = query.getResultList();

            return results;
        }
    }

    public List<Person> getPeopleWithSalaryLess(final int salary) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Person> cr = cb.createQuery(Person.class);
            Root<Person> root = cr.from(Person.class);
            cr.select(root).where(cb.gt((Expression) root.get("salary"), salary));

            Query<Person> query = session.createQuery(cr);
            List<Person> results = query.getResultList();

            return results;
        }


    }


    public List<Person> listDevelopers(final int salary) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Person person;
        try (Session session = sessionFactory.openSession()) {

            Criteria criteria = session.createCriteria(Person.class);
            criteria.add(Restrictions.lt("salary", salary));

            List<Person> people = criteria.list();
            return people;
        }
    }
}



